package sorting;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

/**
 * @author kansanja on 14/12/24.
 */
public class BucketSort<T extends Number & Comparable<T>> {

    public List<T> sort(List<T> list, BiFunction<T, Integer, Integer> function) {

        //create buckets equal to size of list
        int numOfBuckets = list.size();
        Map<Integer, List<T>> buckets = new HashMap<>();
        IntStream.range(0, numOfBuckets).forEach(i -> buckets.put(i, new ArrayList<>()));

        //Map elements to buckets based on Bifunction logic
        list.forEach(item -> buckets.get(function.apply(item, numOfBuckets)).add(item));

        //Individually sort each bucket using any sorting algorithm(here sort function inherently uses Tim sort)
        buckets.values().forEach(Collections::sort);

        // return sorted list
        return buckets.values().stream().flatMap(Collection::stream).toList();

    }


    public static void main(String[] args) {
        List<Float> floats = Arrays.asList(0.42F, 0.32F, 0.63F, 0.82F, 0.37F, 0.17F, 0.51F, 0.21F, 0.22F, 0.75F);
        System.out.println(new BucketSort<Float>().sort(floats, (item, size) -> (int) (item * size)));
    }

}
