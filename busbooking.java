package main;

import java.util.Scanner;


class treenode{
	
	treenode left , right;
	booking book;
	String email,name,password;
	
	treenode(){
		email=null;
		name=null;
		password=null;
		left=null;
		right=null;
		book=null;
	}
	
	treenode(String email,String name,String password){
		
		this.email=email;
		this.name=name;
		this.password=password;
		left=null;
		right=null;
		book=null;
	}
	
	public void setleft(treenode n)
	{
		left=n;
	}
	
	public void setright(treenode n)
	{
		right=n;
	}
	
	public void setbook(booking n)
	{
		book=n;
	}
	
	public treenode getleft()
	{
		return left;
	}
	
	public treenode getright()
	{
		return right;
	}
	
	public booking getbook() 
	 {
		 return book;
	 }
	
	public void setdata(String email,String name,String password)
	{
		this.email=email;
		this.name=name;
		this.password=password;
	}
	
	 public String getemail()
	 {
		 return email;
	 }
	 
	 public String getname()
	 {
		 return name;
	 }
	 
	 public String getpassword()
	 {
		 return password;
	 }
	 
}

class booking{
	
	booking next;
	
	String email,from,to;
	
	public booking()
	{
		email=null;
		from=null;
		to=null;
		next=null;
	}
	
	public booking(String email,String from,String to)
	{
		this.email=email;
		this.from=from;
		this.to=to;
		next=null;
	}
	
	public booking getnext()
	{
		return next;
	}
	
	public void setdata(String email,String from,String to)
	{
		this.email=email;
		this.from=from;
		this.to=to;	
	}
	
	public String getemail()
	{
		return email;
	}
	
	public String getfrom()
	{
		return from;
	}
	
	public String getto()
	{
		return to;
	}
	
}


class tree{
	private treenode node;
	
	public tree()
	{
		node=null;
	}
	
	public boolean isempty()
	{
		return node==null;
	}
	
	public void insert(String email,String name,String password)
	{
		node=insert(node,email,name,password);
	}
	
	private treenode insert(treenode root,String email,String name,String password)
	{
		if(root==null)
		{
			root=new treenode(email,name,password);
		}
		else {
			if(email.compareTo(root.getemail())<=0)
			{
				root.left=insert(root.left,email,name,password);
			}else
			{
				root.right=insert(root.right,email,name,password);
			}
		}
		return root;
	}
	
	public void login(String email,String password)
	{
		login(node,email,password);
	}
	
	private void login(treenode root,String email,String password)
	{
		if(root==null)
		{
			System.out.println("Empty !");
		}else {
			if(email.compareTo(root.getemail())==0)
			{
				System.out.println("Email finded");
				if(password.compareTo(root.getpassword())==0)
				{
					System.out.println("login Successfully");
					loginprocess(root);
				}else {
					System.out.println("Password incorrect");
				}
			}else if(email.compareTo(root.getemail())<0) {
				login(root.left,email,password);
			}else if(email.compareTo(root.getemail())>0) {
				login(root.right,email,password);
			}
		}
	}
	
	public void loginprocess(treenode root)
	{
		Scanner scan = new Scanner(System.in);
		int ex;
		do {
			System.out.println("1.Booking\n2.histry\n3.delete\n4.exit");
			ex=scan.nextInt();
			
			switch(ex)
			{
			case 1:
				System.out.println("Enter the from");
				String from=scan.next();
				System.out.println("Enter the to");
				String to=scan.next();
				bookbus(root.getbook(),root,root.getemail(),from,to);
			break;
			case 2:
				printhistry(root.getbook());
			break;
			default:
				System.out.println("Enter the correct option");
			break;
			}
		}while(ex!=4);
	}
	
	
	private void bookbus(booking root,treenode first,String email,String from,String to)
	{
		if(root==null)
		{
			first.book=new booking(email,from,to);
			
		}else {
			while(root.getnext()!=null)
			{
				root=root.getnext();
			}
			root.next=new booking(email,from,to);
			
		}
	}
	
	private void printhistry(booking root)
	{
		if(root==null)
		{
			System.out.println("Empty");
		}else {
			System.out.println("Email\tfrom\tTo");
			while(root!=null)
			{
				System.out.println(root.getemail()+root.getfrom()+root.getto());
				root=root.getnext();
			}
		}
	}
	
	public void inorder()
	{
		inorder(node);
	}
	
	private void inorder(treenode root)
	{
		if(root!=null)
		{
			inorder(root.left);
			System.out.println("Email : "+root.getemail()+"  Name : "+root.getname()+"");
			inorder(root.right);
		}
	}
}


public class main {

	public static void main(String args[])
	{
        Scanner scan = new Scanner(System.in);
        
        tree bst = new tree(); 
      
        int choice;
        do    
        {

            System.out.println("\nBinary Search Tree Operations\n");

            System.out.println("1. insert ");

            System.out.println("2. print");

            System.out.println("3. search");

            System.out.println("4. count nodes");

            System.out.println("5. exit"); 

 

            choice = scan.nextInt();            

            switch (choice)

            {

            case 1 : 

                System.out.println("Enter the email : ");
                String email=scan.next();
                System.out.println("Enter the name : ");
                String name=scan.next();
                System.out.println("Enter the password : ");
                String password=scan.next();
                bst.insert(email,name,password);                     

                break;                          

            case 2 : 

                System.out.println("Enter integer element to delete");

                //bst.delete( scan.nextInt() );  
                bst.inorder();

                break;                         

            case 3 : 

                System.out.println("Enter the Email :");
                String emaill=scan.next();
                System.out.println("Enter the password :");
                String passwordl=scan.next();
                bst.login(emaill,passwordl);

                break;                                          

            case 4 : 

                break;     

            case 5 :  

                break;            

            default : 

                System.out.println("Wrong Entry \n ");

                break;   

            }


        } while (choice!=5);
	}
}
