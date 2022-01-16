package binarySearch;

public class angryBirds {
	
	public static void placeBirds(int[] nests,int birds){
		int length=nests.length;
		int s=nests[0];
		int e=nests[length-1]-nests[0];
		int res=-1;
		while(s<=e) {
			int mid = (s+e)/2;
			boolean canPlace= canPlace(nests,mid,birds);
			if(canPlace) {
				res=mid;
				s=mid+1;
			}else {
				e=mid-1;
			}
		
		}
		System.out.println("Minimum max distance to place birds in nests is : "+res);
		
	}
	
	
	
	private static boolean canPlace(int[] nests, int sep, int birds) {
		// TODO Auto-generated method stub
		int location = nests[0];
		int birds_cnt=1;
		int size = nests.length;
		for(int i=1; i<size;i++) {
			int current_loc= nests[i];
			if(current_loc-location>=sep) {
				birds_cnt++;
				location= current_loc;
				if(birds_cnt==birds) {
					return true;
				}
				
			}
		}
		return false;
	}



	public static void main(String[] args) {
		
		int nests[]= {1,2,4,8,9};
		int noOfBirds =3;
		placeBirds(nests,noOfBirds);
		
		
	}
	
	

}
