/*

Implement a URL shortener with the following methods:

shorten(url), which shortens the url into a six-character alphanumeric string, such as zLg6wl.
restore(short), which expands the shortened string into the original url. 
If no such shortened string exists, return null.

Hint: What if we enter the same URL twice?

*/
import java.util.HashMap;

public class Day_55_URLShortener{
	public static void main(String[] args) {
		URLShortener url = new URLShortener();
		String inp = "https://google.com/";

		String encodedString = url.shorten(inp);
		System.out.println(inp +" -> "+ encodedString);
		System.out.println(encodedString +" -> "+url.restore(encodedString));
	}

	// Space O(n)
	static class URLShortener{
		HashMap<String, String> map = new HashMap<>();
		int D = 6;

		// Time O(n)
		public String shorten(String url){
			int n = url.length(); 
			StringBuilder urlSb = new StringBuilder(url);
			int rem = (D - (n % D)) % D;

			for(int i=0;i<rem;i++){
				urlSb.append('0');
			}

			n = urlSb.length();

			String[] blocks = new String[n/D];
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<n;i+=D){
				sb.setLength(0);

				for(int j=i;j<i+6;j++)
					sb.append(urlSb.charAt(j));

				blocks[i/D] = sb.toString();
			}

			sb.setLength(0);

			for(int i=0;i<D;i++){
				int hash = 0;
				int a = 10;
				int k = blocks.length;

				// h(s) = Sum( cj * a^(k-j) ) 
				for(int j=0;j<k;j++){
					hash += (int)(blocks[j].charAt(i) * Math.pow(a, k-(j+1)));
				}

				sb.append(toAlphaNumeric(hash));
			}

			map.put(sb.toString(), url);
			return sb.toString();
		}

		// Time O(1)
		public String restore(String shortUrl){
			return map.get(shortUrl);
		}

		// Time O(1)
		private char toAlphaNumeric(int hash){
			hash = hash % 62;
			return (char)(hash < 26 ? hash + 'a' : ( hash < 52 ? (hash - 26) + 'A' : (hash - 52) + '0'));
		}
	}
}