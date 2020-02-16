package com.patterns.prototype;

public class Rectangle extends Shape {

	public int w;
	public int h;

	public Rectangle() {
	}

	// Copy constructor
	private Rectangle(Rectangle target) {
		super(target);
		if (target != null) {
			this.w = target.w;
			this.h = target.h;
		}
	}

	@Override
	public Shape clone() {
		return new Rectangle(this);
	}

	@Override
	public boolean equals(Object target) {
		if (!(target instanceof Rectangle) || !super.equals(target))
			return false;
		Rectangle rectangle1 = (Rectangle) target;
		return this.w == rectangle1.w && this.h == rectangle1.h;
	}

}
