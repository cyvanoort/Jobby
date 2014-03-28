package cv_vacature_bank;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
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
public class CVFactory extends AbstractFactory {

    
    private CVHulp cvh;

    public CVFactory() {
        cvh = new CVHulp();
    }

    public CV crawlCV(String url) {
        CV cv = new CV();
        cv.setUrl(url);

        try {
            URL my_url = new URL(url);
            BufferedReader br = new BufferedReader(new InputStreamReader(my_url.openStream()));
            String strTemp = "";
            while (null != (strTemp = br.readLine())) {
                cv = getCV(strTemp, cv);
            }
            br.close();

        } catch (IOException ex) {

        }

        return cv;
    }

    public CV getCV(String str, CV cv) {

        if (wec) {
            cv.setWerkervaring(addContinuatie(str, cv.getWerkervaring()));
        }
        if (opc) {
            cv.setOpleiding(addContinuatie(str, cv.getOpleiding()));
        }

        if (zkc) {
            cv.setZoekt(addContinuatie(str, cv.getZoekt()));
        }

        if (cv.getGeplaatst() == null) {
            cv.setGeplaatst(getInformation(str, cvh.GEPLAATS));
        }

        if (cv.getBeroep() == null) {
            cv.setBeroep(getInformation(str, cvh.BEROEP));
        }

        if (cv.getVakgebied() == null) {
            cv.setVakgebied(getInformation(str, cvh.VAKGEBIED));
        }
        if (cv.getAuto() == null) {
            cv.setAuto(getInformation(str, cvh.AUTO));
        }
        if (cv.getGeslacht() == null) {
            cv.setGeslacht(getInformation(str, cvh.GESLACHT));
        }

        if (cv.getOpleiding() == null) {
            cv.setOpleiding(getLongInformation(str, cvh.OPLEIDING));
            if (cv.getOpleiding() != null) {

                String temp = getEndingInformation(cv.getOpleiding());
                if (!temp.equals("")) {
                    cv.setOpleiding(temp);
                } else {
                    opc = true;
                }
            }
        }

        if (cv.getOpleidingsNiveau() == null) {
            cv.setOpleidingsNiveau(getInformation(str, cvh.NIVEAU));
        }
        if (cv.getProvincie() == null) {
            cv.setProvincie(getInformation(str, cvh.PROVINCIE));
        }
        if (cv.getRijbewijs() == null) {
            cv.setRijbewijs(getInformation(str, cvh.RIJBEWIJS));
        }

        if (cv.getWerkervaring() == null) {
            cv.setWerkervaring(getLongInformation(str, cvh.WERKERVARING));
            if (cv.getWerkervaring() != null) {

                String temp = getEndingInformation(cv.getWerkervaring());
                if (!temp.equals("")) {
                    cv.setWerkervaring(temp);
                } else {

                    wec = true;
                }
            }
        }

        if (cv.getWoonplaats() == null) {
            cv.setWoonplaats(getInformation(str, cvh.WOONPLAATS));
        }

        if (cv.getZoekt() == null) {

            cv.setZoekt(getLongInformation(str, cvh.ZOEKT));
            if (cv.getZoekt() != null) {
                String temp = getEndingInformation(cv.getZoekt());
                if (!temp.equals("")) {
                    cv.setZoekt(temp);
                } else {
                    zkc = true;
                }
            }

        }

        if (cv.getLeeftijd() == null) {
            cv.setLeeftijd(getInformation(str, cvh.LEEFTIJD));
        }

        return cv;

    }

}
