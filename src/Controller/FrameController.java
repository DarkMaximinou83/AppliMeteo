package Controller;

import Main.Main;

import View.Frame;
import org.apache.log4j.pattern.IntegerPatternConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by axel on 07/12/2016.
 */
public class FrameController {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public Frame frame = null;

    //private Complexe tab[] = null;
    private double increment ;

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



    public void notifyNombreChanged(Integer nbValeur, Integer nbEchantillonage, int bo ) {

        //System.out.println(nbValeur + " " + nbEchantillonage);

    }
}
