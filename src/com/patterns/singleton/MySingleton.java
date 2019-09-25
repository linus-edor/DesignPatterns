package com.patterns.singleton;

import java.util.ArrayList;
import java.util.List;

public class MySingleton {
	private static MySingleton myInstnace = new MySingleton();

	private List<Integer> data = new ArrayList<>();

	public MySingleton() {
	}

	public static final MySingleton getInstance() {
		return myInstnace;
	}

	public void addData(int data) {
		this.data.add(data);
	}

	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}

}
