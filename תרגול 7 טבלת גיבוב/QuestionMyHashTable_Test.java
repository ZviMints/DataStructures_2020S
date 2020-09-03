package S6;

public class QuestionMyHashTable_Test {

	public static void main(String[] args) {
		Map list = new LinkedListHash(5);
		System.out.println("1:");
		System.out.println(list);
		
		Student zvi = new Student("zvi",24);
		Student or = new Student("or",24);
		Student dana = new Student("dana",24);
		Student ariel = new Student("ariel",24);
		Student ilan = new Student("ilan",24);
		Student dan = new Student("dan",24);

		
		list.insert(0, dana);
		list.insert(1, zvi);
		list.insert(2, or);
		list.insert(3, dan);
		list.insert(4, ilan);
		list.insert(5, ariel);
		
		System.out.println("2:");
		System.out.println(list);
		
		list.remove(3);
		list.remove(4);
		list.remove(0);

		System.out.println("3: [ Remove dana, dan and ilan ]");
		System.out.println(list);


	}

}
