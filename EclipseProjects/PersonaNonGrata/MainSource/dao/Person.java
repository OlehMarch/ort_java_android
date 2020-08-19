package dao;

public class Person {
	
	private int ID;
	private String FirstName;
	private String LastName;
	private int Age;
	
	public Person() {
		this.ID = 0;
		this.FirstName = null;
		this.LastName = null;
		this.Age = 0;
	}
	
	public Person(int id) 
	{
		super();
		this.ID = id;
	}
	
	public Person(int id, String fName, String lName, int age){
		ID = id;
		FirstName = fName;
		LastName = lName;
		Age = age;
	}
	
	public void setId(int id){
		this.ID = id;
	}
	
	public void setFirstName(String fName){
		this.FirstName = fName;
	}
	
	public void setLastName(String lName){
		this.LastName = lName;
	}
	
	public void setAge(int age){
		this.Age = age;
	}
	
	public int getId(){
		return this.ID;
	}
	
	public String getFirstName(){
		return this.FirstName;
	}
	
	public String getLastName(){
		return this.LastName;
	}
	
	public int getAge(){
		return this.Age;
	}
	
	@Override
	public String toString(){
		String result = null;
		result = String.format("%d, %s %s, Age = %d", ID, FirstName, LastName, Age);
		return result;
	}
	
}
