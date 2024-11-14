package chap04_Stack_Queue;
/*
 * 실습 6번: 원형 큐로서 큐에 Point 객체를 배열로 저장
 * 실습4_3_2 정수 원형 큐 배열을 객체 버젼으로 구현하는 것임
 * /*
 * num 변수를 사용하지 않고 front == rear 일 때 queue가 full인지 empty 인지를 판단
 * 큐에서는 예외 클래스를 만드는 연습
 */

import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * 실습4_7번 
 * 원형 큐로서 큐에 Point 객체를 저장
 * class CircularQueue의 필드는 QUEUE_SIZE, que,	front, rear, isEmptyTag 변수만 사용
 */

import java.util.Random;
import java.util.Scanner;

class Point5 {
	private int ix;
	private int iy;

	public Point5(int ix, int iy) {
		super();
		this.ix = ix;
		this.iy = iy;
	}

	@Override
	public String toString() {
		return "[ix=" + ix + ", iy=" + iy + "]";
	}
}

class CircularQueue {
	static int QUEUE_SIZE = 0;
	Point5[] que;// 배열로 객체원형 큐 구현
	int front, rear;
	boolean isEmptyTag;

	// --- 실행시 예외: 큐가 비어있음 ---//
	public class EmptyQueueException extends RuntimeException {
		public EmptyQueueException(String msg) {
			super(msg);
		}
	}

	// --- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowQueueException extends RuntimeException {
		public OverflowQueueException(String msg) {
			super(msg);
		}
	}

	public CircularQueue(int count) {
		front = rear = 0;
		que = new Point5[count];
		isEmptyTag = true;
		// 다음 2개 field 가 필요한지 확인 필요
		QUEUE_SIZE = count;
	}

	void push(Point5 it) throws OverflowQueueException {
		if (isFull()) {
			throw new OverflowQueueException("push: circular queue overflow");
		}
		que[rear] = it;
		isEmptyTag = false;
		rear = (++rear) % QUEUE_SIZE;
	}

	Point5 pop() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("pop: circular queue overflow");
		}
		Point5 tmp = que[front];
		front = (++front) % QUEUE_SIZE;
		if (front == rear)
			isEmptyTag = true;
		return tmp;
	}

	public Point5 peek() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException("peek: queue empty"); // 큐가 비어있음
		return que[front];
	}

	void clear() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("enque: circular queue overflow");
		}
		front = rear = 0;
		isEmptyTag = true;
	}

	// --- 큐의 크기를 반환 ---//
	public int getCapacity() {
		return QUEUE_SIZE;
	}

	// --- 큐에 쌓여 있는 데이터 개수를 반환 ---//
	public int size() {// front, rear를 사용하여 갯수를 size로 계산
		if (isEmpty())
			return 0;
		// else if (isFull()) return QUEUE_SIZE;
		else {
			if (rear > front)
				return rear - front;
			else
				return QUEUE_SIZE - front + rear;
		}
	}

	// --- 원형 큐가 비어있는가? --- 수정 필요//
	public boolean isEmpty() {
		return (front == rear) && (isEmptyTag);
	}

	// --- 원형 큐가 가득 찼는가? --- 수정 필요//
	public boolean isFull() {
		return (front == rear) && (!isEmptyTag);
	}

	public void dump() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException("dump: queue empty");
		else {
			// 데이터가 순차적으로 있을 때
			if (rear > front) {
				for (int i = front; i < rear; i++) {
					System.out.println(que[i] + " ");
				}
			}
			// 데이터 중간이 비어있을 때
			else {
				for (int i = front; i < QUEUE_SIZE; i++) {
					System.out.println(que[i] + " ");
				}
				for (int i = 0; i < rear; i++) {
					System.out.println(que[i] + " ");
				}

			}
		}
	}
}

public class train_실습4_3_4객체원형큐배열 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		CircularQueue oq = new CircularQueue(4); // 최대 4개를 인큐할 수 있는 큐
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point5 p = null;
		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", oq.size(), oq.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(5) clear  (0)종료: ");
			int menu = stdIn.nextInt();
			if (menu == 0)
				break;
			switch (menu) {
			case 1: // 인큐

				rndx = random.nextInt(20);

				rndy = random.nextInt(20);
				System.out.print("입력데이터: (" + rndx + ", " + rndy + ")");
				p = new Point5(rndx, rndy);
				try {
					oq.push(p);
					System.out.println("push: size() = " + oq.size());
				} catch (CircularQueue.OverflowQueueException e) {
					System.out.println("queue이 full입니다." + e.getMessage());
					e.printStackTrace();
				}
				break;

			case 2: // 디큐
				try {
					p = oq.pop();
					System.out.println("pop: size() = " + oq.size());
				} catch (CircularQueue.EmptyQueueException e) {
					System.out.println("queue이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;

			case 3: // 피크
				try {
					p = oq.peek();
					System.out.println("피크한 데이터는 " + p + "입니다.");
				} catch (CircularQueue.EmptyQueueException e) {
					System.out.println("queue이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;
			case 4: // 덤프
				try {
					oq.dump();
				} catch (CircularQueue.EmptyQueueException e) {
					System.out.println("queue이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;
			case 5: // clear
				try {
					oq.clear();
				} catch (CircularQueue.EmptyQueueException e) {
					System.out.println("queue이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;
			}
		}
	}
}
