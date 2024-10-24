package edu.pnn;

import java.util.Scanner;
import edu.pnn.QueryStatement;
import edu.pnn.QueryPreparedStatement;

public class QueryAll {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println();
		System.out.print(" 유형선택 [ 1: Statement / 2: PreparedStatement ] >>> ");
		
		int numQ = sc.nextInt();
		
		if (numQ==1) {
			QueryStatement qst = new QueryStatement(sc);
			qst.main(args);
			
		}
		else if (numQ==2) {
			QueryPreparedStatement qpst = new QueryPreparedStatement(sc);
			qpst.main(args);
			
		} 
		else {
			System.out.println("다시 입력하세요");
		}

	}

}
