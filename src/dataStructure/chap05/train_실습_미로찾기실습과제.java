package dataStructure.chap05;
import java.util.Stack;

/*
 * 미로 찾기 문제
 * plato(LMS)의 미로 찾기 문제 설명 자료 학습
 * int input[12][15] 테이블에서 입구는 (0,0)이며 출구는 (11,14)임
 * 미로 테이블 (12,15)을 상하좌우 울타리를 친 maze[14][17]을 만들고 입구는 (1,1)이며 출구는(12,15)
 * stack을 사용한 backtracking 구현
 */

//23.2.16 수정
//23.2.24: 객체 배열 초기화, static 사용, 내부 클래스와 외부 클래스 사용 구분을 못하는 문제 => 선행 학습 필요
enum Directions {N, NE, E, SE, S, SW, W, NW}
class Items {
	
	int x;
	int y;
	int dir;
	
	public Items(int x, int y, int dir) {
		this.x = x; this.y = y; this.dir = dir;
	}

}
class Offsets {
	int a;
	int b;
	
	public Offsets(int a, int b) {
		this.a = a;
		this.b = b;
	}

}
public class train_실습_미로찾기실습과제 {
	static Offsets[] moves = new Offsets[8];//static을 선언하는 이유를 알아야 한다
	
	//m = 12, p = 15
	static void path(int maze[][], int mark[][], int m, int p){
		
		for (int ia = 0; ia < 8; ia++)
			moves[ia] = new Offsets(0, 0);//배열에 offsets 객체를 치환해야 한다.
		moves[0].a = -1;	moves[0].b = 0;		//N
		moves[1].a = -1;	moves[1].b = 1;		//NE
		moves[2].a = 0;		moves[2].b = 1;		//E
		moves[3].a = 1;		moves[3].b = 1;		//SE
		moves[4].a = 1;		moves[4].b = 0;		//S
		moves[5].a = 1;		moves[5].b = -1;	//SW
		moves[6].a = 0;		moves[6].b = -1;	//W
		moves[7].a = -1;	moves[7].b = -1;	//NW
		//Directions d;
		//d = Directions.N;
		//d = d + 1;//java는 지원안됨
		
		Stack<Items> stack = new Stack<>();
		
		//initialize stack to the maze entrance coordinates and direction east
		stack.push(new Items(1,1,2));
		maze[1][1] = 2;
		mark[1][1] = 1;
		
		while(!stack.isEmpty()) {
			
			Items current = stack.peek();
			int curX = current.x; int curY = current.y; int curDir=current.dir;
			boolean checkMoved = false;
			
			while(curDir<8) {
				int nextX = curX + moves[curDir].a;
				int nextY = curY + moves[curDir].b;
				
				//종료지점(12,15)에 도착
				if(nextX==m && nextY==p) {	
					maze[nextX][nextY] = 2;
					return;
				}
				
				if(maze[nextX][nextY]==0 && mark[nextX][nextY]==0) {
					mark[nextX][nextY] = 1;
					maze[nextX][nextY] = 2;
					current.dir += 1;
					stack.add(new Items(nextX, nextY, 0));
					checkMoved = true;
					show("maze[12,15]::", maze);
					
					curX = nextX; curY = nextY; curDir=0;
					
				}
				else {
					curDir += 1;
				}
			}
			
			// (i,j) 현위치에 대한 mark를 취소
			if(!checkMoved) {
				maze[curX][curY] = 0;
				stack.pop();
			}
				
		}
	}
	
	

	public static void main(String[] args) {
		int[][] maze = new int[14][17];
		int[][] mark = new int[14][17];

		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }};
		
		
		
		//input[][]을 maze[][]로 복사
		for (int i = 0; i < 14; i++) {
			maze[i][0] = 1;
			maze[i][16] = 1;
			for (int j = 1; j < 16; j++) {
				if(i==0 || i==13)	maze[i][j] = 1;
				else				maze[i][j] = input[i-1][j-1];
			}
		}

		show("maze[12,15]::", maze);
		show("mark[12,15]::", mark);

		path(maze, mark, 12, 15);
		show("maze[12,15]::", maze);
		show("mark[12,15]::", mark);


	}
	
	private static void show(String msg, int[][] arr) {
		System.out.println(msg);
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
