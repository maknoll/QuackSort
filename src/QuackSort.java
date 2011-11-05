import java.util.LinkedList;
import java.util.List;


public class QuackSort <T extends Comparable<T>> {
	
	private Duck<T> alice = new Duck<T>(null);
	private Duck<T> bob = new Duck<T>(null);
	private DuckFamily<T> family = new DuckFamily<T>();
	
	public QuackSort (List<T> elements) {

		for (T data : elements) {
			Duck<T> hatchling = alice.makeLove(bob, data);
			hatchling.setNext(family.getHead());
			family.setHead(hatchling);
		}
		
	}
	
	public LinkedList<T> getDataList() {
		
		return family.getDataList();
	}
	
	public void partition () {
		DuckFamily<T> result = new DuckFamily<T>();
		
		while (family.getHead() != null) {
			Duck<T> mother = family.removeMother();
			if (!mother.follow(result))
				mother.lead(result);
		}
		
		family = result;
	}
	
	public void sort() {
		DuckFamily<T> result = new DuckFamily<T>();
		
		while (family.getHead() != null) {
			partition();
			Duck<T> mother = family.removeMother();
			mother.follow(result);
		}
		
		family = result;
	}

	public static void main(String[] args) {
		
		int[] arr = {5, 6, 4, 7, 3, 8, 2, 9, 1, 7, 3};
		LinkedList<Integer> l = new LinkedList<Integer>();
		for (int i : arr)
			l.add(i);
				
		QuackSort<Integer> q = new QuackSort<Integer>(l);
		
		q.sort();
		
		for (int i : q.getDataList())
			System.out.println(i);
	}

}
