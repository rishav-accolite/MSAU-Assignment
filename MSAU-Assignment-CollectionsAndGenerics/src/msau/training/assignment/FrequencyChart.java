package msau.training.assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequencyChart {
	
	public static Map<Character,Integer> generateFrequency(String s)
	{
		s=s.toUpperCase();
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			map.put(c,map.getOrDefault(c,0)+1);
		}
		return map;		
	}
	public static void printVerticalChart(Map<Character,Integer> map)
	{
		for(char c='A';c<='Z';c++)
		{
			if(map.containsKey(c))
			{
				System.out.print(c+" ");
				for(int i=0;i<map.get(c);i++)
					System.out.print("#");
				System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		Scanner inp=new Scanner(System.in);
		System.out.println("Enter the string");
		String s=inp.nextLine();
		printVerticalChart(generateFrequency(s));
		inp.close();
		
	}

}
