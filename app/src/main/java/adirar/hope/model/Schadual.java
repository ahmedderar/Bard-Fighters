package adirar.hope.model;

/**
 * Created by ahmed on 09/11/17.
 */

public class Schadual {
   private String day;
   private String startTime;
   private String endTime;
   private boolean allDay = false ;
   private boolean allWeek = false;
   private String startDate;
   private String endDate;


    public void setDay(String day) {
        this.day = day;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    public void setAllWeek(boolean allWeek) {
        this.allWeek = allWeek;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDay() {
        return day;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public boolean isAllDay() {
        return allDay;
    }

    public boolean isAllWeek() {
        return allWeek;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
