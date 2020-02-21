package converter;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.junit.jupiter.api.Test;

/**
 * This class tests the current implementation of Main (the server). 
 *
 * Developer: Abhi Dubal
 * Purpose: AEM Assessment
 * Date: Feb 20, 2020
 */
class ServerTest {

	@Test
	public void testServerForGoodIntegerInput() throws IOException 
	{  
		URL request = new URL("http://localhost:8080/romannumeral?query=10");
		HttpURLConnection connection = (HttpURLConnection)request.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		int code = connection.getResponseCode();
		assertEquals(200, code);
	}
	
	@Test
	public void testServerForBadIntegerInput() throws IOException 
	{  
		URL request = new URL("http://localhost:8080/romannumeral?query=10.5");
		HttpURLConnection connection = (HttpURLConnection)request.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		int code = connection.getResponseCode();
		assertEquals(400, code);
	}
	
	@Test
	public void testServerForBadPage() throws IOException 
	{  
		URL request = new URL("http://localhost:8080/romannumerl?query=10.5");
		HttpURLConnection connection = (HttpURLConnection)request.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		int code = connection.getResponseCode();
		assertEquals(404, code);
	}
	
	@Test
	public void testServerForGoodPage() throws IOException 
	{  
		URL request = new URL("http://localhost:8080/info");
		HttpURLConnection connection = (HttpURLConnection)request.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		int code = connection.getResponseCode();
		assertEquals(200, code);
	}
	
	
}
