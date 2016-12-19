
package Main;

import Controller.FrameController;
import Model.Complexe;
import Model.MusicThread;
import Model.Nombre;
import Model.Echantillonage;
import Model.ReadFiles;
import View.Frame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;


/**
 * Created by axel on 05/12/2016.
 */


public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);


    public Main() {

    }



    public static void main (String args[]){

        int  compt=0;
        int taille;
        double il;
        double increment ;
        increment=3.14/4;
        Complexe[] tab = {new Complexe(1, 0), new Complexe(1, 0), new Complexe(1, 0), new Complexe(1, 0)};
        Complexe[] result;
        Complexe[] tab2 = new Complexe[1000];
        il=-(3.14/2);
        while(il<3.14/2){

            tab2[compt] = new Complexe(Math.sin(il), 0);
            il=il+increment;
            compt++;
        }
        Complexe[] tab3=new Complexe[1000];
        for(int i=0;i<4;i++){
            tab3[i]= new Complexe(i,0);
        }
      /*  Echantillonage ech=new Echantillonage(4,16,tab2);
        ech.rempliTab0();
        ech.calculColonneAj();
        for(int j=0;j<(ech.getNbPoints()/ech.getEchantillonage()); j++) {
            for (int i = 0; i < ech.getEchantillonage(); i++) {
                LOGGER.info(ech.getMatrice()[j][i].toString());
            }
        }
        ech.selectioneAj();
        LOGGER.info("vibouille est un enfant");
        LOGGER.info("vibouille est un enfant");
        LOGGER.info("vibouille est un enfant");
        for(int j=0;j<(ech.getNbPoints()/ech.getEchantillonage());j++) {
            for (int i = 0; i < (ech.getEchantillonage())/2; i++) {
                LOGGER.info(ech.getMatrice()[j][i].toString());
            }
        }
        ech.moduleAj();
        LOGGER.info("vibouille est un enfant");
        LOGGER.info("vibouille est un enfant");
        LOGGER.info("vibouille est un enfant");
        for(int j=0;j<(ech.getNbPoints()/ech.getEchantillonage());j++) {
            for (int i = 0; i < (ech.getEchantillonage())/2; i++) {
                LOGGER.info(ech.getMatrice()[j][i].toString());
            }
        }*/



/*
        Nombre re = new Nombre(2);
       result = re.calculFourierRapide(tab);
        LOGGER.info("tab fichier texte");
        Complexe[] tab3 = new Complexe[1000];
        ReadFiles read=new ReadFiles();
        taille=read.main(tab3);
        Echantillonage ech2=new Echantillonage(4,taille,tab2);
        ech2.rempliTab0();
        ech2.calculColonneAj();
        for(int j=0;j<(ech2.getNbPoints()/ech2.getEchantillonage()); j++) {
            for (int i = 0; i < ech2.getEchantillonage(); i++) {
                LOGGER.info(ech2.getMatrice()[j][i].toString());
            }
        }
        ech2.selectioneAj();
        LOGGER.info("vibouille est un enfant");
        LOGGER.info("vibouille est un enfant");
        LOGGER.info("vibouille est un enfant");
        for(int j=0;j<(ech2.getNbPoints()/ech2.getEchantillonage());j++) {
            for (int i = 0; i < (ech2.getEchantillonage())/2; i++) {
                LOGGER.info(ech2.getMatrice()[j][i].toString());
            }
        }
        ech2.moduleAj();
        LOGGER.info("vibouille est un enfant");
        LOGGER.info("vibouille est un enfant");
        LOGGER.info("vibouille est un enfant");
        for(int j=0;j<(ech2.getNbPoints()/ech2.getEchantillonage());j++) {
            for (int i = 0; i < (ech2.getEchantillonage())/2; i++) {
                LOGGER.info(ech2.getMatrice()[j][i].toString());
            }
        }
        int length = result.length;

       for (int i = 0; i < length; i++){
            LOGGER.info(result[i].toString());
        }*/

        Echantillonage ech1 = null;
        FrameController controller = new FrameController();
        Thread music = new Thread(new MusicThread());
       music.start();

        Frame frame = new Frame(controller);
        controller.init(frame);
        frame.display();

    }
}