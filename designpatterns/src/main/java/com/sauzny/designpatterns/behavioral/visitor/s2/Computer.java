package com.sauzny.designpatterns.behavioral.visitor.s2;

import com.sauzny.designpatterns.behavioral.visitor.s1.ComputerPart;
import com.sauzny.designpatterns.behavioral.visitor.s3.ComputerPartVisitor;

public class Computer implements ComputerPart {

	ComputerPart[] parts;

	public Computer() {
		parts = new ComputerPart[] { new Mouse(), new Keyboard(), new Monitor() };
	}

	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		for (int i = 0; i < parts.length; i++) {
			parts[i].accept(computerPartVisitor);
		}
		computerPartVisitor.visit(this);
	}
}