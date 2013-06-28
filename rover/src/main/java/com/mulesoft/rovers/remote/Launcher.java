package com.mulesoft.rovers.remote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.mulesoft.rovers.BoundedAxis;
import com.mulesoft.rovers.Heading;
import com.mulesoft.rovers.MarsRover;
import com.mulesoft.rovers.Position;
import com.mulesoft.rovers.exceptions.MarsRoverException;

public class Launcher {

	public static void main(final String[] args) throws IOException {

		TelnetServer server = null;

		if(args.length > 0) {
			server = new TelnetServer(Integer.valueOf(args[0]));
		} else {
			System.err.println("You must provide a port");
			System.exit(-1);
		}

		while(true) {
			Socket socket = server.accept();

			System.out.println("Client Connected!");

			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

			reader.skip(21);	// skip character codes
			String[] limits = reader.readLine().split(" ");
			String[] position = reader.readLine().split(" ");

			try {
				BoundedAxis xAxis = new BoundedAxis(Integer.valueOf(position[0].trim()), Integer.valueOf(limits[0].trim()));
				BoundedAxis yAxis = new BoundedAxis(Integer.valueOf(position[1].trim()), Integer.valueOf(limits[1].trim()));
				Heading heading = new Heading(position[2].trim().charAt(0));
				Position initialPosition = new Position(xAxis, yAxis, heading);

				System.out.println("Initial rover position decoded.");

				MarsRover rover = new MarsRover(initialPosition);

				rover.processInstructions(reader.readLine().trim());

				System.out.println("Mars Rover: instructions processed successfully!");
				System.out.println("New position: " + initialPosition.toString());

			} catch (NumberFormatException e) {
				System.err.println("Unable to decode values!");
			} catch (MarsRoverException e) {
				System.err.println("Unable to perform operation!");
			}
		}
	}
}
