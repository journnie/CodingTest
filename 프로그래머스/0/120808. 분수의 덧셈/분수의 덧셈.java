class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
		    int numerator = numer1*denom2 + numer2*denom1;
		    int denominator = denom1*denom2;
		    
		    // 최대공약수 구하기
		    
		    int a = numerator;
		    int b = denominator;
		    if (b > a){
				    int temp = a;
				    a = b;
				    b = temp;
				 }
		    
		    while(b!=0){	    
				    int temp = b;
				    b = a%b;
				    a = temp;
		    }
		    int gcd = a;
		   
        
        int[] answer = {numerator/gcd, denominator/gcd};
        return answer;
    }
}