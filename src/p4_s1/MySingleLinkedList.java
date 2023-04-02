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
	public void addAfter(Node<T> before,T item) {
		//1.새로운 노드 생성
		Node<T> temp = new Node<T>(item);
		//2.새로운 Node의 next필드에, before의 다음 노드 주소가르키게
		temp.next = before.next;
		//3.before노드의 next필드에, 새로 만든 node연결
		before.next = temp;
		//노드의 갯수 카운트
		size++;
	}
	
	public T removeFirst() {
		if(head == null) {
			return null;
		}
		//기존 head의 data 저장
		T temp = head.data;
		head = head.next;//head가 현재 head노드의 다음 노드 가르키게함
		size--;
		return temp;
		
	}
	
	public T removeAfter(Node<T> before) {
		if(before.next == null) {
			return null;
		}
		T temp = before.next.data;//삭제 당할거
		before.next = before.next.next;
		return temp;
	}
	
	//search
	public int indexOf(T item) {
		Node<T> p = head;//p가 head를 가르키게됨
		int index = 0;
		while(p != null) {
			if(p.data.equals(item)) {
				return index;//동잃하면,현재 index리턴
			}
			p = p.next;//다음 노드 가르키게
			index++;
		}
		return -1;
	}
	
	public Node<T> getNode(int index){
		//index의 유효성 검사
		if(index < 0 || index >= size) {
			return null;
		}
		Node<T> p = head;//p가 head를 가르키게됨
		for(int i=0; i<index; i++) {
			p = p.next; //index번 만큼 전진
		}
		return p;
	}
	
	public T get(int index) {
//		//index의 유효성 검사
		if(index < 0 || index >= size) {
			return null;
		}
//		Node<T> p = head;//p가 head를 가르키게됨
//		for(int i=0; i<index; i++) {
//			p = p.next; //index번 만큼 전진
//		}
//		return p.data;
		return getNode(index).data; //하지만 getNode가 null이면
		//null.data가 되어 좋지않음
	}
	
	//insert
	public void add(int index,T item) {
		if(index < 0 || index > size) {
			return;
		}
		if(index ==0) {
			addFirst(item);
		}else {
			Node<T> q = getNode(index-1);
			addAfter(q,item);			
		}
	}
	//delete(삭제할 노드의 이전 노드를 알아야함)
	public T remove(int index) {
		if(index < 0 || index >= size) {
			return null;
		}
		if(index == 0) {
			return removeFirst();
		}
		Node<T> prev = getNode(index-1);
		return removeAfter(prev);
	}
	
	//삭제할 노드를 인자로받아 삭제한다.
	public T remove(T item) {
		Node<T> p = head;
		Node<T> q = null;
		while(p!=null && !p.data.equals(item)) {
			q = p; //p가 직전하기 직전,q를 p로 따라가게
			p = p.next;//p이동
		}
		//node를 다 거치고 조건에 불만족하면 p는 null이됨
		if(p==null) {
			return null;//너가 찾는 node가 존재하지 않는다.
		}
		if(q==null) {
			//Node의 첫번째가 바로 찾는 값이면?
			return removeFirst();
		}
		else {
			//q가 삭제할 Node의 바로 직전이 된다.			
			return removeAfter(q);
		}
	}

	public static void main(String[] args) {
		MySingleLinkedList<String> list = new MySingleLinkedList<String>();
		list.add(0, "Saturday");
		list.add(1, "Friday");
		list.add(0, "Monday"); //M,S,F
		list.add(2, "Tuesday"); //M,S,T,F
		
		list.remove(2); //M,S,F
		int pos = list.indexOf("Friday"); //pos=2
		System.out.println("pos : " + pos);
		System.out.println("list : " + list.getNode(0));
	}
}
