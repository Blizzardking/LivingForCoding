package puzzle;

public class MaxPalindromeSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "babcbabcbaccba";
		System.out.println(getMaxPalindrome(s));
	}
	static String getMaxPalindrome(String s) {
		char[] arr = new char[2 * s.length() + 1];
		int z = 0;
		for(; z < s.length(); z++) {
			arr[2 * z] = '#';
			arr[2 * z + 1] = s.charAt(z);
			
		}
		arr[2 * z] = '#';
		int[] p = new int[arr.length];
		int local_max = 0;
		int local_maxIndex = 0;
		int global_max = 0;
		int global_maxIndex = 0;
		for (int i = 1; i < arr.length; i ++) {
			int rightBound = local_maxIndex + local_max;
			if( i < rightBound) {
				int j = 2 * local_maxIndex - i;
				if(p[j] < rightBound - i) {
					p[i] = p[j];
				}
				else {
					int tempMax = rightBound - i;
					//code here to handle right expand;
					while (i - tempMax >= 0 && i + tempMax < arr.length
							&& arr[i - tempMax] == arr[i + tempMax]) {
						tempMax++;
					}
					
					local_maxIndex = i;
					local_max = tempMax - 1;
					p[i] = local_max;
				}
			}
			else {
				int tempMax = 0;			
				while (i - tempMax >= 0 && i + tempMax < arr.length
						&& arr[i - tempMax] == arr[i + tempMax]) {
					tempMax++;
				}
				local_maxIndex = i;
				local_max = tempMax - 1;
				p[i] = local_max;
			}
			if(p[i] > global_max) {
				global_max = p[i];
				global_maxIndex = i;
			}
		}
		String str = "";
		for(int j = global_maxIndex - global_max; j <= global_maxIndex + global_max; j++) {
			if(arr[j] != '#') 
				str += arr[j];
		}
		return str;
	}

}
