package com.sauzny.designpatterns.behavioral.iterator;

import com.sauzny.designpatterns.behavioral.iterator.s1.Iterator;
import com.sauzny.designpatterns.behavioral.iterator.s2.NameRepository;

public class IteratorPatternDemo {
    
    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();
        
        for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
           String name = (String)iter.next();
           System.out.println("Name : " + name);
        } 
	}
}
