package com.patterns.factory;

public class DrawingFactory {

	// Supply a calling class with the appropriate instance of Drawing depending
	// on the
	// parameter drawingType
	public Drawing getDrawing(String drawingType) {
		if ("Circle".equalsIgnoreCase(drawingType))
			return new Circle();
		else if ("Square".equalsIgnoreCase(drawingType))
			return new Square();
		else if ("Rectangle".equalsIgnoreCase(drawingType))
			return new Rectangle();
		// Type not found
		return null;
	}
}