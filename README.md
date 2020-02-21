# NN-Conversion
An endpoint that converts integers to their Roman Numerals.

# How to build and run this project
You simply need to run Main.java to run the server.
Then you can go to your preferred browser (I tested with Google Chrome) and type ```localhost:8080/info``` to get more info
about the project.
If you'd like to convert an integer to a Roman Numeral immediately, simply type ```localhost:8080/romannumeral?query=INTEGER (from 1-3999)```.

# Engineering and Testing Methodology
The design of this program was rather simple. I referenced https://stackoverflow.com/questions/3732109/simple-http-server-in-java-using-only-java-se-api
for setting up a simple server. My main goal for this assessment was to ensure my code was modular as possible (allow developers to extend this code
easily). You can easily add new paths or "contexts" for the server to recognize. Additionally, I created a Converter class that handles the integer
to Roman Numeral conversion (and can add logic for new conversions i.e Roman Numeral to Integer).

The tests for this assessment are completely automated. I test the Converter class (logical tests) in the ConverterTest.java file. In this file, I conducted
basic tests to ensure all cases of the input are being met. I then tested the Server in the ServerTest.java file. This was a rather simple test suite checking for server codes as I strived for quick and automated testing.

# Packaging layout
No special packaging was needed. I simply had a Main.java that handled only server code (it knows nothing about the logic
of the integer to Roman Numerals conversion). A Converter.java class handled the integer to Roman Numeral conversion.
A ConverterTest.java that tested the Converter.java class.
A ServertTest.java that tested the Main.java class.

# Dependency Attribution
I used the "java.util" library for HashMap usage and "com.sun.net" for setting up an HTTP endpoint.

# Extending this project
I would love to design the HTTP Endpoint to show colorful and user friendly outputs. I would extend the contexts to maybe do
Roman Numeral to integer conversion. It would be cool to do multiple conversions in the URI (add the ability to handle
multiple parameters). Also, I would complete the last two extensions for this assessment. Lastly, I would rigorously test this program
by using dependencies such as REST Assured or GitHub's REST service.
