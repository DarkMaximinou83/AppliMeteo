package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label temp;


    @FXML
    private Label jour= new Label();

    @FXML
    private Label tempMatin;

    public Controller(){
        HttpURLConnection connexion = null;

        URL monURL = null;
        try {
            RechercheVille re= new RechercheVille();
            monURL = new URL(re.getUrl("lille"));
        } catch (MalformedURLException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        System.out.println("Connexion a l'url ...");
        try {
            connexion= (HttpURLConnection) monURL.openConnection();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        System.out.println(connexion.getRequestMethod());
        try {
            System.out.println(connexion.getResponseMessage());
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        System.out.println(connexion.getHeaderFields());
        BufferedReader in = null;
        try {
            in = new BufferedReader( new InputStreamReader(connexion.getInputStream()));
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        XMLReader xr=null;;
        try {
            xr = XMLReaderFactory.createXMLReader();
        } catch (SAXException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        meteoParser pp=new meteoParser();
        xr.setContentHandler( pp);
        try {
            xr.parse( new InputSource(in));
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (SAXException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        //System.out.println("infoip"+pp.info);


        connexion.disconnect();

    }
    


    @FXML
    void changeLabel(MouseEvent event) {
        System.out.println("text");
        jour.setText("lol");


    }

    @FXML
    void exitProgram(ActionEvent event) {
    }

    @FXML
    void initialize() {
        assert temp != null : "fx:id=\"temp\" was not injected: check your FXML file 'sample.fxml'.";
        assert tempMatin != null : "fx:id=\"tempMatin\" was not injected: check your FXML file 'sample.fxml'.";


    }

}
