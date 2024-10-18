package dataStructure.chap04;
/*
 * 실습 4_6번 객체 원형 큐를 배열로 구현
 * 교재 148 실습 4_3은 정수 원형 큐를 배열로 구현한 코드임 > 객체 버젼으로 구현
 */

import java.util.Random;
import java.util.Scanner;

/*
* Queue of ArrayList of Point
*/

class Point3 {
	private int ix;
	private int iy;
	
	public Point3(int ix, int iy) {
		super();
		this.ix = ix;
		this.iy = iy;
	}

	@Override
	public String toString() {
		return "[ix=" + ix + ", iy=" + iy + "]";
	}


}

//int형 고정 길이 큐
class objectQueue2 {
  private Point3[] que;
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서


//--- 실행시 예외: 큐가 비어있음 ---//
	public class EmptyQueueException extends RuntimeException {
		public EmptyQueueException(String msg) {
			super(msg);
		}
	}

//--- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowQueueException extends RuntimeException {
		public OverflowQueueException(String msg) {
			super(msg);
		}
	}

//--- 생성자(constructor) ---//
public objectQueue2(int maxlen) {
	front = rear = 0;
	capacity = maxlen;
	
	try {
		que = new Point3[capacity];
	} catch(OutOfMemoryError e) {
		capacity = 0;
	}
}

	//--- 큐에 데이터를 인큐 ---//
	public int enque(Point3 x) throws OverflowQueueException {
		if(isFull())
			throw new OverflowQueueException("enque : queue overflow");
		que[rear++] = x;
				
		return 1;
	}

	//--- 큐에서 데이터를 디큐 ---//
	public Point3 deque() throws EmptyQueueException {
		if(isEmpty())
			throw new EmptyQueueException("deque: queue empty");
		
		return que[front++];
		//deque된 공간들이 빈공간으로 버려짐 -> 비효율적 : 그래서 원형큐로 하는게 낫다
	}

	//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
	public Point3 peek() throws EmptyQueueException {
		if(isEmpty())
			throw new EmptyQueueException("peek: queue empty");
		return que[front];
	}

	//--- 큐를 비움 ---//
	public void clear() {
		front = rear = 0;
	}

	//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
	public int indexOf(Point3 x) {
		for(int i=front; i<rear; i++) {
			if(que[i].equals(x)) return i;
		} return -1;
	}

	//--- 큐의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

	//--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
	public int size() {
		return rear-front;
	}

//--- 큐가 비어있는가? ---//
	public boolean isEmpty() {
		return (front==rear);
	}

//--- 큐가 가득 찼는가? ---//
	public boolean isFull() {
		return (rear==capacity) && (front==0);
	}

//--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
	public void dump() {
		for(int i=front; i<rear; i++) {
			System.out.println(que[i] + " ");
		}

	}
}
public class train_실습4_3_3객체선형큐_배열 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		objectQueue2 oq = new objectQueue2(4); // 최대 64개를 인큐할 수 있는 큐
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point3 p = null;
		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", oq.size(), oq.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");
			int menu = stdIn.nextInt();
			switch (menu) {
			case 1: // 인큐

				rndx = random.nextInt(20);

				rndy = random.nextInt(20);
				System.out.print("입력데이터: (" + rndx + ", " + rndy + ")");
				p = new Point3(rndx,rndy);
				try {
					oq.enque(p);
				} catch(objectQueue2.OverflowQueueException e) {
					System.out.println("stack이 가득찼있습니다.");
				}
				break;

			case 2: // 디큐
				try {
					p = oq.deque();
					System.out.println("디큐한 데이터는 " + p + "입니다.");
				} catch (objectQueue2.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = oq.peek();
					System.out.println("피크한 데이터는 " + p + "입니다.");
				} catch (objectQueue2.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 4: // 덤프
				oq.dump();
				break;
			default:
				break;
			}
		}
	}
}