package practice;

public class squareRoot {
	public static float root(int N, int P){
		int s=0;
		int e=N;
		float ans=-1;
		while(s<=e) {
			int mid= (s+e)/2;
			if(mid*mid==N) {
				return mid;
			}else if(mid*mid<N) {
				ans=mid;
				s=mid+1;
			}else {
				e=mid-1;
			}
		}
		
		float inc=0.1F;
		for(int place=1;place<=P;place++) {
			while(ans*ans<=N) {
				ans+=inc;
			}
			ans-=inc;
			inc/=10.0F;
		}

		return ans;
		
	}

	public static void main(String[] args) {
		int N= 10;
		int P=3;
		float res= root(N,P);
		System.out.println("Sqaure root is: "+res);
	}
}
