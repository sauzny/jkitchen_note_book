package com.sauzny.designpatterns.structural.filter.s2;

import java.util.List;

import com.sauzny.designpatterns.structural.filter.s1.Person;

public interface Criteria {
	List<Person> meetCriteria(List<Person> persons);
}
