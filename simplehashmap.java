package arrayclass;

import java.util.Scanner;

class array{
	String name;
	String email;
	int id;
	array next;
	
	
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
}

public class arrayclass {
	
	public static void main(String args[])
	{
		array[] a;
		
		findhash f=new findhash();
		
		Scanner input=new Scanner(System.in);
		
		a=new array[10];
		
		System.out.println("Enter the name : ");
		String name=input.next();
		System.out.println("Enter the mail : ");
		String email=input.next();
		
		/*for(int i=0;i<10;i++)
		{
			a[i]=new array("kathir"+i,"kokila"+i,i);
		}*/
		
		int out=f.findarray(name);
		System.out.println(out);
		
		a[out]=new array(name,email,out);
		System.out.println(a[out].name+" : "+a[out].email+" : "+a[out].id);
		
//		for(int i=0;i<10;i++)
//		{
//			System.out.println(a[i].id+" "+a[i].email+" "+a[i].name);
//		}
	}
}
