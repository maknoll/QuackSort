import java.util.LinkedList;


class Duck <T extends Comparable<T>> {
	
	private T data;
	private Duck<T> next;

	public Duck(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	public LinkedList<T> getDataList() {
		LinkedList<T> result;
		if (next == null)
			result = new LinkedList<T>();
		else
			result = next.getDataList();
		result.add(data);
		return result;
	}

	public void setNext(Duck<T> duck) {
		next = duck;
	}
	
	public Duck<T> getNext() {
		return next;
	}
	
	public Duck<T> makeLove (Duck<T> lover, T data) {
		return new Duck<T>(data);
	}
	
	public boolean follow(DuckFamily<T> family) {
		
		if (family.getMother() == null) {
			this.setNext(null);
			family.setHead(this);
			return true;
		}
		if (this.getData().compareTo(family.getMother().getData()) <= 0) {
			this.setNext(family.getHead());
			family.setHead(this);
			return true;
		} else {
			return false;
		}
	}
	
	public void lead(DuckFamily<T> family) {
		
		this.setNext(null);
		if (family.getHead() == null)
			family.setHead(this);
		else
			family.getMother().setNext(this);
	}
	
	public Duck<T> getMother() {
		return next == null ? this : next.getMother();
	}
}
