package adirar.hope.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import adirar.hope.util.Keys;

public class MyDataModel implements ModelInterface{

    private String name;
    private String date;
    private String phoneNo;
    private String areaZone;
    private String address;
    private String nearestBranch;
    private String type;
    private String shelterStatus;

    //Responders for Report UserName
    private ArrayList<String> responders;

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setAreaZone(String areaZone) {
        this.areaZone = areaZone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNearestBranch(String nearestBranch) {
        this.nearestBranch = nearestBranch;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setShelterStatus(String shelterStatus) {
        this.shelterStatus = shelterStatus;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getAreaZone() {
        return areaZone;
    }

    public String getAddress() {
        return address;
    }

    public String getNearestBranch() {
        return nearestBranch;
    }

    public String getType() {
        return type;
    }

    public String getShelterStatus() {
        return shelterStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void addResponder(String responder){
        responders.add(responder);
    }
    public ArrayList<String> getResponders(){
        return responders;
    }


    @Override
    public Map<String, Object> toMap() {

        String temp = "";

        HashMap<String, Object> result = new HashMap<>();
        result.put(Keys.KEY_NAME,name);
        result.put(Keys.KEY_DATE,date);
        result.put(Keys.KEY_ADDRESS, address);
        result.put(Keys.KEY_PHONE,phoneNo);
        result.put(Keys.KEY_AREZONE,areaZone);
        result.put(Keys.KEY_NEARESTBRANCH,nearestBranch);
        result.put(Keys.KEY_TYPE,type);
        result.put(Keys.KEY_SHELTER_STATUS,shelterStatus);
        if (responders.size() >= 1){
            for (String responder:responders){
                temp += responder + ",";
            }
            temp = temp.substring(0,(temp.length()-1));
            result.put(Keys.KEY_RESPONDERS,temp);
        }

        return result;
    }
}
