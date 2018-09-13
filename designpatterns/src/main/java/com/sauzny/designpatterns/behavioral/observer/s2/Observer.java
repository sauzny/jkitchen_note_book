package com.sauzny.designpatterns.behavioral.observer.s2;

import com.sauzny.designpatterns.behavioral.observer.s1.Subject;

public abstract class Observer {
	
	protected Subject subject;

	public abstract void update();
}
