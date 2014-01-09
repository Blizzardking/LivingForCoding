package puzzle;
import java.util.*;
public class Q117FindValidIP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ip= "101010101";
		String i = "01";

		System.out.println(ip.substring(1,2).equals('0'));
		Set<String> set= findValidIp(ip);
		System.out.print(set);
	}
	static Set<String> findValidIp(String s) {
		if(s.length() < 4) {
			System.err.println("No a valid ip address");
			System.exit(-1);
		}
		Set<String> set = new HashSet<String>();
		for(int i = 1; i < s.length() - 3; i++) {
			if(Integer.valueOf(s.substring(0, i)) > 255)
				break;			
			for(int j = i + 1; j < s.length() - 2; j++) {
				if(Integer.valueOf(s.substring(i, j)) > 255)
					break;
				for(int k = j + 1; k < s.length() - 1; k++) {
					if(Integer.valueOf(s.substring(j, k)) > 255)
						break;
					//set.add(s.substring(0, i))
					
					if((s.substring(0, i).equals("0")||s.charAt(0) !='0')
							&& (s.substring(i, j).equals("0")||s.charAt(i) !='0' )
							&& (s.substring(j, k).equals("0")||s.charAt(j) !='0')
							&& (s.charAt(k) !='0' && Integer.valueOf(s.substring(k)) <= 255))
						set.add(s.substring(0, i) + "." + s.substring(i, j) + "."
								+ s.substring(j, k) + "." + s.substring(k));
					
				}
			}
		}
		return set;
	}

}
