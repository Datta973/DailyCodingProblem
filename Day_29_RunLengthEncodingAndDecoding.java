/*

Run-length encoding is a fast and simple method of encoding strings. 
The basic idea is to represent repeated successive characters as a single count and character. 
For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

Implement run-length encoding and decoding. 
You can assume the string to be encoded have no digits and consists solely of alphabetic characters. 
You can assume the string to be decoded is valid.

*/

public class Day_29_RunLengthEncodingAndDecoding{
	public static void main(String[] args) {
		String encodedString = encode("AAAABBBCCDAA");
		System.out.println("AAAABBBCCDAA" +" -> "+ encodedString);
		System.out.println(encodedString + " -> "+ decode(encodedString));
	}

	// Time O(n)
	// Space O(1) - no extra space is used
	private static String encode(String s){
		StringBuilder ans = new StringBuilder();
		int n = s.length(), i = 0;

		for(int j=1;j<n;j++){
			if(s.charAt(j) != s.charAt(j-1)){
				ans.append(j-i).append(s.charAt(j-1));
				i = j;
			}
		}

		ans.append(n-i).append(s.charAt(n-1));

		return ans.toString();
	}

	// Time O(n)
	// Space O(1) - no extra space is used
	private static String decode(String s){
		StringBuilder ans = new StringBuilder(), sb = new StringBuilder();
		int n=s.length();

		for(int i=0;i<n;i++){
			int num = 0;
			for(char ch='.';(ch = s.charAt(i)) >= '0' && ch <= '9';i++)
				num = num*10 + (ch-'0');

			char ch = s.charAt(i);
			for(int k=0;k<num;k++)
				ans.append(ch);
		}

		return ans.toString();
	}
}