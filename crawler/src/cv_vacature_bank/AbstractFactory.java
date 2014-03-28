package cv_vacature_bank;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bert
 */
public abstract class AbstractFactory {
    
    
    //checks voor als een onderdeel langer is dan 1 line
    //omschrijving continuatie
    protected boolean omc = false;
    //aanbod continuatie
    protected boolean abc = false;
    //bedrijfsprofiel continuatie
    protected boolean bpc = false;
    //eigenschappen continuatie
    protected boolean gsc = false;
    //eisen continuatie
    protected boolean esc = false;
    //kennis continuatie
    protected boolean ksc = false;
    
    protected boolean wec = false;
    protected boolean opc = false;
    protected boolean zkc = false;
    
    public String addContinuatie(String str, String huidig) {
        if (str.contains("</div></div>")) {
            Pattern pattern = Pattern.compile("(.+?)</div></div>");
            Matcher matcher = pattern.matcher(str);
            matcher.find();
            omc = abc = bpc = gsc = esc = ksc = opc = wec = zkc = false;
            return (huidig + matcher.group(1));
        }
        return (huidig + str);
    }

    public String getInformation(String str, String subject) {
        if (str.contains("<div class=row><span>" + subject + "</span>")) {
            Pattern pattern = Pattern.compile("<div class=row><span>" + subject + "</span><div class=jump>(.+?)</div></div>");
            Matcher matcher = pattern.matcher(str);
            matcher.find();
            return matcher.group(1);
        }
        return null;
    }

    public String getLongInformation(String str, String subject) {
        if (str.contains("<div class=row><span>" + subject + "</span>")) {
            String[] parts = str.split("<div class=row><span>" + subject + "</span><div class=jump>");
            String res = parts[1];
            return res;
        }
        return null;

    }

    public String getEndingInformation(String str) {
        if (str.contains("</div></div>")) {
            String[] parts = str.split("</div></div>");
            String res = parts[0];
            opc = wec = zkc = false;
            return res;
        }

        return "";
    }
    
}
