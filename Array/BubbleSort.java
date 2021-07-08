public class BubbleSort {

	public static void main(String[] args) {
		
		int[] a = {35,45,3,24,5};
//		3, 5 , 24, 35, 45
		
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length-1-i;j++)
			{
				if(a[j]>a[j+1]) 
				{
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		for(int i: a) System.out.print(i+" ");
				

	}

}
