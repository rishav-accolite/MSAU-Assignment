package ms.au.assisgnment.telephone;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class CallDetails
{
	private long dialedOrRecivednumber;
	private Long startTime;
	private Long endTime;
	private String callType;
	public CallDetails(long n,String callType,Long startTime)
	{
		dialedOrRecivednumber=n;
		this.callType=callType;
		this.startTime=startTime;
	}

	public long getDialedOrRecivednumber() {
		return dialedOrRecivednumber;
	}
	
	public String getCallType() {
		return callType;
	}
	public void setEndTime(Long endTime)
	{
		this.endTime=endTime;
	}
	private String convertMilisToDate(Long timeInMilis)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");    
		Date date = new Date(timeInMilis);
		return sdf.format(date);
	}
	public String getStartTimeInDateFormat()
	{
		return this.convertMilisToDate(startTime);
	}
	public String getEndTimeInDateFormat()
	{
		return this.convertMilisToDate(endTime);
	}
	public Long getDurationInSeconds()
	{
		Long diff=endTime-startTime;
		diff/=1000;
		return diff;		
	}
}

