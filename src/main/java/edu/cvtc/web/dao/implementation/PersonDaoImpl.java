package edu.cvtc.web.dao.implementation;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import edu.cvtc.web.dao.PersonDao;
import edu.cvtc.web.model.Person;
import edu.cvtc.web.util.DBUtility;
import edu.cvtc.web.util.WorkbookUtility;

public class PersonDaoImpl implements PersonDao {

	private static final String DROP_TABLE_PERSON = "drop table if exists person;";
	private static final String CREATE_TABLE_PERSON = "create table person(id integer primary key autoincrement, firstName text, lastName text, age integer, favoriteColor text);";
	private static final String	SELECT_ALL_FROM_PERSON = "select * from person;"; 
	
	@Override
	public void populate(final String filePath) throws PersonDaoException {
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			statement.executeUpdate(DROP_TABLE_PERSON);
			statement.executeUpdate(CREATE_TABLE_PERSON);
			
			// Populate person table using WorkbookUtility
			final File inputFile = new File(filePath);
			final List<Person> people = WorkbookUtility.retrievePeopleFromWorkbook(inputFile);
			
			for(final Person person: people) {
				final String insertValues = "insert into person (firstName, lastName, age, favoriteColor) "
						+ "values ('" + person.getFirstName() + "', "
								+ "'" + person.getLastName() + "', "
								+ "'" + person.getAge() +"', "
								+ "'" + person.getFavoriteColor() +"');";
				System.out.println(insertValues); //NOTES:Log a message to the console so we can see data being added.
				
				statement.executeUpdate(insertValues);
			}
				
		} catch (ClassNotFoundException | SQLException | InvalidFormatException | IOException e) {
			e.printStackTrace();
			throw new PersonDaoException("Error: Unable to populate database.");
		} finally {
			DBUtility.closeConnections(connection, statement);
		}
	}

	@Override
	public List<Person> retrievePeople() throws PersonDaoException {
		final List<Person> people = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);

			final ResultSet resultSet = statement.executeQuery(SELECT_ALL_FROM_PERSON);
			
			while (resultSet.next()) {
				
				final String firstName = resultSet.getString("firstName");
				final String lastName = resultSet.getString("lastName");
				final int age = resultSet.getInt("age");
				final String favoriteColor = resultSet.getString("favoriteColor");
				
				people.add(new Person(firstName, lastName, age, favoriteColor));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new PersonDaoException("Error: Unable to retrieve people.");
		} finally{
			DBUtility.closeConnections(connection, statement);
		}
		return people;
	}

	@Override
	public void insertPerson(Person person) throws PersonDaoException {
		Connection connection = null;
		PreparedStatement insertStatement = null;
		
		try{
			
			connection = DBUtility.createConnection();
			
			final String sqlStatement = "insert into person (firstName, lastName, age, favoriteColor) values (?,?,?,?);";
			insertStatement = connection.prepareStatement(sqlStatement);
			
			insertStatement.setString(1,  person.getFirstName());
			insertStatement.setString(2,  person.getLastName());
			insertStatement.setInt(3,  person.getAge());
			insertStatement.setString(4,  person.getFavoriteColor());
			
			insertStatement.setQueryTimeout(DBUtility.TIMEOUT);
			
			insertStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtility.closeConnections(connection, insertStatement);
		}

	}

}
