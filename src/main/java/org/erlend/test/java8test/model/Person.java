package org.erlend.test.java8test.model;

public class Person {
	public static double failLimit = 4.0d;

	private String name;

	private int age;

	private Double grade;

	private Gender gender;

	public Person(String name, int age, Double grade, Gender gender) {
		super();
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}


	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public boolean isFailing() {
		return grade > failLimit;
	}
}
