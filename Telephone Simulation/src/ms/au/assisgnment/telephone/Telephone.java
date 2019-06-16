package ms.au.assisgnment.telephone;
import java.util.ArrayList;
import java.util.HashMap;


public class Telephone implements TelephoneInterface{
	private long telephoneNumber;
	private HashMap<String,Long> contacts;
	private ArrayList<CallDetails> callHistory;
	private HashMap<Long,ArrayList<CallDetails>> numberWiseCallHistory;
	
	private Network network;
	public Telephone(Network net,Long number)
	{
		this.telephoneNumber=number;
		this.network=net;
		contacts=new HashMap<String, Long>();
		callHistory=new ArrayList<CallDetails>();
		numberWiseCallHistory=new HashMap<Long, ArrayList<CallDetails>>();
	}
	public Long getThisTelephoneNumber()
	{
		return this.telephoneNumber;
	}
	public Long getNumberFromContactName(String name)
	{
		return contacts.getOrDefault(name.toLowerCase(), null);
	}
	public void saveContact(String name,Long number)
	{
		contacts.put(name.toLowerCase(),number);
	}
	public void call(Long number)
	{
		if(number==null)
		{
			System.out.println("No number entered hence call can't be connected ");
			return;
		}
		if(network==null)
		{
			System.out.println("Telephone is not connected to any network");
		}
		else if(this.network.establishConnection(this.telephoneNumber, number))
		{
			CallDetails cd=new CallDetails(number,"outgoing",System.currentTimeMillis());
			callHistory.add(cd);
			System.out.println("Call connected");
			ArrayList<CallDetails> historyofNumber=numberWiseCallHistory.getOrDefault(number, null);
			if(historyofNumber==null)
			{
				ArrayList<CallDetails> ar=new ArrayList<CallDetails>();
				ar.add(cd);
				numberWiseCallHistory.put(number, ar);
			}
			else
			{
				numberWiseCallHistory.get(number).add(cd);
			}
			
		}
		else
		{
			System.out.println("Call cannot be connected-Lines busy");
		}
	}
	public void receive()
	{
		System.out.println("Call received");
	}
	public void cutCall(Long number)
	{
		this.network.closeConnection(this.telephoneNumber,number );
		ArrayList<CallDetails> ar=numberWiseCallHistory.get(number);
		ar.get(ar.size()-1).setEndTime(System.currentTimeMillis());
	}
	public void viewAllCallHistory()
	{
		for(CallDetails cd: this.callHistory)
		{
			System.out.println(cd.getDialedOrRecivednumber()+", Call type= "+cd.getCallType()+",start time= "+cd.getStartTimeInDateFormat()+
					", end time= "+cd.getEndTimeInDateFormat()+", Duration= "+cd.getDurationInSeconds()+" seconds");
		}
	}
	public void viewCallHistoryForNumber(Long number)
	{
		if(number==null)
		{
			return;
		}
		ArrayList<CallDetails> ar=this.numberWiseCallHistory.getOrDefault(number, null);
		if(ar!=null)
		{
			for(CallDetails cd: ar)
			{
				System.out.println(cd.getDialedOrRecivednumber()+", Call type= "+cd.getCallType()+",start time= "+cd.getStartTimeInDateFormat()+
						", end time= "+cd.getEndTimeInDateFormat()+", Duration= "+cd.getDurationInSeconds()+" seconds");
			}
		}
	}
}
