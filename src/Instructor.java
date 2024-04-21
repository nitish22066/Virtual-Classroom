import java.time.LocalTime;
import java.util.*;
public class Instructor extends Person
{//instructor can track progress of a particular student in his course
	
	Course[] courses;
	int numCourses;
	
	public Instructor(String username,String password,Course... courses) 
	{
		super(username,password);
		this.courses=courses;
		this.numCourses=0;
	}
	
	public boolean addCourse(Course c)
	{
		if(!c.taken)
		{ 
			for(Course c1:courses)
			{
				if(c1.getSchedule().equals(c.getSchedule()))
				{
					return false;
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
								return false;
							}
						}
					}
				}
			}
			c.taken=true;
			this.courses[this.numCourses++]=c;
			return true;
		}
		return false;
	}
	
	public void removeCourse(Course c)
	{
		int i,flag=0;
		for(i=0;i<this.numCourses;i++)
		{
			if(courses[i]==c)
			{
				flag=1;
				break;
			}
		}
		if(flag==1)
		{
			int j,ptr=0;
			Course []temp=new Course[numCourses];
			for(j=0;j<this.numCourses;j++,i++)
			{
				if(j!=i)
				{
					temp[ptr]=courses[j];
					ptr++;
				}
			}
			courses=temp;
			c.taken=false;
		}
	}
	//override
	private void setMarks(Student s,Course c,Assignment a,int m)
	{
		Course.KeyPair pair=c.new KeyPair(s.getUsername(),a.getID());
		Boolean status = null;
		for (Map.Entry<Course.KeyPair, Boolean> entry : c.getMap().entrySet()) 
		{
            Course.KeyPair key = entry.getKey(); // Get the key
            Boolean value = entry.getValue(); // Get the value
            if(key.getStudent().equals(s.getUsername())&&(key.getAssignment().equals(a.getID())))
            {
            	status=true;
            }
        }
		
		if(status!=null)
		{
			if(status==false)
			{
				return;
			}
		}
		if(status==null)
		{
			return;
		}
		
		for(Course c1:s.courses)
		{
			if(c1.equals(c))
			{
				for(Assignment a1:c1.assignments)
				{
					if(a1.equals(a))
					{
						if(m<=a1.getMaxMarks())
						{
							a1.setMarks(s,m);
						}
						else
						{
							return;
						}
					}
				}
			}
		}
	}
	private void trackProgress(Student s,Course c)
	{
		for(Course c1:s.courses)
		{
			if(c1.equals(c))
			{
				for(Assignment a:c1.assignments)
				System.out.println(a.getMarks(s)+" "+a.getMaxMarks());
			}
		}
	}
	private void setDeadline(Course c,Assignment a,Deadline d)
	{
		for(Assignment a1:c.assignments)
		{
			if(a1.equals(a))
			{
				a.setFinish(d);
			}
		}
		
	}
	public static void main(String[] args)
	{
		MyRunnable1 myRunnable1 = new MyRunnable1();
        MyRunnable2 myRunnable2 = new MyRunnable2();

        Thread thread1 = new Thread(myRunnable1, "Thread 1");
        Thread thread2 = new Thread(myRunnable2, "Thread 2");

        thread1.start();
        thread2.start();

	
	}
	static class MyRunnable1 implements Runnable 
	{
        @Override
        public void run() 
        {
        	System.out.print("thread1: ");
    		Student s=new Student("Mihir","asfsdgksg@A",25);
    		Course c=new Course(12,3,100,"MoTuTh5");
    		s.addCourse(c);
    		Instructor i=new Instructor("a","asfsdgksg@A",c);
    		Deadline d1=new Deadline();
    		
    		d1.setEndTime(LocalTime.of(16, 30, 0));
    		d1.setStartTime(LocalTime.of(14, 30, 0));
    		Assignment a=new Assignment("#1",50,d1);
    		
    		i.courses[0].addAssignment(a);
    		i.setDeadline(c, a, d1);
    		
    		s.submitAssign(c, a, LocalTime.of(15, 30, 0));
    		i.setMarks(s, c, a, 20);
    		i.trackProgress(s, c);
        }
    }

    static class MyRunnable2 implements Runnable 
    {
        @Override
        public void run() 
        {
        	System.out.print("thread2: ");
        	Course c1=new Course(12,3,100,"MoTuTh5");
        	Course c2=new Course(12,3,100,"TuWeTh5");
        	Instructor i=new Instructor("a","asfsdgksg@A",c1);
        	System.out.println(i.addCourse(c2));
        }
    }
}
