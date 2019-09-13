package com.patterns.factory;

public abstract interface Drawing {
	public int length = 10;
	public int radius = 10;
	public int breadth = 5;

	abstract int getArea();
}