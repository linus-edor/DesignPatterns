package com.patterns.prototype;

public class Circle extends Shape {

	public int radius;

	public Circle() {
	}

	// Copy constructor
	public Circle(Circle target) {
		super(target);
		if (null != target) {
			this.radius = target.radius;
		}
	}

	@Override
	public Shape clone() {
		return new Circle(this);
	}

	public boolean equals(Object target) {
		if (!(target instanceof Circle) || !super.equals(target))
			return false;
		return this.radius == ((Circle) target).radius;
	}

}
