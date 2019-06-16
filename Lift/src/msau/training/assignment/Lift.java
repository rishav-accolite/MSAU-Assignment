package msau.training.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


class User
{
	int userId;
	int destination;
}
class FloorCompare implements Comparator<User>
{

	@Override
	public int compare(User o1, User o2) {
		if(o1.destination<o2.destination)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}

	
}


public class Lift {
	
	public static void reverse(ArrayList<User> ar,int from,int to)
	{
		while(from<to)
		{
			User temp=ar.get(from);
			ar.set(from, ar.get(to));
			ar.set(to, temp);
			from++;
			to--;
		}
	}
	
	public static void main(String[] args) {
		Scanner inp=new Scanner(System.in);
		System.out.println("Enter the number of users");
		int n=inp.nextInt();
		System.out.println("Enter the current floor");
		int currFloor=inp.nextInt();
		System.out.println("Enter userId,destination for each user");
		ArrayList<User> liftA=new ArrayList<User>();
		ArrayList<User> liftB=new ArrayList<User>();
		for(int i=0;i<n;i++)
		{
			User user=new User();
			user.userId=inp.nextInt();
			user.destination=inp.nextInt();
			if(user.destination<currFloor)
			{
				liftB.add(user);
			}
			else
			{
				liftA.add(user);
			}
		}
		FloorCompare dc=new FloorCompare();
		Collections.sort(liftA,dc);
		Collections.sort(liftB,dc);
		if(liftA.size()==0) //Edge case
		{
			for(int i=0;i<n/2;i++)
			{
				liftA.add(liftB.remove(liftB.size()-1));
			}
			Collections.reverse(liftB);
		}
		else if(liftB.size()==0) //Edge Case
		{
			for(int i=0;i<n/2;i++)
			{
				liftB.add(liftA.remove(liftA.size()-1));
			}
			Collections.reverse(liftB);
		}
		else
		{
			if(liftA.size()>liftB.size())
			{
				int num=n/2-liftB.size();
				if(!(n%2!=0&&num==1))
				{
					for(int i=1;i<=num;i++)
					{
						liftB.add(liftA.remove(0));
					}
					//logic to set the order of exit of users from the lift
					if(Math.abs(liftB.get(0).destination-currFloor)>Math.abs(liftB.get(liftB.size()-1).destination-currFloor))
					{
						Collections.reverse(liftB);
						reverse(liftB,0,num-1);
					}
					else
					{
						reverse(liftB,0,liftB.size()-num-1);
					}
				}
				else
				{
					Collections.reverse(liftB);
				}
			}
			else if(liftA.size()<liftB.size())
			{
				int num=n/2-liftA.size();
				int prevSize=liftA.size();
				if(!(n%2!=0&&num==1))
				{
					for(int i=1;i<=num;i++)
					{
						liftA.add(liftB.remove(liftB.size()-1));
					}
					//logic to set the order of exit of users from the lift
					if(Math.abs(liftA.get(prevSize-1).destination-currFloor)>Math.abs(liftA.get(liftA.size()-1).destination-currFloor))
					{
						Collections.reverse(liftA);
						reverse(liftA,0,num-1);
						reverse(liftA,num,liftA.size()-1);
					}
				}
				Collections.reverse(liftB);
			}
		}
		System.out.println("Lift A");
		for(int i=0;i<liftA.size();i++)
		{
			System.out.println("user - "+liftA.get(i).userId+", floor - "+liftA.get(i).destination);
		}
		System.out.println("******************************************************");
		System.out.println("Lift B");
		
		for(int i=0;i<liftB.size();i++)
		{
			System.out.println("user - "+liftB.get(i).userId+", floor - "+liftB.get(i).destination);
		}
		inp.close();
		
	}

}
