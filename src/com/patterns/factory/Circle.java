package com.patterns.factory;

public class Circle implements Drawing {

	@Override
	public int getArea() {
		// Let π = 3
		return 3 * radius * radius;
	}

}