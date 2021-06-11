package Sorting;

public class MergeSort {
	
	static void mergeSort(int[] a, int l, int h) 
	{
		if(l<h) {
			int mid = (h+l)/2;
			mergeSort(a,l,mid);
			mergeSort(a,mid+1,h);
			merge(a,l,mid,h);
		}
	}

	static void merge(int[] a,int l, int m, int h)
	{
		int i = l, j = m+1,k=l;
		int[] b = new int[h+1];
		
		while(i<=m && j<=h)
		{
			if(a[i]<a[j]) {
				b[k] = a[i];
				k++;i++;
			}
			else {
				b[k] = a[j];
				k++;j++;
			}
			System.out.print(b[k]+" , ");
		}
		
		while(i<=m) {
			b[k] = a[i];
			k++; i++;
		}
		while(j<=h) {
			b[k] = a[j];
			k++; j++;
		}
		
		for(int mm = l;m<=h;mm++)
        {
            a[mm] = b[mm];
        }
	}
	
	
	public static void main(String[] args) {
		int[] a = {28,6,545,21,89,2,4,7,77};
		mergeSort(a,0,a.length-1);
		System.out.println(a);
	}

}
