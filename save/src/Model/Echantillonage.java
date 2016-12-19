package Model;

import Model.Complexe;
import Model.Nombre;

/**
 * Created by maxim on 07/12/2016.
 */

public class Echantillonage {
    protected Complexe matrice[][];
    protected int echantillonage;
    protected int nbPoints ;
    protected int nbFenetre;
    protected Complexe tabPts[];
    protected Nombre nb;

    public Echantillonage (int echantillonage,int nbPoints,Complexe tabPts[]){
        this.echantillonage=echantillonage;
        this.nbPoints=nbPoints;
        this.tabPts=tabPts;
        this.nb=new Nombre(2);
        this.matrice=new Complexe[nbPoints+echantillonage][echantillonage+1];
        this.nbFenetre=0;




    }
    public void rempliTab0(){
        int i,compt;
        Complexe temp;
        temp=new Complexe(0,0);
        for(int k=this.nbPoints+1;k>0;k--){

            tabPts[k]=tabPts[k-1];


        }
        tabPts[0]= new Complexe(0,0);
        this.nbPoints=this.nbPoints+1;

       /* if((nbPoints%this.echantillonage)==0){
            this.nbFenetre=(this.nbPoints)/(this.echantillonage);
            System.out.println("this.nbfenetre"+this.nbFenetre);
        }
        else{
            this.nbFenetre=(this.nbPoints)/(this.echantillonage)+1;
        }
        if((this.nbPoints+(this.nbFenetre)-1)%echantillonage!=0) {

            nbFenetre++;
        }
        compt=1;*/
       /* while(this.nbPoints%this.echantillonage!=0){

            this.tabPts[compt+this.nbPoints]= new Complexe(0,0);
            this.nbPoints++;
            compt++;

        }*/
        System.out.println("this.nbpoitns"+this.nbPoints);

    }
    public void calculColonneAj(){
        int i,j,compt,compt2,compt3;
        Complexe temp[]=new Complexe[this.echantillonage];
        Complexe temp2;
        //System.out.println("nbPoints="+this.nbPoints);
        compt2=0;
        compt3=0;
        for(i=0;i<this.nbPoints;i=(i+this.echantillonage)-1){
            compt=0;
            //System.out.println("i="+i);
            for(j=(i);j<i+(this.echantillonage);j++){
                if(tabPts[j]==null){
                    tabPts[j]=new Complexe(0,0);
                    //this.nbPoints++;
                    compt3++;
                }
                temp[compt]=tabPts[j];
                System.out.println("j="+j);
                System.out.println("compt="+compt);

                System.out.println(temp[compt]);
                compt++;
            }



            this.matrice[compt2]=nb.calculFourierRapide(temp);
            compt2++;
            this.nbFenetre++;


        }
        for(i=0;i<compt3;i++){
            this.nbPoints++;
        }
    }
    public void selectioneAj(){
        for(int i=0;i<this.nbPoints/this.echantillonage;i++){
            for(int j=0;j<(this.echantillonage)/2;j++){
                this.matrice[i][j]=this.matrice[i][this.echantillonage-1-j];
                this.matrice[i][this.echantillonage-1-j]=null;
            }
        }

        //this.echantillonage=(this.echantillonage)/2;
    }
    public void moduleAj(){
        for(int i=0;i<this.nbFenetre;i++){
            for(int j=0;j<(this.echantillonage)/2;j++){
                this.matrice[i][j]=(this.matrice[i][j]).abs();
            }
        }
    }


    public Complexe[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(Complexe[][] matrice) {
        this.matrice = matrice;
    }

    public int getEchantillonage() {
        return echantillonage;
    }

    public void setEchantillonage(int echantillonage) {
        this.echantillonage = echantillonage;
    }

    public int getNbPoints() {
        return nbPoints;
    }

    public void setNbPoints(int nbPoints) {
        this.nbPoints = nbPoints;
    }

    public int getNbFenetre() {
        return nbFenetre;
    }

    public void setNbFenetre(int nbFenetre) {
        this.nbFenetre = nbFenetre;
    }

    public Complexe[] getTabPts() {
        return tabPts;
    }

    public void setTabPts(Complexe[] tabPts) {
        this.tabPts = tabPts;
    }

    public Nombre getNb() {
        return nb;
    }

    public void setNb(Nombre nb) {
        this.nb = nb;
    }
}
