package Controller;

import Main.Main;
import Model.Complexe;
import Model.Echantillonage;
import Model.Nombre;
import View.Frame;
import org.apache.log4j.pattern.IntegerPatternConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Model.ReadFiles;

/**
 * Created by axel on 07/12/2016.
 */
public class FrameController {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public Frame frame = null;
    private Echantillonage echantillonage = null;
    //private Complexe tab[] = null;
    private double increment ;
    private int bo;

    public FrameController(){


    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }


    public void init(Frame frame) {

        this.frame = frame;

    }

    public void displayViews() {

        frame.display();

    }

    public Echantillonage getEchantillonage() {
        return echantillonage;
    }

    public void setEchantillonage(Echantillonage echantillonage) {
        this.echantillonage = echantillonage;
    }

    public void notifyNombreChanged(Integer nbValeur, Integer nbEchantillonage,int bo ) {
        double il;
        int compt=0;
        int taille;
        increment=3.14/nbValeur;
        Complexe[] tab2 = new Complexe[1000];
        if(bo==1) {
            il = -(3.14 / 2);
            while (il < 3.14 / 2) {

                tab2[compt] = new Complexe(Math.sin(il), 0);
                il = il + increment;
                compt++;
            }
        }
        else{
            ReadFiles read=new ReadFiles();
            taille=read.main(tab2);
            System.out.println("text");
            if(nbValeur>taille){
                nbValeur=taille;
            }


        }

        echantillonage = new Echantillonage(nbEchantillonage, nbValeur, tab2);
        echantillonage.rempliTab0();
        echantillonage.calculColonneAj();



        for(int j=0;j<echantillonage.getNbFenetre(); j++) {
            for (int i = 0; i < nbEchantillonage; i++) {
                //LOGGER.info(echantillonage.getMatrice()[j][i].toString());
            }
        }
        echantillonage.selectioneAj();
        echantillonage.moduleAj();

        //System.out.println(nbValeur + " " + nbEchantillonage);

    }
}
