package com.patterns.factory;

public class Rectangle implements Drawing {

	@Override
	public int getArea() {
		return length * breadth;
	}

}