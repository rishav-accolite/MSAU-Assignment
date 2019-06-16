package ms.au.assisgnment.telephone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Network implements NetworkInterface
{
	private String networkName;
	private int numLines;
	private Stack<Integer> freeLines;
	private Set<Integer> busyLines;
	private HashMap<Long,Pair<Long,Integer>> telephoneLineMap;
	public Network(String name, int numlines)
	{
		this.networkName=name;
		freeLines=new Stack<Integer>();
		busyLines=new HashSet<Integer>();
		telephoneLineMap=new HashMap<Long, Pair<Long,Integer>>();
		this.numLines=numlines;
		for(int i=1;i<=this.numLines;i++)
		{
			freeLines.push(i);
		}
		
	}
	public String getNetworkName()
	{
		return this.networkName;
	}
	public boolean isAnyLineAvailable()
	{
		if(freeLines.size()==0)
			return false;
		return true;
	}
	public int getFreeLine()
	{
		if(isAnyLineAvailable())
		{
			return freeLines.pop();
		}
		else
		{
			return -1;
		}
	}
	public boolean establishConnection(long callerNumber,long receiverNumber)
	{
		int freeLine=getFreeLine();
		if(freeLine==-1)
		{
			return false;
		}
		else
		{
			telephoneLineMap.put(callerNumber,new Pair<Long, Integer>(receiverNumber,freeLine));
			telephoneLineMap.put(receiverNumber,new Pair<Long, Integer>(callerNumber,freeLine));
			//connection established
			//ringing
			return true;
		}
	}
	public void closeConnection(long number1,long number2)
	{
		telephoneLineMap.remove(number1);
		Pair<Long,Integer> p=telephoneLineMap.remove(number2);
		int lineNum=p.getSecond();
		busyLines.remove(lineNum);
	}
}
