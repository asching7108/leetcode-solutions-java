class Solution {
    public String multiply(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }
        if (num1.length() < num2.length()) {
            return multiplyHelper(num2, num1);
        }
        return multiplyHelper(num1, num2);
    }
    
    private String multiplyHelper(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int l1 = num1.length(), l2 = num2.length(), carry = 0;
        for (int i = 1; i <= l1 + l2 - 1; i++) {
            for (int j = Math.max(1, i - l1 + 1); j <= Math.min(l2, i); j++) {
                int digit1 = num1.charAt(l1 - (i - j + 1)) - '0';
                int digit2 = num2.charAt(l2 - j) - '0';
                carry += digit1 * digit2;
            }
            sb.append(carry % 10);
            carry /= 10;
        }
        while (carry > 0) {
            sb.append(carry % 10);
            carry /= 10;            
        }
        return sb.reverse().toString();
    }
}