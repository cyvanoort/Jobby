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
public class VacatureFactory extends AbstractFactory {

    //checks voor als een onderdeel langer is dan 1 line
    //omschrijving continuatie
    boolean omc = false;
    //aanbod continuatie
    boolean abc = false;
    //bedrijfsprofiel continuatie
    boolean bpc = false;
    //eigenschappen continuatie
    boolean gsc = false;
    //eisen continuatie
    boolean esc = false;
    //kennis continuatie
    boolean ksc = false;

    VacatureHulp vch;

    public VacatureFactory() {

    }

    public Vacature crawlVacature(String url) {
        Vacature vc = new Vacature();
        vc.setUrl(url);
        vch = new VacatureHulp();

        try {
            URL my_url = new URL(url);
            BufferedReader br = new BufferedReader(new InputStreamReader(my_url.openStream()));
            String strTemp = "";
            while (null != (strTemp = br.readLine())) {
                vc = getVacature(strTemp, vc);
            }
            br.close();

        } catch (IOException ex) {

        }

        return vc;
    }

    public Vacature getVacature(String str, Vacature vc) {
        if (omc) {
            vc.setOmschrijving(addContinuatie(str, vc.getOmschrijving()));
        }
        if (abc) {
            vc.setAanbod(addContinuatie(str, vc.getAanbod()));
        }
        if (bpc) {
            vc.setBedrijfsprofiel(addContinuatie(str, vc.getBedrijfsprofiel()));
        }
        if (gsc) {
            vc.setEigenschappen(addContinuatie(str, vc.getEigenschappen()));
        }
        if (esc) {
            vc.setEisen(addContinuatie(str, vc.getEisen()));
        }
        if (ksc) {
            vc.setKennis(addContinuatie(str, vc.getKennis()));
        }

        if (vc.getBeroep() == null) {
            vc.setBeroep(getInformation(str, vch.BEROEP));
        }

        if (vc.getOmschrijving() == null) {
            vc.setOmschrijving(getLongInformation(str, vch.OMSCHRIJVING));
            if (vc.getOmschrijving() != null) {

                String temp = getEndingInformation(vc.getOmschrijving());
                if (!temp.equals("")) {
                    vc.setOmschrijving(temp);
                } else {
                    omc = true;
                }
            }
        }

        if (vc.getDienstverband() == null) {
            vc.setDienstverband(getInformation(str, vch.DIENSTVERBAND));
        }
        if (vc.getNiveau() == null) {
            vc.setNiveau(getInformation(str, vch.NIVEAU));
        }
        if (vc.getRegio() == null) {
            vc.setRegio(getInformation(str, vch.REGIO));
        }
        if (vc.getSector() == null) {
            vc.setSector(getInformation(str, vch.SECTOR));
        }
        if (vc.getAanbod() == null) {
            vc.setAanbod(getLongInformation(str, vch.AANBOD));
            if (vc.getAanbod() != null) {

                String temp = getEndingInformation(vc.getAanbod());
                if (!temp.equals("")) {
                    vc.setAanbod(temp);
                } else {
                    abc = true;
                }
            }

        }

        if (vc.getBedrijfsprofiel() == null) {
            vc.setBedrijfsprofiel(getLongInformation(str, vch.BEDRIJF));
            if (vc.getBedrijfsprofiel() != null) {

                String temp = getEndingInformation(vc.getBedrijfsprofiel());
                if (!temp.equals("")) {
                    vc.setBedrijfsprofiel(temp);
                } else {
                    bpc = true;
                }
            }
        }
        if (vc.getEigenschappen() == null) {
            vc.setEigenschappen(getLongInformation(str, vch.EIGENSCHAPPEN));
            if (vc.getEigenschappen() != null) {

                String temp = getEndingInformation(vc.getEigenschappen());
                if (!temp.equals("")) {
                    vc.setEigenschappen(temp);
                } else {
                    gsc = true;
                }
            }
        }
        if (vc.getEisen() == null) {
            vc.setEisen(getLongInformation(str, vch.EISEN));
            if (vc.getEisen() != null) {

                String temp = getEndingInformation(vc.getEisen());
                if (!temp.equals("")) {
                    vc.setEisen(temp);
                } else {
                    esc = true;
                }
            }
        }
        if (vc.getKennis() == null) {
            vc.setKennis(getLongInformation(str, vch.KENNIS));
            if (vc.getKennis() != null) {

                String temp = getEndingInformation(vc.getKennis());
                if (!temp.equals("")) {
                    vc.setKennis(temp);
                } else {
                    ksc = true;
                }
            }
        }

        return vc;
    }

}
