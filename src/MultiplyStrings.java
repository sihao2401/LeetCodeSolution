public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) return "0";
        int[] digits = new int[num1.length()+num2.length()];
        for(int i = num1.length()-1; i>=0 ;i--){
            for(int j = num2.length()-1; j>=0; j--){
                int product = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int p1 = i+j;
                int p2 = i+j+1;
                int sum = product + digits[p2];
                digits[p2] = sum%10;
                digits[p1] += sum/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<digits.length ; i++){
            if(!(digits[i]==0 && sb.length()==0)){
                sb.append(digits[i]);
            }
        }
        return sb.length()==0?"0":sb.toString();
    }
}
