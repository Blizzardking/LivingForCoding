package puzzle;
import java.util.*;
public class Q40 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc I love you go";
		String[] sArray = s.split(" ");
		System.out.println(Arrays.toString(sArray));
		List<String> list = Arrays.asList(sArray);
        Collections.reverse(list);
        System.out.println(list);
	}

}
