package employee;

public class Employee {

	private int Id;
	private String Name;
	private int Age;
	private String Technology;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", Name=" + Name + ", Age=" + Age + ", Technology=" + Technology + "]";
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getTechnology() {
		return Technology;
	}
	public void setTechnology(String technology) {
		Technology = technology;
	}
}
