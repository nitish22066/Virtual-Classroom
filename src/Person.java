public abstract class Person 
{
	private String username;//username
	private String password;//password -- can add check for special chars and symbols
	
	
	public Person(String username,String password)
	{
		this.username=username;
		if(setPassword(password))
		{
			this.password=password;
		}
		try 
		{
			int x=this.getPassword().length();
		}
		catch (NullPointerException e)
		{
			System.out.println("Please set a password satisfying the given requirements!");
		}
	}
	
	public String getUsername()
	{
		return this.username;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setUsername(String username)
	{
		this.username=username;
	}
	
	public boolean setPassword(String password)
	{
		if(password.length()<8)
		{
			return false;
		}
		
		boolean check1=false;//check for capitals
		boolean check2=false;//check for special characters 
		
		char []arr=password.toCharArray();
		
		char []special= {'&','%','$','#','!','?','@'};
		
		for(int i=0;i<arr.length;i++)
		{
			if((int)arr[i]>=65&&(int)arr[i]<97)
			{
				check1=true;
			}
			
			if(check2==false)
			{
				for(int j=0;j<special.length;j++)
				{
					if(special[j]==arr[i])
					{
						check2=true;
						break;
					}
				}
			}		
		}
		if(check1&&check2)
		{
			this.password=password;
			return true;
		}
		else
		return false;
	}
}

