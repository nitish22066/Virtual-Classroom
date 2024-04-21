import java.util.HashMap;

public class Assignment 
{
    private int maxMarks;
    private HashMap<Student,Integer> marksMap; // HashMap to store marks scored by each student
    private String id;
    private Deadline deadline;

    public Assignment(String id, int maxMarks,Deadline d) 
    {
        this.id = id;
        this.maxMarks = maxMarks;
        this.marksMap = new HashMap<>();
        this.deadline=d;
    }
    public Assignment(String id, int maxMarks) 
    {
        this.id = id;
        this.maxMarks = maxMarks;
        this.marksMap = new HashMap<>();
        this.deadline=null;
    }

    public int getMaxMarks() 
    {
        return this.maxMarks;
    }

    // Method to set marks scored by a student
    public void setMarks(Student student, int marks) 
    {
        if(marks<=maxMarks) 
        {
            marksMap.put(student, marks);
        }
    }

    // Method to get marks scored by a student
    public int getMarks(Student student) 
    {
        return marksMap.getOrDefault(student,0);
    }

    public String getID() 
    {
        return this.id;
    }
    
    public void setFinish(Deadline d)
    {
    	this.deadline=d;
    }
    public Deadline getDeadline() 
    {
        return this.deadline;
    }
}

