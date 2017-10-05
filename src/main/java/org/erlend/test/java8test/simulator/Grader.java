package org.erlend.test.java8test.simulator;

import static org.erlend.test.java8test.model.Gender.FEMALE;
import static org.erlend.test.java8test.model.Gender.MALE;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.erlend.test.java8test.model.Gender;
import org.erlend.test.java8test.model.Person;

public class Grader {

	private Person[] mathClass = 
		{
			new Person("Han", 20, 2.5d, MALE),
			new Person("George", 25, 2.2d, MALE),
			new Person("Luke", 31, 4.1d, MALE),
			new Person("Chewbacca", 31, 5.5d, MALE),
			new Person("Leia", 21, 1.5d, FEMALE),
			new Person("Padme", 21, 4.3d, FEMALE),
		};
	
	public OptionalDouble getAverageGrade() {
		Stream<Person> stream = Arrays.stream(mathClass);
		return stream.mapToDouble(Person::getGrade).average();
	}
		
	
	public List<Person> getMaleWithLaudGrade(){
		double laud = 2.5d;
		Stream<Person> stream = Arrays.stream(mathClass);
		return stream.filter(p -> p.getGrade() <= laud).filter(p -> p.getGender().equals(MALE)).collect(Collectors.toList());
	}
	
	public Map<Gender, List<Person>> getFailingStudentsByGender(){
		Stream<Person> stream = Arrays.stream(mathClass);
		return stream.filter(Person::isFailing).collect(Collectors.groupingBy(Person::getGender));
	}
}
