package dataStructure.chap08_List;

import java.util.Stack;

class Test {
    static boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
        	char c = s.charAt(i);
        	System.out.println(c=='(');
            //if(s[i].equals("("))    
              //  System.out.println("( 입력");
        }
        
        
        System.out.println("Hello Java");

        return answer;
    }
    
    public static String make2jin(int n) {
    	System.out.println("n :" + n);
        String result = "";
    	while( n !=0 ) {
    		int tmp = n % 2;
    		result += String.valueOf(tmp);
        	n = n/2;
        }
    	System.out.println(result);
    	return result;
    	
    }
    
    public static void main(String[] args) {
    	make2jin(3);
	}
}