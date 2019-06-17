package msau.training.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FrequencySort {
	public static List<String> getSortedByFrequency(String[] ar)
	{
		Map<String,Integer> map=new HashMap<String, Integer>();
		for(String s:ar)
		{
			map.put(s, map.getOrDefault(s, 0)+1);
		}
		List<Map.Entry<String, Integer>> entries=new ArrayList<>(map.entrySet());
		Collections.sort(entries,new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if(o1.getValue()<=o2.getValue())
				{
					return 1;
				}
				else
				{
					return -1;
				}
			}});
		List<String> sortedStringsByFrequency=new ArrayList<String>();
		for(Map.Entry<String, Integer> entry:entries)
		{
			sortedStringsByFrequency.add(entry.getKey());
		}
		return sortedStringsByFrequency;
	}
	public static void print(List<String> ar)
	{
		for(String s:ar)
		{
			System.out.print(s+", ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner inp=new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int n=inp.nextInt();
		String ar[]=new String[n];
		System.out.println("Enter the string elements(only one word strings)");
		for(int i=0;i<n;i++)
		{
			ar[i]=inp.next();
		}
		System.out.println("Strings in decreasing order of their frequencies are as follows : ");
		print(getSortedByFrequency(ar));
		inp.close();

	}

}
