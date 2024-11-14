package chap02_array;

public class Test03_2_12_기수변환_일반화  {

    // n진수를 10진수로 변환하는 함수
    public static int toDecimal(String number, int baseN) {
        int decimal = 0;
        int length = number.length();
        
        for (int i = 0; i < length; i++) {
            char digitChar = number.charAt(i);
            int digitValue;
            
            // 0-9는 숫자로 처리, A-Z는 문자로 처리
            if (digitChar >= '0' && digitChar <= '9') {
                digitValue = digitChar - '0';
            } else {
                digitValue = digitChar - 'A' + 10;
            }
            
            // 자리수에 해당하는 값 계산
            decimal = decimal * baseN + digitValue;
        }
        
        return decimal;
    }

    // 10진수를 m진수로 변환하는 함수
    public static String fromDecimal(int decimal, int baseM) {
        if (decimal == 0) {
            return "0";
        }
        
        StringBuilder baseMNumber = new StringBuilder();
        
        while (decimal > 0) {
            int remainder = decimal % baseM;
            
            // 나머지를 문자로 변환 (0-9는 그대로, 10 이상은 A-Z로 변환)
            if (remainder < 10) {
                baseMNumber.append((char) (remainder + '0'));
            } else {
                baseMNumber.append((char) (remainder - 10 + 'A'));
            }
            
            decimal /= baseM;
        }
        
        // 결과를 역순으로 반환
        return baseMNumber.reverse().toString();
    }

    // n진수를 m진수로 변환하는 함수
    public static String convertBase(String number, int baseN, int baseM) {
        // n진수를 10진수로 변환
        int decimal = toDecimal(number, baseN);
        // 10진수를 m진수로 변환
        return fromDecimal(decimal, baseM);
    }

    public static void main(String[] args) {
        String number = "345";  // 8진수 예시
        int baseN = 8;  // 입력 진법 (n진법)
        int baseM = 16; // 출력 진법 (m진법)
        
        // n진수 -> m진수 변환 (10진수로 면전 변환 후 m진수로 변환)
        String result = convertBase(number, baseN, baseM);
        System.out.println("Base " + baseN + " number " + number + " in base " + baseM + " is: " + result);
        
        // 8진수 -> 2진수 변환 예시
        baseM = 2;
        result = convertBase(number, baseN, baseM);
        System.out.println("Base " + baseN + " number " + number + " in base " + baseM + " is: " + result);
    }
}
