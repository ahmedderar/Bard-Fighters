package adirar.hope.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hp on 10/10/2017.
 */
public class Category implements ModelInterface {
    private String name;
    private ArrayList<items> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<items> getItems() {
        return items;
    }

    public void setItems(ArrayList<items> items) {
        this.items = items;
    }

    @Override
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("items", items);
        return result;
    }
}
