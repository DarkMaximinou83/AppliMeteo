package Model;
import java.io.*;
/**
 * Created by maxim on 08/12/2016.
 */
public class ReadFiles {
    public int main(Complexe[]  tab){
        String chaine="";
        int compt,compt2,compt3;
        int taille=0;
        int re,im;
        String fichier ="fichiertexte.txt";

        //lecture du fichier texte
        try{
            InputStream ips=new FileInputStream(fichier);
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;
            compt=2;
            compt2=0;
            compt3=0;
            re=0;
            while ((ligne=br.readLine())!=null){
                if(compt3==0){
                    taille=Integer.parseInt(ligne);
                }
                else {
                    if (compt % 2 == 0) {
                        re = Integer.parseInt(ligne);
                    } else {
                        im = Integer.parseInt(ligne);
                        tab[compt2] = new Complexe(re, im);
                        compt2++;
                    }
                    compt++;
                }
                compt3++;




                System.out.println(ligne);
                chaine+=ligne+"\n";

            }
            br.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        //création ou ajout dans le fichier texte
       /* try {
            FileWriter fw = new FileWriter (fichier);
            BufferedWriter bw = new BufferedWriter (fw);
            PrintWriter fichierSortie = new PrintWriter (bw);
            fichierSortie.println (chaine+"\n test de lecture et écriture !!");
            fichierSortie.close();
            System.out.println("Le fichier " + fichier + " a été créé!");
        }
        catch (Exception e){
            System.out.println(e.toString());
        }*/
       return(taille);
    }

}
