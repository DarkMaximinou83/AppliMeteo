package sample;

/**
 * Created by maxim on 22/12/2016.
 */
public class Ville {
    protected String nom;
    protected String X;
    protected String Y;
    public Ville(String X,String Y,String nom){
        this.X=X;
        this.Y=Y;
        this.nom=nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getX() {
        return X;
    }

    public void setX(String x) {
        X = x;
    }

    public String getY() {
        return Y;
    }

    public void setY(String y) {
        Y = y;
    }
}
