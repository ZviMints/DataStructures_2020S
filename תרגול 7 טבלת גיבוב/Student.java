package S6;

public class Student {
	private String _name;
	private int _age;
	public Student(String _name, int _age) {
		this._name = _name;
		this._age = _age;
	}
	public String toString() {
		return "[" + _name + "," + _age + "]";
	}
	
}
