package com.ruby.java.ch08.polymorphism;

//Item 추상 클래스
abstract class Item {
	private String name;    // 제품명
	private double price;   // 제품 가격
	private int stockQuantity; // 재고량

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
		return name + " - ￦"+ price + " 재고량:" + stockQuantity;
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

//Electronics 클래스: Item 클래스 상속
class Electronics extends Item {
	int madeYear;
	
	public Electronics(String name, double price, int stockQuantity, int madeYear) {
		super(name, price, stockQuantity);
		this.madeYear = madeYear;
	}
	
	public String toString() {
		return ("전자제품: "+ super.toString()+ " 제조년도:" + madeYear);
	}
	
	public void show() {
		System.out.println(this.toString());
	}

}

//Clothing 클래스: Item 클래스 상속
class Clothing extends Item {
	int size;
	
	public Clothing(String name, double price, int stockQuantity, int size) {
		super(name, price, stockQuantity);
		this.size = size;
	}

	@Override
	public String toString() {
		return ("의류패션: " + super.toString() + " 치수:" + size);
	}
	
	public void show() {
		System.out.println(this.toString());
	}

}

//Discountable 인터페이스 정의
interface Discountable {
	double getDiscountedPrice(double price);
}

//SeasonalDiscount 클래스: Discountable 인터페이스 구현
class SeasonalDiscount implements Discountable {
	private double discountRate;
	
	public SeasonalDiscount(double discountRate) {
		this.discountRate = discountRate;
	}

	@Override
	public double getDiscountedPrice(double price) {
		return price *discountRate;
	}

}

//Customer 추상 클래스 정의
abstract class Customer {
	private String name;
	
	public Customer(String name) {
		this.name = name;
	}
	// 정보 출력 메소드
	public void show() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "고객 : " + name ;
	}
		
	abstract double applyDiscount(double totalAmount);
}

//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer extends Customer {
	static final double REGULARDISCOUNT_RATE = 0.03;
	
	public RegularCustomer(String name) {
		super(name);
	}
	
	@Override
	double applyDiscount(double totalAmount) {
		
		return totalAmount * REGULARDISCOUNT_RATE;
	}

	public static double getRegulardiscountRate() {
		return REGULARDISCOUNT_RATE;
	}

}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer extends Customer {
	static final double PREMIUMDISCOUNT_RATE = 0.1;
	public PremiumCustomer(String name) {
		super(name);
		
	}
		@Override
	double applyDiscount(double totalAmount) {
		// TODO Auto-generated method stub
		return totalAmount * PREMIUMDISCOUNT_RATE;
	}
	
	public static double getPremiumdiscountRate() {
		return PREMIUMDISCOUNT_RATE;
	}
}

//Order 클래스
class Order extends SeasonalDiscount{
	
	private final int N = 20;
	private Customer customer; // 고객명
	private Item[] items;      // 주문 제품들
	private int[] quantities;  // 주문 제품 수량들
	private String[] orderDates; // 주문일자들 
	private static int count = 0;
	
	public Order(Customer customer, double rate) {
		super(rate);
		this.customer = customer;		
		items = new Item[N];
		quantities = new int[N];
		orderDates = new String[N];
		count = 0;
	}
	
	void addItem(Item item, int orderNumber, String date) {
		items[count] = item;
		item.reduceStrock(orderNumber);
		quantities[count] = orderNumber;
		orderDates[count] = date;
		count++;
	}
	
	public double calculateTotal() {
		double amountD= 0.0;
		for(int i=0; i<count; i++) {
			amountD += (items[i].getPrice())*(quantities[i]);
		}
		return amountD;
	}
	
	double calculateDiscountedTotal(double total) {
		return customer.applyDiscount(total);	
	}
	
	void printOrderSummary() {
		//고객정보
		customer.show();
		//주문요약
		System.out.println("<<<주문 요약>>>");
		for(int i=0; i<count; i++) {
			System.out.println( 
				"- " + items[i].getName() + " x" + + quantities[i] + "개 : 단가 ￦" + items[i].getPrice() );
		}	
		System.out.println("할인 미적용 총비용 : ￦" + this.calculateTotal());
	}
	
	//할인된 내역을 출력하는 메소드
	public void printDiscountDetails() {
		System.out.println("<<<할인 내역>>>");
		for(int i=0; i<count; i++) {
			System.out.println( 
				"- " + items[i].getName() + " : 원래가격" +  " ￦" + items[i].getPrice() 
				+ ", 시즌할인금액 ￦" + this.getDiscountedPrice((items[i].getPrice()))
				+ ", 고객할인금액 ￦" + this.calculateDiscountedTotal((items[i].getPrice()))
				+ ", 할인 후 가격 ￦" + (items[i].getPrice() - this.getDiscountedPrice((items[i].getPrice())) - this.calculateDiscountedTotal((items[i].getPrice())))
									
			);
		}
		double total = this.calculateTotal();
		System.out.println("할인되어 지불해야 하는 금액 : " + (total - this.calculateDiscountedTotal(total) - this.getDiscountedPrice(total)) + "\n");
		
		//할인 두가지 다 적용
	}

}
public class 실습8_1동적바인딩_과제 {
	public static void showItemsStock(Item[] items) {
		for (Item item : items) {
		       item.show(); // 동적 바인딩에 의해 각 클래스의 show() 메서드가 호출됨
		   }
		System.out.println();
	}
	
	public static void main(String[] args) {
		// Item 타입의 배열 생성
	   Item[] items = new Item[4];

	   // 배열에 전자제품과 의류패션 객체 추가
	   items[0] = new Electronics("노트북", 1500, 24, 23);
	   items[1] = new Clothing("티셔츠", 50, 50, 95);
	   items[2] = new Electronics("휴대폰", 800, 12, 24);
	   items[3] = new Clothing("청바지", 80, 30, 90);
	   
	   // 모든 아이템의 이름과 재고량, 가격 출력
	   showItemsStock(items);
	   	   
	   // 고객 생성 
	   Customer regularCustomer = new RegularCustomer("홍길동");
	   Customer premiumCustomer = new PremiumCustomer("강감찬");
	  
	   // 주문 생성 및 계산 (RegularCustomer)
	   Order regularOrder = new Order(regularCustomer, 0.05);
	   regularOrder.addItem(items[0], 1, "240901");
	   regularOrder.addItem(items[1], 2, "240902");
	   
	   regularOrder.printOrderSummary();
	   regularOrder.printDiscountDetails(); // 할인된 내역 출력
	   
	   // 주문 생성 및 계산 (PremiumCustomer)
	   Order premiumOrder = new Order(premiumCustomer, 0.05);
	   premiumOrder.addItem(items[2], 1, "240901");
	   premiumOrder.addItem(items[3], 2, "240903");

	   premiumOrder.printOrderSummary();
	   premiumOrder.printDiscountDetails(); // 할인된 내역 출력

	   // 모든 아이템의 이름과 재고량, 가격 출력
	   showItemsStock(items);
	}

}
