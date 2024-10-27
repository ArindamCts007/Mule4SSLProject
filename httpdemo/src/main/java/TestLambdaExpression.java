import java.util.Arrays;
import java.util.List;

public class TestLambdaExpression {
	public static void main(String args[]) {

		String[] myArray = { "a", "b" };
		List<String> abc = Arrays.asList(myArray);

		abc.forEach(a -> {
			if (a.equals("a")) {
				System.out.println("" + a);
			}
		});
		
		abc.forEach(System.out::println);

	}
}