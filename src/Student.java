import java.util.ArrayList;
import java.time.LocalTime;

public class Student extends Person
{
	int maxCredits;
	int currentCredits;
	ArrayList<Course>courses;
	
	public Student(String username,String password,int maxCredits)
	{
		super(username,password);
		this.maxCredits=maxCredits;
		this.currentCredits=0;
		this.courses=new ArrayList<>();
	}
	
	public Student(String username,String password,int maxCredits,int currentCredits)
	{
		super(username,password);
		this.maxCredits=maxCredits;
		this.currentCredits=currentCredits;
		this.courses=new ArrayList<>();
	}
	
	public int getMaxCredits()
	{
		return this.maxCredits;
	}
	public int getCurrentCredits()
	{
		return this.currentCredits;
	}
	
	public void addCourse(Course c)
	{
		
		if(this.getMaxCredits()<=this.getCurrentCredits()+c.credits)
		{
			return;
		}
		if(c.current_capacity==c.maxCapacity)
		{
			return;
		}
		
		for(Course c1:courses)
		{
			if(c1.getSchedule().equals(c.getSchedule()))
			{
				return;
			}
			String c1_Schedule=c1.getSchedule();
			String c_Schedule=c.getSchedule();
			
			String day1=c1_Schedule.substring(0,2);
			String day2=c1_Schedule.substring(2,4);
			String day3=c1_Schedule.substring(4,6);
			Character time1=c1_Schedule.charAt(6);
			
			String day11=c_Schedule.substring(0,2);
			String day22=c_Schedule.substring(2,4);
			String day33=c_Schedule.substring(4,6);
			Character time11=c_Schedule.charAt(6);
			
			if(time1.charValue()==time11.charValue())
			{
				String[] arr1=new String[3];
				String[] arr2=new String[3];
				arr1[0]=day1;
				arr1[1]=day2;
				arr1[2]=day3;
				arr2[0]=day11;
				arr2[1]=day22;
				arr2[2]=day33;
				for(int i=0;i<3;i++)
				{
					for(int j=0;j<3;j++)
					{
						if(arr1[i].equals(arr2[j]))
						{
							return;
						}
					}
				}
			}
		}
		this.courses.add(c);
		c.current_capacity++;
	}
	
	public void submitAssign(Course c,Assignment a,LocalTime Curr)
	{
		if(Curr.compareTo(a.getDeadline().getStartTime())>=0&&Curr.compareTo(a.getDeadline().getEndTime())<0)
		{
			Course.KeyPair pair=c.new KeyPair(this.getUsername(),a.getID());
			c.getMap().put(pair,true);
		}
		else
		{
			Course.KeyPair pair=c.new KeyPair(this.getUsername(),a.getID());
			c.getMap().put(pair,false);
		}
	}
	
	
}
