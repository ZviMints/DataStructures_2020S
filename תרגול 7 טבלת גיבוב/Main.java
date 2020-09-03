package S6;

public class Main {
	static class Person {
		private long _id;
		private int _score;
		public Person(long _id, int _score) {
			this._id = _id;
			this._score = _score;
		}
		public String toString() { 
			return "("+this._id + ","+this._score+")";
		}
	}

	public static void main(String[] args) {
		Hashtable<Integer,Person> map = new Hashtable<>();
		Person p1 = new Person(111111111,95);
		Person p2 = new Person(222222222,85);
		Person p3 = new Person(333333333,75);

		map.put(1,p1);
		map.put(2,p2);
		map.put(3,p3);

		System.out.println(map.isEmpty()); // false
		System.out.println(map.isEmpty()); // false
		System.out.println(map.remove(1)); // (111111111,95)
		map.put(2, p3); // Do bothing ( key UNIQUE )
		System.out.println(map.containsKey(2)); // true
		System.out.println(map.containsKey(p2)); // false
		System.out.println(map.containsValue(2)); // false
		System.out.println(map.containsValue(p3)); // true

		System.out.println(map); // {3=(333333333,75), 2=(222222222,85)}

	}


}
