package msau.training.assignment;

import java.util.ArrayList;
import java.util.Collections;

class MyGeneric<T> implements Comparable<MyGeneric<T>>
{
	private T ob;
	private int value;
	public MyGeneric(T ob,int value) {
		this.ob=ob;
		this.value=value;
	}
	public T getOb() {
		return ob;
	}
	public void setOb(T ob) {
		this.ob = ob;
	}
	
	

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public int compareTo(MyGeneric<T> o) {
		if(this.value<o.value)
		{
			return -1;
		}
		else if(this.value==o.value)
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		else
		{
			if(this.getClass().equals(obj.getClass()))
			{
				@SuppressWarnings("unchecked")
				MyGeneric<T> genObj=(MyGeneric<T>)obj;
				if(this.getOb().equals(genObj.getOb())&&this.getValue()==genObj.getValue())
				{
					return true;
				}
			}
			return false;
		}
	}
	@Override
	public String toString() {
		return "\'T object = "+ob.toString()+", value= "+value+"\'";
	}
	
}

public class GenericsClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyGeneric<Long> ob1=new MyGeneric<Long>(45L,30);
		MyGeneric<Long> ob2=new MyGeneric<Long>(45L, 30);
		if(ob1.equals(ob2))
		{
			System.out.println("Both objects are equal in terms of data");
		}
		else
		{
			System.out.println("Objects are not equal at all");
		}
		ArrayList<MyGeneric> ar=new ArrayList<>();
		for(int i=10;i>=1;i--)
		{
			ar.add(new MyGeneric<Long>(i+20L, i));
		}
		Collections.sort(ar);
		System.out.println("Sorted objects in terms of value are as follows");
		System.out.println(ar);
		
		

	}

}
