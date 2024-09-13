package com.ruby.java.ch07.과제;

// ------------------------------ 아이템 클래스 -----------------------------
class Item {
	private String name;		//제품명
	private double price; 		//가격
	private int stockQuantity;	//재고량
	
	// 생성자
	public Item(String name, double price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
	
	// 재고 감소 메소드
	void reduceStrock(int qunatity) {
		stockQuantity -= qunatity;
	}
	
	// 재고 증가 메소드
	void increaseStock(int quantity) {
		stockQuantity += quantity;
	}
	
	// 정보 출력 메소드
	public void show() {
		System.out.println(this.toString());
		
	}

	@Override
	public String toString() {
		return "name=" + name + ", price=" + price  ;
	}
	
	
	//getter
	public String getName() {
		return name;
	}


	public double getPrice() {
		return price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}


}

//------------------------------ Customer 클래스 -----------------------------
class Customer {
	private String cname;
	private String city;
	private int age;
	
	public Customer(String cname, String city, int age) {
		this.cname = cname;
		this.city = city;
		this.age = age;
	}
	
	 // 정보 출력 메소드
	public void show() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "name=" + cname + ", city=" + city + ", age=" + age ;
	}
	
}

//------------------------------ Order 클래스 -------------------
class Order {
	private Customer customer;		//고객
	private Item[] items;			//주문 제품들
	private int[] quantities;		//주문 제품 수량
	private String[] orderDates;	//주문일자들
	private int count = 0;			//배열인덱스
	
	public Order(Customer customer, int maxItems) {
		this.customer = customer;		
		items = new Item[maxItems];
		quantities = new int[maxItems];
		orderDates = new String[maxItems];
	}

	void addItem(Item item, int orderNumber, String date) {
		items[count] = item;
		item.reduceStrock(orderNumber);
		quantities[count] = orderNumber;
		orderDates[count] = date;
		count++;
	}
	
	double calculateTotal() {
		double amountD= 0.0;
		for(int i=0; i<items.length; i++) {
			amountD += (items[i].getPrice())*(quantities[i]);
		}
		return amountD;
	}
	
	void printOrderSummary() {
		//고객정보
		customer.show();
		//물품정보
		for(int i=0; i<items.length; i++) {
			System.out.println(items[i].toString()
					+ ", quantity=" + quantities[i]
					+ ", orderDate=" + orderDates[i]
					+ ", stockQuantity=" + items[i].getStockQuantity());
		}
		//총액정보
		System.out.println("Total=" + this.calculateTotal() + "\n");
	}
}

public class ExamB1 {

	public static void main(String[] args) {
		// 아이템 생성
        Item laptop = new Item("노트북", 1200.00, 10);
        Item tshirt = new Item("티셔츠", 20.00, 50);
        Item phone = new Item("휴대폰", 800.00, 30);
        Item headphones = new Item("헤드폰", 150.00, 20);
        Item mouse = new Item("마우스", 30.00, 15);
        

        // 고객 생성
        Customer boy = new Customer("홍길동", "부산", 21);
        Customer girl = new Customer("계백", "양산", 22);
          
        
        
        // 주문 생성
        Order order1 = new Order(boy, 5); // 최대 5개 아이템
         
        order1.addItem(laptop, 1, "2024-08-28");
        order1.addItem(tshirt, 2, "2024-08-28");
        order1.addItem(phone, 1, "2024-08-28");
        order1.addItem(headphones, 1, "2024-08-28");
        order1.addItem(mouse, 1, "2024-08-28");
        
        Order order2 = new Order(girl, 5); // 최대 5개 아이템
        order2.addItem(laptop, 1, "2024-09-04");
        order2.addItem(tshirt, 1, "2024-09-04");
        order2.addItem(phone, 1, "2024-09-04");
        order2.addItem(headphones, 1, "2024-09-04");
        order2.addItem(mouse, 1, "2024-09-04");
        
        // 주문 요약 출력
        order1.printOrderSummary();
        order2.printOrderSummary();
	}

}
