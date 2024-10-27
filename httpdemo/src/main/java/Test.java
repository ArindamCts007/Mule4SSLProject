import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String args[]) {

		Integer[] array = { 0, 1, 1, 0, 1, 0, 1, 0 };
		List<Integer> leftarraylist = new ArrayList<Integer>();
		List<Integer> rightArray = new ArrayList<Integer>();
		List<Integer> finalarraylist = new ArrayList<Integer>();
		
		for (Integer element : array) {
			if (element == 1) {
				leftarraylist.add(element);
			}

			if (element == 0) {
				rightArray.add(element);
			}

		}

		finalarraylist.addAll(leftarraylist);
		finalarraylist.addAll(rightArray);

		System.out.println("my new arraylis using the traditional approach befre 1.8: --" + finalarraylist.toArray());

		List<Integer> myList = Arrays.asList(array);
		List<Integer> myListOdd = myList.stream().filter(x -> isOdd(x)).collect(Collectors.toList());
		List<Integer> myListEven = myList.stream().filter(x -> !isOdd(x)).collect(Collectors.toList());
		
		List<Integer> sortedList = myList.stream().sorted((u1,u2) -> mycompare(u1,u2)).collect(Collectors.toList());
		
		List<Integer> sortedList1 = myList.stream().sorted(new Comparator<Integer>() {
		    @Override
		    public int compare(Integer h1, Integer h2) {
		    	int ret = 0;

				if (isOdd(h1) && isOdd(h2)) {
					ret = 1;
				} else if (isOdd(h1) && !isOdd(h2)) {
					ret = 1;
				} else if (!isOdd(h1) && isOdd(h2)) {
					ret = -1;
				}

				return ret;
		    }}).collect(Collectors.toList());

		
		
		System.out.println("This is my list odd :: ===" +myListOdd.toString());
		System.out.println("This is my list even :: ===" +myListEven.toString());
		
		System.out.println("TMy Sorted List:: ===" +sortedList1.toString());
	
	}

	/***
	 * 
	 * this method will be returning od or even
	 * 
	 */

	private static boolean isOdd(int a) {

		boolean odd = false;

		if (a % 2 != 0) {
			odd = true;
		}

		return odd;
	}

	/***
	 * 
	 * this method will be returning od or even
	 * 
	 */

	private static int mycompare(int a, int b) {
		int ret = 0;

		if (isOdd(a) && isOdd(b)) {
			ret = 0;
		} else if (isOdd(a) && !isOdd(b)) {
			ret = -1;
		} else if (!isOdd(a) && isOdd(b)) {
			ret = 1;
		}

		return ret;
	}

}