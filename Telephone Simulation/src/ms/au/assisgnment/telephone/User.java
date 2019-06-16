package ms.au.assisgnment.telephone;

import java.util.Scanner;

public class User {
	private String name;
	private Telephone telephone;
	public User(String name,Telephone telephone)
	{
		this.name=name;
		this.telephone=telephone;
	}
	
	public String getName() {
		return name;
	}

	public Telephone getTelephone() {
		return telephone;
	}

	public static void main(String[] args) {
		Scanner inp=new Scanner(System.in);
		System.out.println("Enter the properties of the network");
		System.out.println("Enter the name and number of lines in the network");
		Network net=new Network(inp.next(),inp.nextInt());
		System.out.println("Enter the number to be allocated to the telephone");
		Telephone tel=new Telephone(net,inp.nextLong());
		System.out.println("Enter the name of the user");
		inp.nextLine();
		User user=new User(inp.nextLine(),tel);
		System.out.println("Enter 1-save a contact 2-view call history 3- Call someone 4- Exit");
		while(true)
		{
			int choice=inp.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter name and number");
				inp.nextLine();
				user.getTelephone().saveContact(inp.nextLine(),inp.nextLong());
				System.out.println("Contact saved successfully");
				break;
			case 2:
				System.out.println("Enter 1-view all call logs,2-call logs for a particular number");
				int ch=inp.nextInt();
				switch(ch)
				{
				case 1:
					user.getTelephone().viewAllCallHistory();
					break;
				case 2:
					System.out.println("1-call logs by contact,2-call logs by number");
					int ch1=inp.nextInt();
					switch(ch1)
					{
					case 1:
						System.out.println("Enter contact name");
						inp.nextLine();
						String nm=inp.nextLine();
						user.telephone.viewCallHistoryForNumber(user.telephone.getNumberFromContactName(nm));
						break;
					case 2:
						System.out.println("Enter the number");
						user.telephone.viewCallHistoryForNumber(inp.nextLong());
						break;
					default:
						System.out.println("Inavlid Selection");
							
					}
					break;
				default:
					System.out.println("Inavlid Selection");					
				}
				break;
			case 3:
				System.out.println("1-call by contact name,2-call by number");
				int ch2=inp.nextInt();
				Long calledNumber=null;
				switch(ch2)
				{
				case 1:
					System.out.println("Enter contact name");
					inp.nextLine();
					String nm=inp.nextLine();
					calledNumber=user.telephone.getNumberFromContactName(nm);
					break;
				case 2:
					System.out.println("Enter the number");
					calledNumber=inp.nextLong();
					break;
				default:
					System.out.println("Inavlid Selection");
						
				}
				if(ch2==1||ch2==2)
				{
					if(calledNumber!=null)
					{
						user.telephone.call(calledNumber);
						int stop=Integer.MAX_VALUE;
						System.out.println("Enter any number to cut call");
						stop=inp.nextInt();
						user.telephone.cutCall(calledNumber);
						System.out.println("Call cut succesfully");
					}
					else
					{
						System.out.println("Nothing to call");
					}
					
					
				}
				break;
			case 4:
				inp.close();
				System.exit(100);
				break;
			default:
				System.out.println("Invalid Selection");
				
			}
		}
	}

}
