package binarySearch;

public class rotatedSearch {
	public static void main(String[] args) {
		int[] arr= {8, 11, 13, 15, 1, 4, 6};
		int target=1;
		int index=search(arr,target);
		System.out.println("Index of target is: "+ index);
		
	}

	private static int search(int[] arr, int key) {
		int s= 0;
		int e= arr.length-1;
		while(s<=e) {
			int mid= (s+e)/2;
			if(arr[mid]==key) {
				return mid;
			}
			if(arr[s]<arr[mid]) {
				if(key>=arr[s] && key<arr[mid]) {
					e=mid-1;
				}else {
					s=mid+1;
				}
				
			}else {
				if(key>arr[mid] && key<=arr[e]) {
					s=mid+1;
				}else {
					e=mid-1;
				}
			}
		}
		return -1;
		
	}

}
