
import dao.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class Program {
	
	public static void selectShowAll(Iterable<Person> personList){
		for (Person p : personList){
			System.out.println(p.toString());
		}
	}

	public static void main(String[] args) throws SQLException {
		
		Person_DAOH2 data = new Person_DAOH2();
		ArrayList<Person> personList = null;
		
		try {
			data.delete(new Person(0));
			personList = (ArrayList<Person>) data.read();
			data.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		selectShowAll(personList);
	}

}
