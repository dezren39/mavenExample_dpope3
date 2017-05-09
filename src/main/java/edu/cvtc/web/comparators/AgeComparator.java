/**
 * 
 */
package edu.cvtc.web.comparators;

import java.util.Comparator;

import edu.cvtc.web.model.Person;

/**
 * @author drewr
 *
 */
public class AgeComparator implements Comparator<Person>{

	@Override
	public int compare(Person person1, Person person2) {
		return person1.getAge().compareTo(person2.getAge());
	}
}
