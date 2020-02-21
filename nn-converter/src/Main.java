import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * This class simply launches and configures the server.
 * I referred: https://stackoverflow.com/questions/3732109/simple-http-server-in-java-using-only-java-se-api
 * in developing a simple server for the number to numeral conversion.
 *
 * Developer: Abhi Dubal
 * Purpose: AEM Assessment
 * Date: Feb 20, 2020
 */
public class Main {

    /**
     * The main method is responsible for creating the HTTP server.
     */
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        System.out.println("The server is running.");

        // Handle context with no path, give info about server
        server.createContext("/info", new ProjectInfoHandler());
        server.createContext("/romannumeral", new RomanNumeralHandler());

        server.setExecutor(null); // creates a default executor
        server.start();

    }

    /**
     * This class is a handler that associated with the "/info" context. Essentially, when the
     * client launches https://localhost:8080, a webpage giving information on how to navigate the web client is
     * shown.
     */
    static class ProjectInfoHandler implements HttpHandler {
        public void handle(HttpExchange httpExchange) throws IOException {

            String response = "<!DOCTYPE html>" +
                    "<html><body><h1>AEM Assessment</h1>\n" +
                    "<p> This endpoint is designed to handle properly formatted requests from a client. \n" +
                    "Some of the requests include:</p>" +
                    "<ul>" +
                    "<li> /info - gives additional information about the project </li>" +
                    "<li> /romannumeral?query=YOUR INTEGER - converts YOUR INTEGER (1-255) to a roman numeral. </li>" +
                    "</ul>" +
                    "<p>Created by Abhi Dubal on February 20, 2020.</p>" +
                    "</body></html>";

            Main.writeResponse(httpExchange, response);
        }
    }

    /**
     * This class is a handler that associated with the "/romannumeral" context. This class will parse the integer
     * associated with the URL and convert it to its respective roman numeral.
     */
    static class RomanNumeralHandler implements HttpHandler {
        public void handle(HttpExchange httpExchange) throws IOException {

            Converter converter = new Converter();
            Map <String,String> parameters = Main.queryToMap(httpExchange.getRequestURI().getQuery());
            String conversion = converter.integerToRomanNumeral(parameters.get("query"));

            // If the input is a non-integer
            if (conversion.equals("ERROR"))
            {
                String response = "<html><h1>A non-integer value was inputted!</h1></html>";
                Main.writeBadRequest(httpExchange, response);
            }
            // If the integer is out of range
            else if (conversion.equals("OUT OF RANGE"))
            {
                String response = "<html><h1> The number you inputted is out of range for conversion. Please input a number " +
                        "between 1-255. </h1></html>";
                Main.writeBadRequest(httpExchange, response);
            }
            // If the integer is in range, send the Roman Numeral to the server
            else
            {
                String response = "<html><h1> The number " + parameters.get("query") + " in Roman Numerals is "
                        + conversion + "</h1></html>";
                Main.writeResponse(httpExchange, response);
            }
        }
    }

    /**
     * This method is responsible for outputting the given response from the server.
     * @param httpExchange
     * @param response
     * @throws IOException
     */
    public static void writeResponse(HttpExchange httpExchange, String response) throws IOException {
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    /**
     * This method is responsible for outputting the given response from the server.
     * @param httpExchange
     * @param response
     * @throws IOException
     */
    public static void writeBadRequest(HttpExchange httpExchange, String response) throws IOException {
        httpExchange.sendResponseHeaders(400, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    /**
     * returns the url parameters in a map
     * @param query
     * @return map
     */
    public static Map<String, String> queryToMap(String query)
    {
        Map<String, String> result = new HashMap<>();
        String pair[] = query.split("=");
        if (pair.length>1)
        {
            result.put(pair[0], pair[1]);
        }
        else
        {
            result.put(pair[0], "");
        }
        return result;
    }
}
