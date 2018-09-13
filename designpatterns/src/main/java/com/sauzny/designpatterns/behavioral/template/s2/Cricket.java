package com.sauzny.designpatterns.behavioral.template.s2;

import com.sauzny.designpatterns.behavioral.template.s1.Game;

public class Cricket extends Game {

	@Override
	public void endPlay() {
		System.out.println("Cricket Game Finished!");
	}

	@Override
	public void initialize() {
		System.out.println("Cricket Game Initialized! Start playing.");
	}

	@Override
	public void startPlay() {
		System.out.println("Cricket Game Started. Enjoy the game!");
	}
}