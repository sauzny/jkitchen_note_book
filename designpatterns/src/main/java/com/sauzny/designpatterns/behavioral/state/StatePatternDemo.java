package com.sauzny.designpatterns.behavioral.state;

import com.sauzny.designpatterns.behavioral.state.s2.StartState;
import com.sauzny.designpatterns.behavioral.state.s2.StopState;
import com.sauzny.designpatterns.behavioral.state.s3.Context;

public class StatePatternDemo {

	public static void main(String[] args) {
		Context context = new Context();

		StartState startState = new StartState();
		startState.doAction(context);

		System.out.println(context.getState().toString());

		StopState stopState = new StopState();
		stopState.doAction(context);

		System.out.println(context.getState().toString());
	}
}
