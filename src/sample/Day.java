package sample;

/**
 * Created by maxim on 23/12/2016.
 */
public class Day {
    protected String tempMatin;
    protected String tempAprem;
    protected  String nuageMatin;
    protected String nuageAprem;
    protected String date;
    protected String city;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTempMatin() {
        return tempMatin;
    }

    public void setTempMatin(String tempMatin) {
        this.tempMatin = tempMatin;
    }

    public String getTempAprem() {
        return tempAprem;
    }

    public void setTempAprem(String tempAprem) {
        this.tempAprem = tempAprem;
    }

    public String getNuageMatin() {
        return nuageMatin;
    }

    public void setNuageMatin(String nuageMatin) {
        this.nuageMatin = nuageMatin;
    }

    public String getNuageAprem() {
        return nuageAprem;
    }

    public void setNuageAprem(String nuageAprem) {
        this.nuageAprem = nuageAprem;
    }
}
