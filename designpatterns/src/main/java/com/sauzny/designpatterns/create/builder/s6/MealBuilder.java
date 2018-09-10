package com.sauzny.designpatterns.create.builder.s6;

import com.sauzny.designpatterns.create.builder.s4.ChickenBurger;
import com.sauzny.designpatterns.create.builder.s4.Coke;
import com.sauzny.designpatterns.create.builder.s4.Pepsi;
import com.sauzny.designpatterns.create.builder.s4.VegBurger;
import com.sauzny.designpatterns.create.builder.s5.Meal;

public class MealBuilder {

	public Meal prepareVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
	}

	public Meal prepareNonVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;
	}
}
