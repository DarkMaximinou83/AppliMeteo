package sample;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by maxim on 22/12/2016.
 */
public class RechercheVille {
    protected ArrayList<Ville> tabVille = new ArrayList<Ville>();
    protected String url=null;
    public RechercheVille(){
        ReadFile read=new ReadFile();
        read.main(tabVille);
       /* tabVille.add(new Ville("48.85341", "2.3488", "Paris"));
        tabVille.add(new Ville("43.12422","9.9279", "Toulon"));*/
    }
    public String getUrl(String ville) {
        Iterator<Ville> iter = this.tabVille.iterator();
        while (iter.hasNext()) {
            Ville v = iter.next();
            if (v.getNom().equals(ville)) {
                this.url = "http://www.infoclimat.fr/public-api/gfs/xml?_ll=" + v.getX() + "," + v.getY() + "&_auth=ABpQRwB%2BUnAFKFViBnBXflM7BzJdK1RzA39VNl8xAn8CaANjVD9VNFc8VyoALwMzAi9TOwg3CDgDaQdiWigEeABgUDQAYFI1BWxVPwY3V3xTfwdlXWdUcwN%2FVTpfMAJ%2FAmMDY1QxVSlXP1c9AC4DNQIxUzoIKAgvA2EHY1ozBG8Aa1AyAGZSNAVpVTQGKVd8U2UHZ11kVGoDYFVmXzsCaAJoA2ZUMVU2V2lXPQAuAzQCM1MwCDQIMANoB2RaNQR4AHxQTQAQUi0FKlV1BmNXJVN9BzJdPFQ4&_c=f30d5acf5e18de4f029990712316a936";

            }


        }
        if(this.url==null){
            System.out.println( "ville non trouvé" );
        }
        return this.url;
    }
}
