import java.time.*;
public interface TimeSlot
{
    LocalTime getStartTime();
    LocalTime getEndTime();
    void setStartTime(LocalTime startTime);
    void setEndTime(LocalTime endTime);
    
}
