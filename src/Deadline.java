import java.time.LocalTime;

public class Deadline implements TimeSlot
{
	private LocalTime startTime;
	private LocalTime endTime;

	@Override
	public LocalTime getStartTime() 
	{
		return startTime;
	}

	@Override
	public LocalTime getEndTime() 
	{
		return endTime;
	}

	@Override
	public void setStartTime(LocalTime startTime) 
	{
		this.startTime=startTime;
	}

	@Override
	public void setEndTime(LocalTime endTime) 
	{
		this.endTime=endTime;
	}

}
