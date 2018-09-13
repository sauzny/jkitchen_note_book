package com.sauzny.designpatterns.behavioral.template;

import com.sauzny.designpatterns.behavioral.template.s1.Game;
import com.sauzny.designpatterns.behavioral.template.s2.Cricket;
import com.sauzny.designpatterns.behavioral.template.s2.Football;

public class TemplateDemo {

	public static void main(String[] args) {

		Game game = new Cricket();
		game.play();
		System.out.println();
		game = new Football();
		game.play();
	}

}
