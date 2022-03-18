import java.util.*;

public class routesNodes {
	
	static void nodes(ArrayList<ArrayList<Integer>> graphs,int end, int i,ArrayList<Integer> path)
	{
		if( (i != end) && ( graphs.get(i) == null ) ) return;
		
		if( (i == end) )
		{
			System.out.println(path);
			return;
		}
		
//		System.out.println("middle part "+path);
		ArrayList<Integer> val = graphs.get(i);
		for(int index=0;index<val.size();index++)
		{
			int temp = val.get(index);
			path.add(temp);
			
			nodes(graphs,end,temp,path);
			path.remove(path.size()-1);
		}
		
	}

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> graphs = new ArrayList<>();
		
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(5);
		list1.add(2);
		
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(3);
		
		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(4);
		
		ArrayList<Integer> list4 = new ArrayList<>();
		list4.add(6);
		
		ArrayList<Integer> list5 = new ArrayList<>();
		list5.add(3);
		list5.add(7);
		
		ArrayList<Integer> list6 = new ArrayList<>();
		
		ArrayList<Integer> list7 = new ArrayList<>();
		
		graphs.add(list1);
		graphs.add(list2);
		graphs.add(list3);
		graphs.add(list4);
		graphs.add(list5);
		graphs.add(list6);
		graphs.add(list7);
		graphs.add(1,list1);
		System.out.println(graphs);
		
		
		int start = 1 ;
		ArrayList<Integer> path = new ArrayList<>();
		path.add(start);
		nodes(graphs,6,0,path);

	}

}
