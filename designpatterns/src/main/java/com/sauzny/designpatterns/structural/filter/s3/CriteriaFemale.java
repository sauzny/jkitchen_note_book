package com.sauzny.designpatterns.structural.filter.s3;

import java.util.ArrayList;
import java.util.List;

import com.sauzny.designpatterns.structural.filter.s1.Person;
import com.sauzny.designpatterns.structural.filter.s2.Criteria;

public class CriteriaFemale implements Criteria {

	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> femalePersons = new ArrayList<Person>();
		for (Person person : persons) {
			if (person.getGender().equalsIgnoreCase("FEMALE")) {
				femalePersons.add(person);
			}
		}
		return femalePersons;
	}
}
