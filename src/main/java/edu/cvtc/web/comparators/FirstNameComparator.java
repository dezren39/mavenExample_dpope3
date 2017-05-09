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
public class FirstNameComparator implements Comparator<Person>{

	@Override
	public int compare(Person person1, Person person2) {
		return person1.getFirstName().compareTo(person2.getFirstName());
	}
}
