package com.sauzny.designpatterns.structural.filter.s3;

import java.util.List;

import com.sauzny.designpatterns.structural.filter.s1.Person;
import com.sauzny.designpatterns.structural.filter.s2.Criteria;

public class AndCriteria implements Criteria {

	private Criteria criteria;
	private Criteria otherCriteria;

	public AndCriteria(Criteria criteria, Criteria otherCriteria) {
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}

	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
		return otherCriteria.meetCriteria(firstCriteriaPersons);
	}
}