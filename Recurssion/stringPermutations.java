public class stringPermutations {

	static void perm(String s, int index, String temp)
	{
		if(index == s.length()) 
			{
				System.out.println(temp);
				return;
			}
		
		perm(s,index+1,temp);
		temp+=s.charAt(index);
		perm(s,index+1,temp);
	}
	
	public static void main(String[] args) {
		String s = "abdc";
		perm(s,0,"");

	}

}
