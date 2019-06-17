package msau.training.assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {
	public static boolean isPalindromeAnagram(String s)
	{
		Map<Character,Integer> map=new HashMap<>();
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			map.put(c,map.getOrDefault(c,0)+1);
		}
		int numOdd=0;
		for(Character c:map.keySet())
		{
			if(map.get(c)%2!=0)
			{
				numOdd++;
			}
			if(numOdd>1)
			{
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner inp=new Scanner(System.in);
		System.out.println("Enter the string");
		String s=inp.next();
		if(isPalindromeAnagram(s))
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("NO");
		}
		inp.close();
		
	}

}
