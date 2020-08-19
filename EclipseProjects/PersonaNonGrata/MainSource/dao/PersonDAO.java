
package dao;

import java.sql.SQLException;

public interface PersonDAO {

	void create(Person persona) throws SQLException;
	Iterable<Person> read() throws SQLException;
	void update(Person persona) throws SQLException;
	void delete(Person persona) throws SQLException;
	
}
