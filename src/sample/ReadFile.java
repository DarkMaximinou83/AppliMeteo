package sample;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by maxim on 22/12/2016.
 */

public class ReadFile {
    public void main(ArrayList<Ville> tabVille){
        String chaine="";
        int compt,compt2,compt3;
        String X=null;
        String Y=null;
        String nom=null;

        String fichier ="villeCoord.txt";

        //lecture du fichier texte
        try{
            InputStream ips=new FileInputStream(fichier);
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;
            compt=0;
            while ((ligne=br.readLine())!=null){
                if(compt==0){
                    nom=ligne;
                    compt++;

                }
                else if(compt==1){
                    X=ligne;
                    compt++;
                }
                else if(compt==2){
                    Y=ligne;
                    compt=0;
                    tabVille.add(new Ville(X,Y, nom));
                }





                chaine+=ligne+"\n";

            }
            br.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }



    }
}
