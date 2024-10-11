package dataStructure.chap01;

public class Test13_문자열변환 {

	public static void main(String[] args) {
		boolean bool3 = Boolean.parseBoolean("true");
		byte b3 = Byte.parseByte("12");
		double d3 = Double.parseDouble("3.14");
		float f3 = Float.parseFloat("10.5f");
		int i3 = Integer.parseInt("123");
		long l3 = Long.parseLong("123456789");
		short s3 = Short.parseShort("256");

		System.out.println("f3 = " + f3);
		float f = 3.14f;
		float obj5 = f;
		System.out.println("f = " + f);

		//정수를 문자열로 변환하는 방법
		int num = 10;
		String s = Integer.toString(num);
		String s2 = String.valueOf(num);
		String s4 = String.format("%d", num);
		}
}	