package com.sauzny.designpatterns.behavioral.memento.s3;

import java.util.ArrayList;
import java.util.List;

import com.sauzny.designpatterns.behavioral.memento.s1.Memento;

public class CareTaker {

	private List<Memento> mementoList = new ArrayList<Memento>();

	public void add(Memento state) {
		mementoList.add(state);
	}

	public Memento get(int index) {
		return mementoList.get(index);
	}
}
