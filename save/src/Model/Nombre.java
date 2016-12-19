package Model;

import Model.Complexe;

import java.util.Observable;

/**
 * Created by maxim on 05/12/2016.
 */
public class  Nombre extends Observable{
    protected double taille;
    protected Complexe[] aj;

    public  Nombre(int N){

        this.taille=Math.pow(2, N);

    }
    public  Complexe[] calculFourierRapide(Complexe[] uk){

        int n = uk.length;

        // base case
        if (n == 1)
            return new Complexe[] { uk[0] };

        // On verifie que la taille de uk est bien une puissance de 2
        if (n % 2 != 0) {
            throw new RuntimeException("n is not a power of 2");
        }

        // On recupere tous les uk paire pour les mettre dans un tableau
        Complexe[] tempPaire = new Complexe[n/2];
        for (int k = 0; k < n/2; k++) {
            tempPaire[k] = uk[2*k];
        }
        Complexe[] q = calculFourierRapide(tempPaire);// On rappele la méthode calcul fourrier rapide jusqu'à que n=1

        // On recupere tous les uk impaire pour les mettre dans un tableau
        Complexe[] tempImpaire  = new Complexe[n/2];
        for (int k = 0; k < n/2; k++) {
            tempImpaire[k] = uk[2*k + 1];
        }
        Complexe[] r = calculFourierRapide(tempImpaire);// On rappele la méthode calcul fourrier rapide jusqu'à que n=1

        // On calcul la transfo de fourier rapide de Uk en traitant les deux cas j €[0;n/2-1] et j€[n/2;n-1]
        Complexe[] aj = new Complexe[n];
        for (int k = 0; k < n/2; k++) {
            double kth = -2 * k * Math.PI / n;
            Complexe wk = new Complexe(Math.cos(kth), Math.sin(kth));// On initialise Wn^j
            aj[k]       = q[k].plus(wk.times(r[k]));//On traite le cas j<n/2
            aj[k + n/2] = q[k].minus(wk.times(r[k]));// On traite le cas j>n/2
        }

        return (aj);
    }



    public  Complexe[] calculFourierRapideComplexeInverse(Complexe [] aj){

        int n = aj.length;
        Complexe[] uk = new Complexe[n];

        // On prend le conjugué de uk et on le met ds aj
        for (int i = 0; i < n; i++) {
            uk[i] = aj[i].conjugate();
        }

        // On cfait le calcul de serie de fourrier rapide de aj et on le met dans aj
        uk= calculFourierRapide(uk);

        // On refait le conjugué de aj et on le remet dans aj
        for (int i = 0; i < n; i++) {
            uk[i] = uk[i].conjugate();
        }

        // On divise par n
        for (int i = 0; i < n; i++) {
            uk[i] = uk[i].scale(1.0 / n);
        }

        return uk;

    }

    public void setTaille(double taille){
        this.taille = taille;
        setChanged();
        notifyObservers(this.taille);

    }
}
