
package Main;

import Controller.FrameController;

import View.Frame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;


/**
 * Created by axel on 05/12/2016.
 */


public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);


    public static void main (String args[]){

        /*
        Initialisation de la frame, de la musique et du controller
         */

        FrameController controller = new FrameController();

        LOGGER.info("compt=");

        Frame frame = new Frame(controller);
        controller.init(frame);
        frame.display();

    }
}