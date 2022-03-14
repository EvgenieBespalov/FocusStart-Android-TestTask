package models;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class MainData {
    @SerializedName("Date")
    private String date;
    @SerializedName("PreviousDate")
    private String previousDate;
    @SerializedName("PreviousURL")
    private String previousURL;
    @SerializedName("Timestamp")
    private String timeStamp;
    @SerializedName("Valute")
    public Map<String, Valute> valutes;

    MainData(){}
    MainData(String date, String previousDate, String previousURL, String timeStamp, Map<String, Valute> valutes)
    {
        this.date = date;
        this.previousDate = previousDate;
        this.previousURL = previousURL;
        this.timeStamp = timeStamp;
        this.valutes = valutes;
    }

    //getters
    public String getDate(){ return this.date;}
    public String getPreviousDate(){ return this.previousDate;}
    public String getPreviousURL(){ return this.previousURL;}
    public String getTimestamp(){ return this.timeStamp;}

    //setters
    public void setDate(String date){ this.date =date; }
    public void setPreviousDate(String previousDate){ this.previousDate =previousDate;}
    public void setPreviousURL(String previousURL){ this.previousURL = previousURL;}
    public void setTimestamp(String timeStamp){ this.timeStamp =timeStamp;}

    @Override
    public String toString()
    {
        return "Date: " + this.date
                + "\npreviousDate: " + this.previousDate
                + "\npreviousURL: " + this.previousURL
                + "\ntimeStamp: " + this.timeStamp
                + "\nValute: \n" + valutes;
    }
}