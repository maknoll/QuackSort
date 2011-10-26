import java.util.LinkedList;


class DuckFamily <T extends Comparable<T>> {
	
	private Duck<T> head;
	
	public DuckFamily() {
		head = null;
	}
	
	public Duck<T> getHead() {
		return head;
	}
	
	public void setHead(Duck<T> head) {
		this.head = head;
	}
	
	public Duck<T> getMother() {
		return head != null ? head.getMother() : null;
	}
	
	public LinkedList<T> getDataList() {
		return getHead().getDataList();
	}
	
	public Duck<T> removeMother() {
		Duck<T> mother = getMother();
		Duck<T> last;
		if (this.getHead().getNext() != null) {
			for (last = this.getHead(); last.getNext().getNext() != null; last = last.getNext());
			last.setNext(null);
		} else {
			setHead(null);
		}
		return mother;
	}
}
