package com.ruby.java.ch07.과제;

//Discountable 인터페이스 정의
interface Discountable{
	double getDiscountedPrice(double price);
}

//SeasonalDiscount 클래스: Discountable 인터페이스 구현
class SeasonalDiscount implements Discountable {
	private double discountRate;	//객체가 만들어질 때 값이 설정됨
	
	public SeasonalDiscount(double discountRate) {
		this.discountRate = discountRate;
	}

	@Override
	public double getDiscountedPrice(double price) {
		return price * discountRate;
	}
}

//Item 추상 클래스
class Item3 {
	private String name;		//제품명
	private double price; 		//가격
	private int stockQuantity;	//재고량
	
	// 생성자
	public Item3(String name, double price, int stockQuantity) {
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

//Electronics 클래스 (Item 클래스를 상속)
class Electronics3 extends Item3 {
	private int warranty; // 제품 보증 기간

	public Electronics3(String name, double price, int stockQuantity, int warranty) {
		super(name, price, stockQuantity);
		this.warranty = warranty;
	}
	
	public String toString() {
		return (super.toString()+ ", warranty=" + warranty);
	}
	
	public void show() {
		System.out.println(this.toString());
	}
}

class Clothing3 extends Item3 {
	int size;
	
	public Clothing3(String name, double price, int stockQuantity, int size) {
		super(name, price, stockQuantity);
		this.size = size;
	}

	@Override
	public String toString() {
		return (super.toString() + ", size=" + size);
	}
	
	public void show() {
		System.out.println(this.toString());
	}
	
}

//------------------------------ Customer 클래스 -----------------------------
abstract class Customer3 {
	private String cname;
	
	public Customer3(String cname) {
		this.cname = cname;
	}
	
	 // 정보 출력 메소드
	public void show() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "고객 : " + cname ;
	}
	
	abstract double applyDiscount(double totalAmoung);
}


//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer3 extends Customer3 {
	static final double REGULARDISCOUNT_RATE = 0.03;
	public RegularCustomer3(String cname) {
		super(cname);
	}
	
	@Override
	double applyDiscount(double totalAmount) {
		
		return totalAmount *REGULARDISCOUNT_RATE;
	}
	
	public static double getRegulardiscountRate() {
		return REGULARDISCOUNT_RATE;
	}
	
	
}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer3 extends Customer3 {
	static final double PREMIUMDISCOUNT_RATE = 0.1;
	public PremiumCustomer3(String cname) {
		super(cname);
		
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

//------------------------------ Order 클래스 -------------------
class Order3 extends SeasonalDiscount {
	private final int N = 20;
	private Customer3 customer;		//고객
	private Item3[] items;			//주문 제품들
	private int[] quantities;		//주문 제품 수량
	private String[] orderDates;	//주문일자들
	private int count = 0;			//배열인덱스
	
	public Order3(Customer3 customer, double rate) {
		super(rate);
		this.customer = customer;		
		items = new Item3[N];
		quantities = new int[N];
		orderDates = new String[N];
	}

	void addItem(Item3 item, int orderNumber, String date) {
		items[count] = item;
		item.reduceStrock(orderNumber);
		quantities[count] = orderNumber;
		orderDates[count] = date;
		count++;
	}
	
	double calculateTotal() {
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
				"- " + items[i].getName() + " x" + + quantities[i] + " (￦" + items[i].getPrice() + ")" );
		}		
	}
	
	// 할인된 내역을 출력하는 메소드
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
	}
}

public class ExamB3 {
	public static void main(String[] args) {
		// 배열에 전자제품과 의류패션 객체 추가
		Item3 note = new Electronics3("노트북", 1500, 24, 23);
		Item3 cloth = new Clothing3("티셔츠", 50, 50, 95);
		
		// 고객 생성 
		Customer3 regularCustomer = new RegularCustomer3("홍길동");
		Customer3 premiumCustomer = new PremiumCustomer3("강감찬");
		
		// 주문 생성 및 계산 (RegularCustomer)
		Order3 regularOrder = new Order3(regularCustomer, 0.01);
		regularOrder.addItem(note, 1, "240901");
		regularOrder.addItem(cloth, 2, "240902");
		
		// 할인된 내역 출력
		regularOrder.printOrderSummary();
		regularOrder.printDiscountDetails();  
		
		// 주문 생성 및 계산 (PremiumCustomer)
		Order3 premiumOrder = new Order3(premiumCustomer, 0.01);
		premiumOrder.addItem(note, 1, "240901");
		premiumOrder.addItem(cloth, 2, "240903");

		premiumOrder.printOrderSummary();
		premiumOrder.printDiscountDetails();  // 할인된 내역 출력
	}
}
