package adirar.hope.model;

import java.util.HashMap;
import java.util.Map;

public class Data implements ModelInterface {
    String name, desc, date;

    public Data() {
    }

    public Data(String name, String desc, String date) {
        this.name = name;
        this.desc = desc;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("desc", desc);
        result.put("date", date);
        return result;
    }
}
