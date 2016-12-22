package sample;

/**
 * Created by maxim on 20/12/2016.
 */
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class meteoParser implements ContentHandler {
    private int afficheValeur;
    private String tag=null;

    public Infometeo info=null;


    public meteoParser(){
        this.info=new Infometeo();


    }

    @Override
    public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
        // TODO Auto-generated method stub
        String donnees = new String(arg0 ,arg1,arg2);
       // System.out.println( donnees );
        if(tag.equals("temp")){
            //this.info.setIpAdress(donnees);
            float value = Float.parseFloat(donnees);
            value = value - 273;

            System.out.println( value+"°" );
        }
        if(tag.equals("pluie")){

            System.out.println( donnees );
        }
        if(tag.equals("pluie_convective")){

            System.out.println( donnees );
        }
        if(tag.equals("risque_neige")){

            System.out.println( donnees );
        }
        if(tag.equals("nebulosite")){

            System.out.println( donnees );
        }



    }

    @Override
    public void endDocument() throws SAXException {
        // TODO Auto-generated method stub
        System.out.println("Fin du document");
    }

    @Override
    public void endElement(String arg0, String arg1, String arg2) throws SAXException {
        // TODO Auto-generated method stub
       // System.out.println("Fin tag " + arg0+arg1+arg2);
    }

    @Override
    public void endPrefixMapping(String arg0) throws SAXException {
        // TODO Auto-generated method stub
        //System.out.println("lool" +arg0);
    }

    @Override
    public void ignorableWhitespace(char[] arg0, int arg1, int arg2) throws SAXException {
        // TODO Auto-generated method stub
        //System.out.println("lool" +arg0);
    }

    @Override
    public void processingInstruction(String arg0, String arg1) throws SAXException {
        // TODO Auto-generated method stub
        //System.out.println("lool" +arg0+arg1);
    }

    @Override
    public void setDocumentLocator(Locator arg0) {
        // TODO Auto-generated method stub
        //System.out.println("lool" +arg0);
    }

    @Override
    public void skippedEntity(String arg0) throws SAXException {
        // TODO Auto-generated method stub
        //System.out.println("lool" +arg0);

    }

    @Override
    public void startDocument() throws SAXException {
        // TODO Auto-generated method stub
        System.out.println("Debut du document");
    }

    @Override
    public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {
        // TODO Auto-generated method stub
        this.tag=arg0+arg1;
        if(tag.equals("echeance")){



            System.out.println(tag + "." + arg3.getValue(1));



        }
        if(tag.equals("level")){

           if((arg3.getValue(0)).equals("sol")){
                tag="temp";

            }
           else  if((arg3.getValue(0)).equals("totale")){
                tag="nebulosite";

            }





        }


       // System.out.println( arg0 +arg1+ ":");
    }




    @Override
    public void startPrefixMapping(String arg0, String arg1) throws SAXException {
        // TODO Auto-generated method stub
        //System.out.println("lool" +arg0+arg1);

    }


}
