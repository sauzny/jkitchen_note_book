package com.sauzny.designpatterns.structural.filter.s3;

import java.util.ArrayList;
import java.util.List;

import com.sauzny.designpatterns.structural.filter.s1.Person;
import com.sauzny.designpatterns.structural.filter.s2.Criteria;

public class CriteriaSingle implements Criteria {

	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> singlePersons = new ArrayList<Person>();
		for (Person person : persons) {
			if (person.getMaritalStatus().equalsIgnoreCase("SINGLE")) {
				singlePersons.add(person);
			}
		}
		return singlePersons;
	}
}
