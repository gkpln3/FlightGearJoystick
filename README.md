# FlightGearJoystick
this android application demonstrates the use of the Joystick API that we created.
The project is designed with the **MVVM** design pattern.

## Application Features
- Connecting to a FlightGear client
- Controlling the Airplane with JoySitck and sliders

## Design 
- implementation using **MVVM** design pattern 
### View:
- A single Activity app with a connection interfacce and a Joystick to control the airplane.
### ViewModel:
- Contains all the databining. hold a reference to the model.
- Sends data to the model from the view when needed.
### Model:
- hold the TcpClient to connect to the FlightGear Program
- holds all the functions for controlling the aircraft
- the communication is made using a task queue and a threadPool to handle task execution.
  so each task is executed and sent to the client.

## FlightGear Simulator 
[Link] https://www.flightgear.org/

## Video

## Class diagram:
[Link] https://i.ibb.co/gvghKGm/Main.jpg
