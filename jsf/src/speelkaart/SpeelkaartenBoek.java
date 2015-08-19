package speelkaart;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class SpeelkaartenBoek implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private SpeelKaart[] boek;
    private static final String[] tekens = {"Harten", "Ruiten", "Schoppen", "Klaveren"};
    private static final String[] afbeeldingen = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Boer", "Dame", "Heer"};
    private int indexHuidigeKaart;
    
    /**
     * Creates a new instance of SpeelkaartenBoek 
     */
    public SpeelkaartenBoek() {
        indexHuidigeKaart = -1;
        boek = new SpeelKaart[52];
        for(int kaart=0; kaart<boek.length; kaart++){
            boek[kaart] = new SpeelKaart( afbeeldingen[kaart%13], tekens[kaart/13]);
        }
    }
    
    public void schud(){
        for(int kaart=0; kaart<boek.length; kaart++){
           int andereKaart = (int) (Math.random()*boek.length);
           SpeelKaart tmp = boek[kaart];
           boek[kaart] = boek[andereKaart];
           boek[andereKaart]  = tmp;
        }
        indexHuidigeKaart = -1;
    }
    
    public SpeelKaart geefKaart(){
        if(++indexHuidigeKaart < boek.length){
            return boek[indexHuidigeKaart];
        }
        else{
            return null;
        }
    }
    
    public int aantalKaarten(){
        return boek.length;
    }

}
