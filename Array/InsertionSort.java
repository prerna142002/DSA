public class InsertionSort {
	public static void main(String[] args)
	{
		int[] a = { 12, 111, 13, 5, 6 };
//		5 6 12 13 111
		
		for(int i=1;i<a.length;i++)
		{
			int temp = a[i];
			int j = i-1;
			
//			for()
			while(j>=0 && a[j]>temp)
			{
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = temp;
		}
		
		for(int i: a) System.out.print(i+" ");
	}
