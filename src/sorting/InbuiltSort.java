package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InbuiltSort {

	public static void main(String[] args) {

		Integer arr[] = { -2, 3, 4, -1, 5, -12, 6, 1, 3 };
		List<Integer> list = Arrays.asList(arr);
		Collections.sort(list,new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				Integer a1=(Integer)o1;
				Integer a2=(Integer)o2;
				if(a1<a2) 
					return 1;
				else if(a1==a2)
					return 0;
				else
					return -1;
			}
			
		});
		
		for(Integer s: list) {
			System.out.print(s+" ");
		}

	}

}
