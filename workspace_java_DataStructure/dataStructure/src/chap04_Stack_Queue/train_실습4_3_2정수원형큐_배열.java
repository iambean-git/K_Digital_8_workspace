package chap04_Stack_Queue;
/*
 * 실습 4_5번 - 정수 배열 원형 큐
 * 교재 148 ~ 157 페이지
 * 교재 소스 코드를 보지 않고 구현 완성 연습 필요 
 * /*
 * num 변수를 사용하지 않고 front == rear 일 때 queue가 full인지 empty 인지를 판단
 * 큐에서는 예외 클래스를 만드는 연습
 */
import java.util.Random;
/*
 * 큐 1번 실습 코드 - 정수들의 큐
 */
import java.util.Scanner;



//int형 고정 길이 큐

class IntQueue3 {
	private int[] que; // 정수 원형 큐 배열
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	boolean isEmptyTag; //큐가 empty인지 full인지 구분

//--- 실행시 예외: 큐가 비어있음 ---//
	public class EmptyIntQueue3Exception extends RuntimeException {
		public EmptyIntQueue3Exception(String msg) {
			super(msg);
		}
	}

//--- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowIntQueue3Exception extends RuntimeException {
		public OverflowIntQueue3Exception(String msg) {
			super(msg);
		}
	}

	//--- 생성자(constructor) ---//
	public IntQueue3(int maxlen) {
		capacity = maxlen;
		front = rear = 0;
		isEmptyTag = true;
		
		try {
			que = new int[capacity];
		} catch(OutOfMemoryError e) {
			capacity = 0;
		}

	}

	//--- 큐에 데이터를 인큐 ---//
	public int enque(int x) throws OverflowIntQueue3Exception {
		if(front==rear && !isEmptyTag)	//큐가 full
			throw new OverflowIntQueue3Exception("enque: queue overflow");
		que[rear]= x;
		isEmptyTag = false;
		rear = (++rear ) % capacity;
		return x;
	}

	//--- 큐에서 데이터를 디큐 ---//
	public int deque() throws EmptyIntQueue3Exception {
		if(front==rear && isEmptyTag)
			throw new EmptyIntQueue3Exception("deque: queue empty");
		//삭제 (return)
		int result = que[front];
		front = (++front) % capacity;
		if(front==rear)
			isEmptyTag = true;
		return result;
		

	}

	//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
	public int peek() throws EmptyIntQueue3Exception {
		if(isEmpty())
			throw new EmptyIntQueue3Exception("peek: queue empty");
		return que[front];
	}

	//--- 큐를 비움 ---//
	public void clear() {
		front=rear=0;
		isEmptyTag = true;
	}

	//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
	public int indexOf(int x) {
		if(isEmpty())
			throw new EmptyIntQueue3Exception("indexOf : queue empty");
		else {
			//데이터가 순차적으로 있을 때
			if(rear>front) {
				for(int i=front; i<rear; i++) {
					if(que[i]==x)	return i;
				}
			}
			//데이터 중간이 비어있을 때
			else {
				for(int i=0; i<rear; i++) {
					if(que[i]==x)	return i;
				}
				for(int i=front; i<capacity; i++) {
					if(que[i]==x)	return i;
				}
			}
			return -1;
		}
	}

	//--- 큐의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

	//--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
	public int size() {
		if(isEmpty()) return 0;
		else if (isFull()) return capacity;
		else {
			if(rear>front)
				return rear-front;
			else
				return capacity-front+rear;
		}
	}

	//--- 큐가 비어있는가? ---//
	public boolean isEmpty() {
		return (front==rear)&&(isEmptyTag);
	}

	//--- 큐가 가득 찼는가? ---//
	public boolean isFull() {
		return (front==rear)&&(!isEmptyTag);
	}

	//--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
	public void dump() {
		if(isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			throw new EmptyIntQueue3Exception("dump: queue empty");
		}
		else {
			//데이터가 순차적으로 있을 때
			if(rear>front) {
				for(int i=front; i<rear; i++) {
					System.out.println(que[i] + " ");
				}
			}
			//데이터 중간이 비어있을 때
			else {
				for(int i=front; i<capacity; i++) {
					System.out.println(que[i] + " ");
				}
				for(int i=0; i<rear; i++) {
					System.out.println(que[i] + " ");
				}
				
			}
		}

	}
}
public class train_실습4_3_2정수원형큐_배열 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntQueue3 oq = new IntQueue3(4); // 최대 64개를 인큐할 수 있는 큐
		Random random = new Random();
		int rndx = 0, p = 0;
		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", oq.size(), oq.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");
			int menu = stdIn.nextInt();
			
			if (menu == 0)
				break;
			
			switch (menu) {
			case 1: // 인큐
				rndx = random.nextInt(20);
				System.out.println("입력데이터: (" + rndx +")");
				try {
					oq.enque(rndx);
				} catch(IntQueue3.OverflowIntQueue3Exception e) {
					System.out.println("stack이 가득찼있습니다.");
				}
				break;

			case 2: // 디큐
				try {
					p = oq.deque();
					System.out.println("디큐한 데이터는 " + p + "입니다.");
				} catch (IntQueue3.EmptyIntQueue3Exception e) {
					System.out.println("큐가 비어 있습니다.");
					e.printStackTrace();
				}
				break;

			case 3: // 피크
				try {
					p = oq.peek();
					System.out.println("피크한 데이터는 " + p + "입니다.");
				} catch (IntQueue3.EmptyIntQueue3Exception e) {
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