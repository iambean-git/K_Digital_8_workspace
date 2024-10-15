package dataStructure.chap03;

/*
 * 3장 5번 실습과제 - 스트링 리스트 정렬
 * 리스트를 배열로 변환후 중복제거후 다시 리스트 만들기 등 실습
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Test05_3_9_스트링리스트정렬 {

	    public static String[] removeElement1(String[] arr, String item) {
	    	
	    	return null;
	    }
	    
	    static void getList(List<String> list) {
			list.add("서울");	list.add("북경");
			list.add("상해");	list.add("서울");
			list.add("도쿄");	list.add("뉴욕");


			list.add("런던");	list.add("로마");
			list.add("방콕");	list.add("북경");
			list.add("도쿄");	list.add("서울");

			list.add(1, "LA");
	    }
	    
	    static void showList(String topic, List<String> list) {//리스트 인덱스를 사용하여 리스트 멤버들을 출력
	    	System.out.println(topic);
	    	for(int i=0; i<list.size(); i++) {
	    		System.out.println( (i+1) + " : " + list.get(i));
	    	}
	    }
	    
	    static void sortList(List<String> list) {//list는 정렬 안되므로 배열로 변환후 정렬 후 다시 리스트로 리턴

	    }
	    
	    static String[] removeDuplicateList(List<String> list) {//중복 제거
		    String cities[] = new String[0];//empty 배열을 cities 참조 변수가 가리킨다
		    cities = list.toArray(cities);//toArray()함수는 list를 배열로 만들때 더 큰 배열이 필요하면 새로 할당된 배열을 리턴
		    
		    return cities;
	    }
		public static void main(String[] args) {
			ArrayList<String> list = new ArrayList<>();
			getList(list);
			showList("입력후", list);
			//sort - 오름차순으로 정렬, 내림차순으로 정렬, 중복 제거하는 코딩

//		    Collections.sort(list);

//배열의 정렬
			sortList(list);
		    System.out.println();
		    showList("정렬후", list);
// 배열에서 중복제거
		    System.out.println();
		    System.out.println("중복제거::");
		  
		    String[] cities = removeDuplicateList(list);
	        ArrayList<String> lst = new ArrayList<>(Arrays.asList(cities));
		    showList("중복제거후", lst);
		}
	}

