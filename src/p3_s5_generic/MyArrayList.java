package p3_s5_generic;

import java.util.Arrays;

public class MyArrayList<E> {
	
	private static final int INIT_CAPACITY = 10;
	private E [] theData; //E타입의 배열입니다.
	private int size;
	private int capacity;
	
	public MyArrayList() {
		theData = (E[])new Object [INIT_CAPACITY];
		size = 0;
		capacity = INIT_CAPACITY;
	}
	public void add(int index,E anEntry) {
		//사용자가 범위를 벗어난 index를 지정하였다면?
		if(index < 0 || index > size) {
			//error or exception
			throw new ArrayIndexOutOfBoundsException(index);
		}
		//배열이 꽉 찼을경우(size≥capacity), reallocate()하는 함수
		if(size >= capacity) {
			reallocate();
		}
		for(int i=size-1;i>=index;i--) {
			theData[i+1] = theData[i];//index~(size-1)까지 원소들 뒤로 보냅니다
		}
		theData[index] = anEntry;//index자리에 매개변수로 들어온 값 넣기
		size++; //추가했으면 데이터 갯수 추가
	}
	
	
	private void reallocate() {
		E [] tmp = (E[])new Object [capacity * 2];
		theData = Arrays.copyOf(theData,capacity);
	}
	public void add(E anEntry) {
		//위에서 구현했던거 재활용하세요
		//그냥 맨 뒤에다가 삽입하는 거니까 이렇게 하면됨
		add(size,anEntry);
	}
	
	public int size() {
		return size;//갯수 리턴
	}
	
	public int indexOf(E anEntry) {
		for(int i=0;i<size;i++) {
			if(theData[i].equals(anEntry)) return i;
		}
		return -1;
	}
	
	public E get(int index) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return theData[index];
	}
	
	public E set(int index, E newValue) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E oldValue = theData[index];
		//newValue를 덮어써줌
		theData[index] = newValue;
		return oldValue; //지워진 값(원래 있던 값 리턴함,
		//혹시라도 이 기능이 유용할 수 있기때문에)
	}
	
	public E remove(int index) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E returnValue = theData[index];
		/*데이터 지우면, 기존 데이터 앞으로 하나씩 땡겨*/
		for(int i=index +1;i<size;i++) {
			//index행 지웠을 때, 이전 값들 옮기기
			theData[i-1] = theData[i];
		}
		size--;
		return returnValue; //지워진 값(원래 있던 값 리턴함),
		//혹시라도 이 기능이 유용할 수 있기때문에)
	}
	
	public static void main(String[] args) {
		MyArrayList<String> test = new MyArrayList<String>();
		test.add(1,"Hello");
	}
}
