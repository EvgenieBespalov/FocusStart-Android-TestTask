package models;


import com.google.gson.annotations.SerializedName;

public class Valute {
    @SerializedName("ID")
    public String id;
    @SerializedName("NumCode")
    private String numCode;     //Цифровой код
    @SerializedName("CharCode")
    private String charCode;    //Буквенный код
    @SerializedName("Nominal")
    private Integer nominal;    //Номинал
    @SerializedName("Name")
    private String name;        //Валюта
    @SerializedName("Value")
    private Float value;        //Текущий курс
    @SerializedName("Previous")
    private Float previous;     //Предыдущий курс

    Valute(){}
    Valute(String id, String numCode, String charCode, Integer nominal, String name, Float value, Float previous)
    {
        this.id = id;
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
        this.previous = previous;
    }


    //getters
    public String getIG(){ return this.id;}
    public String getNumCode(){ return this.numCode;}
    public String getCharCode(){ return this.charCode;}
    public Integer getNominal(){ return this.nominal;}
    public String getName(){ return this.name;}
    public Float getValue(){ return this.value;}
    public Float getPrevious(){ return this.previous;}

    //setters
    public void setIG(String ID){ this.id =ID; }
    public void setNumCode(String numCode){ this.numCode=numCode;}
    public void setCharCode(String charCode){ this.charCode=charCode;}
    public void setNominal(Integer nominal){ this.nominal=nominal;}
    public void setName(String name){ this.name=name;}
    public void setValue(Float value){ this.value=value;}
    public void setPrevious(Float previous){ this.previous=previous;}

    @Override
    public String toString()
    {
        return "\n  ID: " + id
                + "\n   numCode: " + numCode
                + "\n   charCode: " + charCode
                + "\n   nominal: " + nominal
                + "\n   name: " + name
                + "\n   value: " + value
                + "\n   previous: " + previous;
    }
}