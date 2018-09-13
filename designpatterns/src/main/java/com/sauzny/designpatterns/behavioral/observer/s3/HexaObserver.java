package com.sauzny.designpatterns.behavioral.observer.s3;

import com.sauzny.designpatterns.behavioral.observer.s1.Subject;
import com.sauzny.designpatterns.behavioral.observer.s2.Observer;

public class HexaObserver extends Observer {

	public HexaObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
	}
}