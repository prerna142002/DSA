package video;

public class ReverseAnArray {

	public static void main(String[] args) {
		int[] a = {23,14,6,2,7};
		// 7 2 6 14 23
		
		int start = 0, end = a.length-1;
		
		while(start<end) {
			int temp = a[start];
			a[start] = a[end];
			a[end] = temp;
		}
		
		
//		int[] b = new int[a.length];
//		int index = 0;
//		for(int i = a.length-1 ; i>=0 ; i--) {
//			b[index] = a[i];
//			index++;
//		}
		
		for(int i: a) System.out.print(i+" ");
	}

}
