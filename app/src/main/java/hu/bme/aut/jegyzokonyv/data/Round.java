package hu.bme.aut.jegyzokonyv.data;

import com.google.gson.annotations.SerializedName;

public class Round {

    @SerializedName("name")
    public String name;
    @SerializedName("date")
    public String date;

    public Round(String name, String date) {
        this.name = name;
        this.date = date;
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
}
