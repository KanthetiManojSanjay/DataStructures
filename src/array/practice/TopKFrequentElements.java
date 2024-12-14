package array.practice;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author kansanja on 14/12/24.
 */
public class TopKFrequentElements {

    // TimeComplexity - O(NLogN), SpaceComplexity - O(N)
    public static int[] topKFrequentBySorting(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> ele : map.entrySet()) {
            list.add(new int[]{ele.getValue(), ele.getKey()});
        }

        // sort the list based on value
        list.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i)[1];
        }
        return res;
    }


    // TimeComplexity - O(NLogK), SpaceComplexity - O(N+K)
    public static int[] topKFrequent_using_heap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // minHeap
        Queue<int[]> heap = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> ele : map.entrySet()) {
            heap.offer(new int[]{ele.getValue(), ele.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }
        return res;
    }

    // TimeComplexity - O(N), SpaceComplexity - O(N)
    public static int[] topKFrequent_using_bucketSort(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // Creating Array that holds List of Integers. Array size equal to length of nums
        List<Integer>[] freq = new List[nums.length +1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //Add elements to respective index based on frequency
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        // Iterate from end to get top K elements
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                //Iterate over list within a specific index
                res[index++] = n;
                //Return once the count reaches K
                if (index == k)
                    return res;
            }
        }
        return res;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> list = map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(k)
                .collect(Collectors.mapping(Map.Entry::getKey, Collectors.toList()));

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 2, 3, 3, 3};
/*        int[] res = topKFrequent(nums, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }*/

        int[] res = topKFrequent_using_bucketSort(nums, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
