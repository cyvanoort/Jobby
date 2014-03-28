package cv_vacature_bank;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bert
 */
public class CV {

    //contact
    private String url;
    private String geplaatst;

    //ervaring
    private String beroep;
    private String vakgebied;
    private String werkervaring;
    private String opleidingsNiveau;
    private String opleiding;
    private String zoekt;

    //Locatie
    private String woonplaats;
    private String provincie;

    //persoonlijk
    private String geslacht;
    private String leeftijd;
    private String rijbewijs;
    private String auto;

    public CV() {

    }

    public void cleaner() {

        geplaatst = geplaatst.replaceAll("\\<.*?>", "").replaceAll("\t", "");
        beroep = beroep.replaceAll("\\<.*?>", "").replaceAll("\t", "");
        vakgebied = vakgebied.replaceAll("\\<.*?>", "").replaceAll("\t", "");
        if (werkervaring != null) {
            werkervaring = longCleaner(werkervaring);
        }
        opleidingsNiveau = opleidingsNiveau.replaceAll("\\<.*?>", "").replaceAll("\t", "");
        if (opleiding != null) {
            opleiding = longCleaner(opleiding);
        }
        if (zoekt != null) {
            zoekt = longCleaner(zoekt);
        }
        woonplaats = woonplaats.replaceAll("\\<.*?>", "").replaceAll("\t", "");
        provincie = provincie.replaceAll("\\<.*?>", "").replaceAll("\t", "");
        if (geslacht != null) {
            geslacht = geslacht.replaceAll("\\<.*?>", "").replaceAll("\t", "");
        }
        if (leeftijd != null) {
            leeftijd = leeftijd.replaceAll("\\<.*?>", "").replaceAll("\t", "");
        }
        if (rijbewijs != null) {
            rijbewijs = rijbewijs.replaceAll("\\<.*?>", "").replaceAll("\t", "");
        }
        auto = auto.replaceAll("\\<.*?>", "").replaceAll("\t", "");
    }

    public String longCleaner(String in) {
        in = in.replaceAll("<br />", "\n").replaceAll("\\<.*?>", "").replaceAll("\t", " ");
        return in;
    }

    public String getUrl() {
        return url;

    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGeplaatst() {
        return geplaatst;
    }

    public void setGeplaatst(String geplaatst) {
        this.geplaatst = geplaatst;
    }

    public String getBeroep() {
        return beroep;
    }

    public void setBeroep(String beroep) {
        this.beroep = beroep;
    }

    public String getVakgebied() {
        return vakgebied;
    }

    public void setVakgebied(String vakgebied) {
        this.vakgebied = vakgebied;
    }

    public String getWerkervaring() {
        return werkervaring;
    }

    public void setWerkervaring(String werkervaring) {
        this.werkervaring = werkervaring;
    }

    public String getOpleidingsNiveau() {
        return opleidingsNiveau;
    }

    public void setOpleidingsNiveau(String opleidingsNiveau) {
        this.opleidingsNiveau = opleidingsNiveau;
    }

    public String getOpleiding() {
        return opleiding;
    }

    public void setOpleiding(String opleiding) {
        this.opleiding = opleiding;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public String getProvincie() {
        return provincie;
    }

    public void setProvincie(String provincie) {
        this.provincie = provincie;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public String getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(String leeftijd) {
        this.leeftijd = leeftijd;
    }

    public String getRijbewijs() {
        return rijbewijs;
    }

    public void setRijbewijs(String rijbewijs) {
        this.rijbewijs = rijbewijs;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getZoekt() {
        return zoekt;
    }

    public void setZoekt(String zoekt) {
        this.zoekt = zoekt;
    }

    public String toString() {
        return "cv: " + url + ", " + geplaatst + ", " + beroep + ", " + vakgebied + ", " + werkervaring + ", " + opleidingsNiveau + ", " + opleiding + ", " + zoekt + ", " + woonplaats + ", " + provincie + ", " + geslacht + ", " + leeftijd + ", " + rijbewijs + ", " + auto;

    }

}
