package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;


public class Controller {

    protected ListIterator<Day> iter ;
    protected Day day;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Label name;

    @FXML
    private Label temp;
    @FXML
    private ImageView symbolAprem;


    @FXML
    private Label jour= new Label();

    @FXML
    private Label tempMatin;
    protected String resultat;
    @FXML
    private Label temperatureAprem;

    @FXML
    private Label temperatureMatin;
    @FXML
    private ImageView symbolMatin;

    public Controller(){


    }

    @FXML
    private void rechercher() {


        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Rechercher");
        dialog.setHeaderText("Rechercher une ville");
        dialog.setContentText("Entrer le nom de la ville");


        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            this.resultat =result.get();

        }
        System.out.println(this.resultat);
        HttpURLConnection connexion = null;

        URL monURL = null;
        String url;
        try {



                monURL = new URL("http://api.openweathermap.org/data/2.5/forecast?q="+this.resultat+"%2Cfr&APPID=0bd2ccefc77a0e59f11b2d8215a1fc76&mode=xml");



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
       this.iter = pp.tabDay.listIterator();
        day=iter.next();

        jour.setText(day.getDate());
        name.setText(day.getCity());
        temperatureMatin.setText(day.getTempMatin());
        temperatureAprem.setText(day.getTempAprem());
        String urlimgmatin=null;

        if(day.getNuageMatin().equals("clear sky")){
            urlimgmatin="soleil.png";

        }
        else if((day.getNuageMatin().equals("few clouds"))||(day.getNuageMatin().equals("broken clouds"))){
            urlimgmatin="nuage.png";

        }
        else if((day.getNuageMatin().equals("scattered clouds"))||(day.getNuageMatin().equals("overcast clouds"))){
            urlimgmatin="nuageux.png";

        }
        else if((day.getNuageMatin().equals("rain"))||(day.getNuageMatin().equals("light rain"))){
            urlimgmatin="pluie.png";
        }
        else if((day.getNuageMatin().equals("snow"))||(day.getNuageMatin().equals("light snow"))){
            urlimgmatin="neige.png";
        }
        else{
            urlimgmatin="eclair.png";
        }

        Image imageMatin = new Image(urlimgmatin);
        symbolMatin.setImage(imageMatin);
        String urlimgAprem=null;

        if(day.getNuageAprem().equals("clear sky")){
            urlimgAprem="soleil.png";

        }
        else if((day.getNuageAprem().equals("few clouds"))||(day.getNuageAprem().equals("broken clouds"))){
            urlimgAprem="nuage.png";

        }
        else if((day.getNuageAprem().equals("scattered clouds"))||(day.getNuageAprem().equals("overcast clouds"))){
            urlimgAprem="nuageux.png";

        }
        else if((day.getNuageAprem().equals("rain"))||(day.getNuageAprem().equals("light rain"))){
            urlimgAprem="pluie.png";
        }
        else if((day.getNuageAprem().equals("snow"))||(day.getNuageAprem().equals("light snow"))){
            urlimgAprem="neige.png";
        }
        else{
            urlimgAprem="eclair.png";
        }

        Image imageAprem = new Image(urlimgAprem);
        symbolAprem.setImage(imageAprem);


    }
    @FXML
    void changeLabel(MouseEvent event) {
        System.out.println("text");
        jour.setText("lol");


    }
    @FXML
    void suivant(ActionEvent event) {

        if(iter.hasNext()){
            day=iter.next();

            jour.setText(day.getDate());
            temperatureMatin.setText(day.getTempMatin());
            temperatureAprem.setText(day.getTempAprem());
            String urlimgmatin=null;

            if(day.getNuageMatin().equals("clear sky")){
                urlimgmatin="soleil.png";

            }
            else if((day.getNuageMatin().equals("few clouds"))||(day.getNuageMatin().equals("broken clouds"))){
                urlimgmatin="nuage.png";

            }
            else if((day.getNuageMatin().equals("scattered clouds"))||(day.getNuageMatin().equals("overcast clouds"))){
                urlimgmatin="nuageux.png";

            }
            else if((day.getNuageMatin().equals("rain"))||(day.getNuageMatin().equals("light rain"))){
                urlimgmatin="pluie.png";
            }
            else if((day.getNuageMatin().equals("snow"))||(day.getNuageMatin().equals("light snow"))){
                urlimgmatin="neige.png";
            }
            else{
                urlimgmatin="eclair.png";
            }

            Image imageMatin = new Image(urlimgmatin);
            symbolMatin.setImage(imageMatin);
            String urlimgAprem=null;

            if(day.getNuageAprem().equals("clear sky")){
                urlimgAprem="soleil.png";

            }
            else if((day.getNuageAprem().equals("few clouds"))||(day.getNuageAprem().equals("broken clouds"))){
                urlimgAprem="nuage.png";

            }
            else if((day.getNuageAprem().equals("scattered clouds"))||(day.getNuageAprem().equals("overcast clouds"))){
                urlimgAprem="nuageux.png";

            }
            else if((day.getNuageAprem().equals("rain"))||(day.getNuageAprem().equals("light rain"))){
                urlimgAprem="pluie.png";
            }
            else if((day.getNuageAprem().equals("snow"))||(day.getNuageAprem().equals("light snow"))){
                urlimgAprem="neige.png";
            }
            else{
                urlimgAprem="eclair.png";
            }

            Image imageAprem = new Image(urlimgAprem);
            symbolAprem.setImage(imageAprem);
        }

    }
    @FXML
    void precedent(ActionEvent event) {

        if(iter.hasPrevious()){
            day=iter.previous();


            jour.setText(day.getDate());
            temperatureMatin.setText(day.getTempMatin());
            temperatureAprem.setText(day.getTempAprem());
            String urlimgmatin=null;

            if(day.getNuageMatin().equals("clear sky")){
                urlimgmatin="soleil.png";

            }
            else if((day.getNuageMatin().equals("few clouds"))||(day.getNuageMatin().equals("broken clouds"))){
                urlimgmatin="nuage.png";

            }
            else if((day.getNuageMatin().equals("scattered clouds"))||(day.getNuageMatin().equals("overcast clouds"))){
                urlimgmatin="nuageux.png";

            }
            else if((day.getNuageMatin().equals("rain"))||(day.getNuageMatin().equals("light rain"))){
                urlimgmatin="pluie.png";
            }
            else if((day.getNuageMatin().equals("snow"))||(day.getNuageMatin().equals("light snow"))){
                urlimgmatin="neige.png";
            }
            else{
                urlimgmatin="eclair.png";
            }

            Image imageMatin = new Image(urlimgmatin);
            symbolMatin.setImage(imageMatin);
            String urlimgAprem=null;

            if(day.getNuageAprem().equals("clear sky")){
                urlimgAprem="soleil.png";

            }
            else if((day.getNuageAprem().equals("few clouds"))||(day.getNuageAprem().equals("broken clouds"))){
                urlimgAprem="nuage.png";

            }
            else if((day.getNuageAprem().equals("scattered clouds"))||(day.getNuageAprem().equals("overcast clouds"))){
                urlimgAprem="nuageux.png";

            }
            else if((day.getNuageAprem().equals("rain"))||(day.getNuageAprem().equals("light rain"))){
                urlimgAprem="pluie.png";
            }
            else if((day.getNuageAprem().equals("snow"))||(day.getNuageAprem().equals("light snow"))){
                urlimgAprem="neige.png";
            }
            else{
                urlimgAprem="eclair.png";
            }

            Image imageAprem = new Image(urlimgAprem);
            symbolAprem.setImage(imageAprem);
        }

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
