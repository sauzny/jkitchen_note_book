package com.sauzny.designpatterns.behavioral.visitor.s2;

import com.sauzny.designpatterns.behavioral.visitor.s1.ComputerPart;
import com.sauzny.designpatterns.behavioral.visitor.s3.ComputerPartVisitor;

public class Monitor implements ComputerPart {

	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		computerPartVisitor.visit(this);
	}
}
