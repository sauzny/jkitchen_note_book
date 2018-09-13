package com.sauzny.designpatterns.behavioral.template.s2;

import com.sauzny.designpatterns.behavioral.template.s1.Game;

public class Football extends Game {

	@Override
	public void endPlay() {
		System.out.println("Football Game Finished!");
	}

	@Override
	public void initialize() {
		System.out.println("Football Game Initialized! Start playing.");
	}

	@Override
	public void startPlay() {
		System.out.println("Football Game Started. Enjoy the game!");
	}
}
