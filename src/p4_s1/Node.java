package p4_s1;

public class Node<T> {
	//데이터 필드 : data저장
	T data;
	//링크 필드 : 다음 노드의 주소 저장,같은 Type가리키므로 Node<T>
	public Node<T> next;

	//데이터 필드 data값을 받아서 초기화하는 기본 생성자
	public Node(T item) {
		this.data = item;
		this.next = null;
	}
	
}
