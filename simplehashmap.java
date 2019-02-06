package arrayclass;

import java.util.Scanner;

class array{
	String name;
	String email;
	int id;
	link next;
	
	
	public array(String name,String email,int id) {
		
		this.email=email;
		this.name=name;
		this.id=id;
		next=null;
	}
	
	public String getemail()
	{
		return email;
	}
	
	public String getname()
	{
		return name;
	}
}

class link{
	link next;
	String name,email;
	int id;
	
	link()
	{
		name=null;
		email=null;
		id=0;
		next=null;
	}
	
	link(String name,String email,int id)
	{
		this.name=name;
		this.email=email;
		this.id=id;
		next=null;
	}
	
	public String getname()
	{
		return name;
	}
	
	public String getemail()
	{
		return email;
	}
	
	public int id()
	{
		return id;
	}
}


class findhash{
	
	public int findarray(String key)
	{
        int namelength=key.length();
        int total=0;
        for(int i=0;i<namelength;i++)
        {
            char ch=key.charAt(i);
            int digit=(int)ch;
            total=total+digit;
        }
        total=total%10;
        return total;
	}
	
	public void printdata(link node,String name,String email)
	{
		while(node!=null)
		{
			if(name.compareTo(node.name)==0 && email.compareTo(node.email)==0)
			{
				System.out.println(node.email+" "+node.id);
				break;
			}
			node=node.next;
		}
	}
	
	public void hashmap(link node,String name,String email,int id)
	{
		while(node!=null)
		{
			node=node.next;
		}
		node.next=new link(name,email,id);
		
	}
}

public class arrayclass {
	
	public static void main(String args[])
	{
		array[] a;
		
		findhash f=new findhash();
		
		Scanner input=new Scanner(System.in);
		
		a=new array[10];
		int ex;
		do {
			
			System.out.println("1.insert\n2.search\n3.exit");
			ex=input.nextInt();
			
			switch(ex)
			{
			case 1:
				System.out.println("Enter the name : ");
				String name=input.next();
				System.out.println("Enter the mail : ");
				String email=input.next();
				System.out.println("Enter the id : ");
				int id=input.nextInt();
				int out=f.findarray(name);
				
				if(a[out]==null)
					a[out]=new array(name,email,id);
				else if(a[out].next==null)
					a[out].next=new link(name,email,id);
				else 
					f.hashmap(a[out].next,name,email,id);
			break;
			case 2:
				System.out.println("Enter the name : ");
				String name1=input.next();
				System.out.println("Enter the email : ");
				String email1=input.next();
				int out1=f.findarray(name1);
				if(name1.compareTo(a[out1].name)==0 && email1.compareTo(a[out1].email)==0)
				{
					System.out.println(a[out1].email+" "+a[out1].id);
				}else if(a[out1].next!=null)
				{
					f.printdata(a[out1].next,name1,email1);
				}else {
					System.out.println("No data found");
				}
			break;
			case 3:
				System.out.println("Exit");
			break;
			default:
				System.out.println("Please select the correct option");
			break;	
			}
		}while(ex!=3);
	}
}
