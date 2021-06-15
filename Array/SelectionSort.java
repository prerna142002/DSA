package video;

public class SelectionSort {

	public static void main(String[] args) {
		
//		Intialized Array
		int[] a= {26,34,1,3,89,5};
		
		
//		Loop to iterate whole array.
		for(int i=0;i<a.length;i++) {
			
//			Make ith index as minimum.
			int min = a[i], index= i;
			
//			Find the minimum from rest of the array.
			for(int j=i+1;j<a.length;j++) {
				if(min>a[j]) {
					min = a[j];
					index =j;
				}
			}
			
//			If ith index is greater than min then swap. 
			if(min<a[i]) {
				int temp = a[i];
				a[i] = a[index];
				a[index] = temp;
			}
		}
		
//		Printing the sorted array.
		for(int i: a) System.out.print(i+" ");
		

	}

}
