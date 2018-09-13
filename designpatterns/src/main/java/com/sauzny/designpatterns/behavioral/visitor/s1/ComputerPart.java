package com.sauzny.designpatterns.behavioral.visitor.s1;

import com.sauzny.designpatterns.behavioral.visitor.s3.ComputerPartVisitor;

public interface ComputerPart {
	void accept(ComputerPartVisitor computerPartVisitor);
}
