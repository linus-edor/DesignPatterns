package com.patterns.singleton;

import java.util.concurrent.atomic.AtomicInteger;

public class AddData {

	private final AtomicInteger count = new AtomicInteger();

	public void initialize(int number) {
		count.set(number);
		MySingleton.getInstance().addData(count.get());
	}

	public void addOne() {
		count.incrementAndGet();
		MySingleton.getInstance().addData(count.get());
	}

}