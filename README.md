# NN-Conversion
An endpoint that converts integers to their Roman Numerals.

# How to build and run this project
You simply need to run Main.java to run the server.
Then you can go to your preferred browser (I tested Google Chrome) and type https://localhost:8080/info to get more info
about the project.
If you'd like to convert an integer to a Roman Numeral immediately, simply type https://localhost:8080/romannumeral?query=INTEGER

# Engineering and Testing Methodology
The design of this program was rather simple. I referenced https://stackoverflow.com/questions/3732109/simple-http-server-in-java-using-only-java-se-api
for setting up a simple server. My main goal for this assessment was to ensure my code was modular as possible (allow developers to extend this code
easily). You can easily add new paths or "contexts" for the server to recognize. Additionally, I created a Converter class that handles the integer
to Roman Numeral conversion (and can add logic for new conversions i.e Roman Numeral to Integer).

# Your packaging layout
No special packaging was needed. I simply had a Main.java that handled only server code (it knows nothing about the logic
of the integer to Roman Numerals conversion). A Converter.java class handled the integer to Roman Numeral conversion.

# Dependency Attribution
I used the "java.util" library for HashMap usage and "com.sun.net" for setting up an HTTP endpoint.
