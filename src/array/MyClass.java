package array;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

class MyClass {
	public static void main(String[] args) {
		Integer[] arr= new Integer[]{10,3,10,2,20};
		
		List<Integer> list = Arrays.asList(arr);
		
		OptionalDouble average = list.stream().mapToInt(n -> n*n).filter(n-> n>=10).average();
		
		if(average.isPresent()) {
			System.out.println(average.getAsDouble());
		}
		
	}
}
