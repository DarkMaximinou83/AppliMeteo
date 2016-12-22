package sample;

/**
 * Created by maxim on 20/12/2016.
 */
public class Infometeo {
    protected String temperature;
    protected String pluie;
    protected String pluie_convective;
    protected String risque_neige;
    protected String nebulosite;
    protected String date;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPluie() {
        return pluie;
    }

    public void setPluie(String pluie) {
        this.pluie = pluie;
    }

    public String getPluie_convective() {
        return pluie_convective;
    }

    public void setPluie_convective(String pluie_convective) {
        this.pluie_convective = pluie_convective;
    }

    public String getRisque_neige() {
        return risque_neige;
    }

    public void setRisque_neige(String risque_neige) {
        this.risque_neige = risque_neige;
    }

    public String getNebulosite() {
        return nebulosite;
    }

    public void setNebulosite(String nebulosite) {
        this.nebulosite = nebulosite;
    }
}
