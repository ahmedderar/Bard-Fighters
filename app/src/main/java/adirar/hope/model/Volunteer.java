package adirar.hope.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ahmed on 09/11/17.
 */

public class Volunteer extends Users{

    private String nearestBranch;
    private String vActivity;
    private String division;
    private ArrayList<Schadual> avaliableTimes;

    public Volunteer() {
        super();
    }

    public String getNearestBranch() {
        return nearestBranch;
    }

    public void setNearestBranch(String nearestBranch) {
        this.nearestBranch = nearestBranch;
    }

    public String getvActivity() {
        return vActivity;
    }

    public void setvActivity(String vActivity) {
        this.vActivity = vActivity;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public ArrayList<Schadual> getAvaliableTimes() {
        return avaliableTimes;
    }

    public void setAvaliableTimes(ArrayList<Schadual> avaliableTimes) {
        this.avaliableTimes = avaliableTimes;
    }


    @Override
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name",super.getName());
        result.put("password", super.getPassword());
        result.put("address", super.getAddress());
        result.put("email", super.getEmail());
        result.put("phone", super.getPhone());
        //Volunteer Data
        result.put("activity",vActivity);
        result.put("nearest_branch",nearestBranch);
        /**
        String string = "";
        for (Schadual s:avaliableTimes){
            string += s.getDay() + "," +s.getStartTime()+","+s.getEndTime()+",*,";
        }
        result.put("avaliable_times",string);
         **/

        return result;

    }
}
