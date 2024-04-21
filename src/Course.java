import java.util.*;
public class Course 
{
	 int id;
	 int current_capacity;
	 boolean taken;
	 int credits;
	 int maxCapacity;
	 ArrayList<Assignment>assignments;
	 private String schedule;//MWF3
	 private HashMap<KeyPair,Boolean>assignStatus=new HashMap<>();
	 
	 public Course(int id,int credits,int maxCapacity,String time)
	 {
		 this.id=id;
		 this.current_capacity=0;
		 this.maxCapacity=maxCapacity;
		 this.taken=false;
		 this.assignments=new ArrayList<Assignment>();
		 this.schedule=time;
	 }
	 
	 void addAssignment(Assignment... a)
	 {
		 for(Assignment temp:a)
		 {
			 if(temp!=null)
			 {
				 assignments.add(temp);
			 }
		 }
	 }
	 
	 void addAssignment(Assignment a)
	 {
		 if(a!=null)
		 assignments.add(a);
	 }
	 
	 public void setMaxCapacity(int maxCapacity) 
	 {
	     this.maxCapacity=maxCapacity;
	 }

	 public void setMaxCapacity(int maxCapacity,boolean adjustCurrentCapacity)
	 {
		 if(adjustCurrentCapacity)
		 {
			 if(maxCapacity<current_capacity)
			 {
				 current_capacity=maxCapacity;
			 }
			 this.maxCapacity=maxCapacity;
		 }    
	  }
	 
	 public String getSchedule()
	 {
		 return this.schedule;
	 }
	 public HashMap<KeyPair,Boolean>getMap()
	 {
		 return this.assignStatus;
	 }
	 
	 class KeyPair 
	 {
		    private String student;
		    private String assignment;

		    public KeyPair(String student, String assignment) 
		    {
		        this.student=student;
		        this.assignment=assignment;
		    }

		    public String getStudent() 
		    {
		        return student;
		    }

		    public String getAssignment() 
		    {
		        return assignment;
		    }
	 
	 }
}
