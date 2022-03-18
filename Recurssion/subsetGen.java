package Recurssion;
import java.util.*;
public class subsetGen {

	static void gen(int index, int[] a, ArrayList<Integer> list)
	{
		
		if(index == a.length)
		{
			System.out.println((9*24)+""+list);
			return;
		}
//		System.out.println(list+" "+a[index]);
		gen(index+1,a,new ArrayList<>(list));
		list.add(a[index]);
		gen(index+1,a,new ArrayList<>(list));
//		list.remove(a[index]);
		
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3};
		gen(0,a,new ArrayList<>());
	}

}
