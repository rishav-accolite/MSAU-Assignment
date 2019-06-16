package ms.au.assisgnment.telephone;

public interface TelephoneInterface {
	public void saveContact(String name,Long number);
	public void call(Long number);
	public void cutCall(Long number);
	public void viewAllCallHistory();
	public void viewCallHistoryForNumber(Long number);
	void receive();

}
