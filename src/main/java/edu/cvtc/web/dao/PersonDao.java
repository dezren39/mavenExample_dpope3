package edu.cvtc.web.dao;

import java.util.List;

import edu.cvtc.web.dao.implementation.PersonDaoException;
import edu.cvtc.web.model.Person;

public interface PersonDao {
	
	void populate(String filePath) throws PersonDaoException;
	
	List<Person> retrievePeople() throws PersonDaoException;
	
	void insertPerson(Person person) throws PersonDaoException;
	
}