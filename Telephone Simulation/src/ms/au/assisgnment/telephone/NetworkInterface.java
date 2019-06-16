package ms.au.assisgnment.telephone;

public interface NetworkInterface {
	public boolean establishConnection(long callerNumber,long receiverNumber);
	public void closeConnection(long number1,long number2);

}
