package chapter1;

public class URLify {
	// This method will take O(n2) time
	static String replaceCharacter1(String str, int trueLength) {
		char[] strCharArray = str.toCharArray();
		for(int i=0;i<trueLength;i++) {
			if(strCharArray[i] == ' ') {
				for(int j=trueLength-1;j>i;j--) {
					strCharArray[j+2] = strCharArray[j];
				}
				trueLength+=2;
				strCharArray[i] = '%';
				strCharArray[i+1] = '2';
				strCharArray[i+2] = '0';
				i+=3;
			}
		}
		return new String(strCharArray).substring(0,trueLength);
	}
	
	// This method will do it in O(n) time
	static String replaceCharacter2(String str, int trueLength) {
		int noOfSpaces = 0;
		char[] strCharArray = str.toCharArray();
		for(int i=0;i<trueLength;i++) {
			if(strCharArray[i] == ' ') noOfSpaces++;
		}
		int lastIndex = trueLength + 2 * noOfSpaces -1;
		while(trueLength>0) {
			if(strCharArray[trueLength-1] != ' ') {
				strCharArray[lastIndex] = strCharArray[trueLength-1];
				lastIndex--;
			}else {
				strCharArray[lastIndex] = '0';
				strCharArray[lastIndex-1] = '2';
				strCharArray[lastIndex-2] = '%';
				lastIndex=-3;
			}
			trueLength--;
		}
		return new String(strCharArray);
	}	
	
	
	public static void main(String[] args) {
		String test1 = "hello dear friend         ";
		
		System.out.println(replaceCharacter2(test1,17));
	}
}
