package puzzle;

public class AtoI {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String s = " -0078a9";
		System.out.println(atoi(s));
	}
	static int atoi(String s) throws Exception{
		String str = s.trim();
		
		int sum = 0;
		int end = 0;
		int sign = 1;
		if(str.charAt(0) == '-') {
			end = 1;
			sign = -1;
		}
		if(str.charAt(end) > '9' || str.charAt(end) < '0')
			throw new Exception("No number found");
		for(; end < str.length(); end++) {
			if(str.charAt(end) > '9' || str.charAt(end) < '0')
				break;
			else {
				sum += (str.charAt(end) - '0');
				sum *= 10;
			}
		}
		return sign * sum / 10;
	}

}
