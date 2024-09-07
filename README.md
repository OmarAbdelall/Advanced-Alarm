# Advanced-Alarm
Advanced Alarm is a Java-based project from my first year of university, featuring a GUI, graphics, threads, and a server. The project integrates multi-threading and server communication, applying concepts learned in class to create a more advanced and functional alarm system.

##Table of Contents
### [Introduction](#introduction)  <br>
### [Features](#features)  <br>
### [Prerequisites](#prerequisites) <br>
### [Project Structure](#project_structure) <br>
### [Classes Overview](#Classes_Overview)<br>
### [Usage](#Usage) <br>
### [Notes](#Notes) <br> 

## Introduction
The Advanced Alarm project demonstrates a variety of Java programming concepts, including GUI development with Swing, multithreading, and basic networking using sockets.<br>
The alarm system has several components like a Stopwatch, a Loading animation, and a Ring function that triggers sound playback when the timer runs out.<br>

## Features
* Stopwatch: A timer that counts down from user-specified hours, minutes, and seconds.<br>
* Loading Animation: A graphical animation showing a moving green ball.<br>
* Alarm Ringing: Plays a sound when the timer reaches zero.<br>
* Client-Server Communication: The server sends a message allowing the client to set a timer.<br>

## Prerequisites
The following software and libraries are required to run the project:<br>
* Java Development Kit (JDK)<br>
* Java Swing (for GUI components)<br>
* javax.sound.sampled (for sound playing)<br>

## Project Structure
The project contains the following classes:<br>

* Loading.java: Displays a moving green ball animation in a JFrame.<br>
* Ring.java: Plays a sound file (TimeUp.wav) when called.<br>
* Stopwatch.java: Implements a stopwatch with start, stop, reset, and exit functionalities.<br>
* Server.java: A simple server that communicates with a client to send and receive messages about the timer setup.<br>


## Classes Overview
1. Loading Class:
* Implements a JPanel with a ball moving horizontally across the window.<br>
* Uses a separate thread to handle the ball's movement.<br>
* Displays within a JFrame and closes automatically after completing its animation.<br>
2. Ring Class:
* Plays a .wav sound file using Java's AudioInputStream and Clip classes.<br>
* Waits for user input to stop the sound after it's triggered.<br>
3. Stopwatch Class:
* A GUI-based timer that counts down from a user-defined time.<br>
* Provides buttons for starting, stopping, resetting, and exiting.<br>
* Displays the remaining time in HH:MM:SS format.<br>
* Automatically triggers the alarm sound when the timer reaches zero.<br>
4. Server Class:
* Sets up a simple server using ServerSocket to communicate with clients.<br>
* Sends messages to the client allowing them to set a timer on the alarm.<br>
* Runs in a separate thread to handle connections and messages asynchronously.<br>

## Usage

To run the project, follow these steps:<br>
1- Clone the repository:
```
git clone https://github.com/OmarAbdelall/NSL-KDD.git 
cd Advanced-Alarm
```
2- Compile the Java files.
