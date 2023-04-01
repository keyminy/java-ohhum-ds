package p4_s1;

public class MySingleLinkedList<T> {
	//head는 맨 첫번째 노드를 가리키는 주소!!
	public Node<T> head;
	//node의 갯수
	public int size = 0;
	
	public MySingleLinkedList() {
		head = null;
		size = 0;
	}

	public void addFirst(T item) {
		//1.새로운 Node생성
		Node<T> newNode = new Node<>(item);
		//2.새로운 노드의 next필드가 현재 head노드 가르키게함
		newNode.next = head;
		//3.새로운 노드를 새로운 head노드로 한다
		head = newNode;
		//노드의 갯수 카운트
		size++;
	}
	//insert
	public void add(int index,T item) {
		
	}
	//delete
	public void remove(int index) {
		
	}
	//search
	public int indexOf(T item) {
		return -1;
	}
	public static void main(String[] args) {
		MySingleLinkedList<String> list = new MySingleLinkedList<String>();
		list.add(0, null);
	}
}
