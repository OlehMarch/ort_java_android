package dao;
import java.util.ArrayList;
import java.sql.*;

public class Person_DAOH2 implements PersonDAO {

	private ArrayList<Person> personList;
	private Connection connection;
	
	public Person_DAOH2() throws SQLException {
		personList = new ArrayList<>();
		connection = DriverManager.
	            getConnection("jdbc:h2:~/test", "sa", "");
	}

	@Override
	public void create(Person persona) throws SQLException {
		Statement state = null;
        state = connection.createStatement();
        state.execute(String.format("INSERT INTO PERSON(ID, FirstName, LastName, Age) VALUES(%d, '%s', '%s', %d)",
        		persona.getId(), persona.getFirstName(), persona.getLastName(), persona.getAge()));
	}

	@Override
	public Iterable<Person> read() throws SQLException {
		
        Statement st = null;
        st = connection.createStatement();
        personList.clear();
       
        ResultSet result = st.executeQuery("SELECT * FROM PERSON");
        while (result.next() == true) {
        personList.add(new Person(
        		result.getInt("ID"),
        		result.getString("FirstName"),
        		result.getString("LastName"),
        		result.getInt("Age")
        		));
        }
		return personList;
	}

	@Override
	public void update(Person persona) throws SQLException {
		Statement state = null;
        state = connection.createStatement();
        state.execute(String.format("UPDATE PERSON SET FirstName = '%s', LastName = '%s', Age = %d WHERE ID = %d",
        		persona.getFirstName(), persona.getLastName(), persona.getAge(), persona.getId()));
	}

	@Override
	public void delete(Person persona) throws SQLException {
		Statement state = null;
        state = connection.createStatement();
        state.execute(String.format("DELETE FROM PERSON WHERE ID = %d",
        		persona.getId()));
	}
	
	public void closeConnection() throws SQLException{
		this.connection.close();
	}
	
}
