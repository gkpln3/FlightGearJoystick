# FlightGearJoystick
this android application demonstrates the use of the Joystick API that we created.
The project is designed with the **MVVM** design pattern.

## Application Features
- Connecting to a FlightGear client
- Controlling the airplane with JoySitck and sliders

## Design 
- Implemented using **MVVM** design pattern
### View:
- A single Activity app with a connection interfacce and a Joystick to control the airplane
### ViewModel:
- Contains all the databining. hold a reference to the model
- Sends data to the model from the view when needed
### Model:
- Holds the TcpClient to connect to the FlightGear Program
- Holds all the functions for controlling the aircraft
- The communication is made using a task queue and a threadPool to handle task execution.
  so each task is executed and sent to the client

## FlightGear Simulator 
[Link] https://www.flightgear.org/

## Video
[Link] https://youtu.be/8keb6iJ3IH4

## Class diagram:
[Link] https://i.ibb.co/gvghKGm/Main.jpg
