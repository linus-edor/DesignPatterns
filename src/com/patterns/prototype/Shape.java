package com.patterns.prototype;

public abstract class Shape {

	public String id;
	public int x;
	public int y;

	public Shape() {

	}

	public abstract Shape clone();

	// Copy constructor
	public Shape(Shape target) {
		if (target != null) {
			this.id = target.id;
			this.x = target.x;
			this.y = target.y;
		}
	}

	@Override
	public boolean equals(Object shape) {
		if (null == shape || !(shape instanceof Shape))
			return false;
		Shape shape1 = (Shape) shape;
		return this.id == shape1.id && this.x == shape1.x && this.y == shape1.y;
	}

}
