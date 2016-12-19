package Model;

import java.lang.Object;
//import java.util.Objects;
import java.lang.*;
import java.util.Observable;


/**
 * Created by maxim on 05/12/2016.
 */
public class Complexe extends Observable{
    private final double re;   // La partie réel
    private final double im;   // La partie imaginaire

    //Le constructeur
    public Complexe(double real, double imag) {
        this.re = real;
        this.im = imag;

    }

    //Afficher le nombre complexe
    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im <  0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }

    //On fait le module du nombre complexe
    public Complexe abs() {
        double temp;
        temp=(re*re)+(im*im);
        temp=Math.sqrt(temp);
        //System.out.println(temp);
        return(new Complexe(temp,0));
    }

    // retourne la phase
    public double phase() {
        return Math.atan2(im, re);
    }

    // Additione deux complexes
    public Complexe plus(Complexe b) {
        Complexe a = this;             // invoking object
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complexe(real, imag);
    }

    // Soustrait deux complexes
    public Complexe minus(Complexe b) {
        Complexe a = this;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Complexe(real, imag);
    }

    //Multiplie deux complexes
    public Complexe times(Complexe b) {
        Complexe a = this;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new Complexe(real, imag);
    }

    //Multiplie un complexe par un coefficient
    public Complexe scale(double alpha) {
        return new Complexe(alpha * re, alpha * im);
    }

    //Calcule le conjugué d'un complexe
    public Complexe conjugate() {
        return new Complexe(re, -im);
    }

    // Calcul la reciproque d'un objet
    public Complexe reciprocal() {
        double scale = re*re + im*im;
        return new Complexe(re / scale, -im / scale);
    }

    // retourne soit la aprtie réel ou soit la partie imaginaire d'un complexe
    public double re() { return re; }
    public double im() { return im; }

    // divise dun complexe avec un autre
    public Complexe divides(Complexe b) {
        Complexe a = this;
        return a.times(b.reciprocal());
    }

    // retourne l'exponentiel d'un nombre complexe
    public Complexe exp() {
        return new Complexe(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
    }

    // retourne le sinus d'un nombre complexe
    public Complexe sin() {
        return new Complexe(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
    }

    // retourne le cosinus d'un nombre complexe
    public Complexe cos() {
        return new Complexe(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
    }

    // retourne la tangente d'un nombre complexe
    public Complexe tan() {
        return sin().divides(cos());
    }



    // Additioner deux complexes passé en parametre
    public Complexe plus(Complexe a, Complexe b) {
        double real = a.re + b.re;
        double imag = a.im + b.im;
        Complexe sum = new Complexe(real, imag);
        return sum;
    }

    // test si deux complexes sont égaux 
    /*public boolean equals(Object x) {
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Complexe that = (Complexe) x;
        return (this.re == that.re) && (this.im == that.im);
    }

    // See Section 3.3.
    /*public int hashCode() {
        return Object.hash(re, im);
    }*/
}
