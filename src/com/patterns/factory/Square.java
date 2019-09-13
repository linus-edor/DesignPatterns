package com.patterns.factory;

public class Square implements Drawing {

	@Override
	public int getArea() {
		return length * length;
	}

}