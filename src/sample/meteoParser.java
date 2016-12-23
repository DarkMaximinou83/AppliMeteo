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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class meteoParser implements ContentHandler {
    private int afficheValeur;
    private String tag=null;

    public Day day=null;
    protected long heureActu=0;
    Calendar calDepart = new GregorianCalendar();
    protected ArrayList<Day> tabDay = new ArrayList<Day>();
    protected String name;
    protected int boolMatin;
    protected int boolAprem;


    public meteoParser(){

        calDepart.setTime(new Date(0));
        calDepart.set(Calendar.HOUR_OF_DAY, 23);
        calDepart.set(Calendar.MINUTE, 0);
        calDepart.set(Calendar.SECOND, 0);
        calDepart.set(Calendar.MILLISECOND, 0);
        boolMatin=0;
        boolAprem=0;


    }

    @Override
    public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
        // TODO Auto-generated method stub
        String donnees = new String(arg0 ,arg1,arg2);
       // System.out.println( donnees );
        if (tag.equals("name")) {

            name=donnees;

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
        this.tag = arg0 + arg1;
        if (tag.equals("time")) {


            //System.out.println(tag + "." + arg3.getValue(1));


            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            String dateInString = arg3.getValue(1);

            try {

                Date date = formatter.parse(dateInString);
                System.out.println(date);
                System.out.println(formatter.format(date));
                Calendar calStart = new GregorianCalendar();
                calStart.setTime(date);
                calStart.set(Calendar.HOUR_OF_DAY, 12);
                calStart.set(Calendar.MINUTE, 0);
                calStart.set(Calendar.SECOND, 0);
                calStart.set(Calendar.MILLISECOND, 0);
                System.out.println("lol" + calDepart.getTime());
                if ((date.compareTo(calDepart.getTime()) == 1)) {
                    boolAprem=0;
                    boolMatin=0;
                    System.out.println("J'ajoute un nouvel objet day à la arraylist");
                    this.day=new Day();
                    tabDay.add(day);
                    day.setCity(this.name);
                    day.setDate(date.toString());
                    System.out.println(day.getCity());
                    if (date.compareTo(calStart.getTime()) == 1) {
                        System.out.println("aprem");

                        boolAprem++;

                    } else {
                        System.out.println("matin");
                        boolMatin++;
                    }
                    calDepart.setTime(date);
                    calDepart.set(Calendar.HOUR_OF_DAY, 23);
                    calDepart.set(Calendar.MINUTE, 0);
                    calDepart.set(Calendar.SECOND, 0);
                    calDepart.set(Calendar.MILLISECOND, 0);
                } else {
                    if (date.compareTo(calStart.getTime()) == 1) {
                        System.out.println("aprem");
                        boolAprem++;
                    } else {
                        System.out.println("matin");
                        boolMatin++;
                    }

                }
               /* SimpleDateFormat parser = new SimpleDateFormat("HH:mm");


                try {

                    date = parser.parse("12:00");
                    System.out.println("heure"+date);




                } catch (ParseException e) {
                    e.printStackTrace();
                }*/


            } catch (ParseException e) {
                e.printStackTrace();
            }


        }

        if (tag.equals("temperature")) {
            System.out.println("boolMatin="+boolMatin);
            if(boolMatin==1){
                day.setTempMatin(arg3.getValue(1));
                System.out.println("temperature matin="+day.getTempMatin());
            }
            else if(boolAprem==1){
                day.setTempAprem(arg3.getValue(1));
                System.out.println("temperature aprem="+day.getTempAprem());
                if(day.getTempMatin()==null){
                    day.setTempMatin(arg3.getValue(1));
                }
            }



        }
        if (tag.equals("symbol")) {
            if(boolMatin==1){
                day.setNuageMatin(arg3.getValue(1));
                System.out.println("Oh il fait beau ou il fait pas beau ce matin?"+day.getNuageMatin());
            }
            else if(boolAprem==1){
                day.setNuageAprem(arg3.getValue(1));
                System.out.println("Oh il fait beau ou il fait pas beau cet aprem?"+day.getNuageAprem());
                if(day.getNuageMatin()==null){
                    day.setNuageMatin(arg3.getValue(1));
                }
            }




        }
    }








       // System.out.println( arg0 +arg1+ ":");






    @Override
    public void startPrefixMapping(String arg0, String arg1) throws SAXException {
        // TODO Auto-generated method stub
        //System.out.println("lool" +arg0+arg1);

    }


}
