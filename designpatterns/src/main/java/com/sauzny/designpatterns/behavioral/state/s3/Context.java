package com.sauzny.designpatterns.behavioral.state.s3;

import com.sauzny.designpatterns.behavioral.state.s1.State;

public class Context {

	private State state;

	public Context() {
		state = null;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}
}
