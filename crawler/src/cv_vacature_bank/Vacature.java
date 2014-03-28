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
public class Vacature {
    private String url;
    private String beroep;
    private String omschrijving;
    private String regio;
    private String sector;
    private String niveau;
    private String dienstverband;
    
    //optioneel
    private String bedrijfsprofiel;
    private String aanbod;
    private String eigenschappen;
    private String eisen;
    private String kennis;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBeroep() {
        return beroep;
    }

    public void setBeroep(String beroep) {
        this.beroep = beroep;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getRegio() {
        return regio;
    }

    public void setRegio(String regio) {
        this.regio = regio;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getDienstverband() {
        return dienstverband;
    }

    public void setDienstverband(String dienstverband) {
        this.dienstverband = dienstverband;
    }

    public String getBedrijfsprofiel() {
        return bedrijfsprofiel;
    }

    public void setBedrijfsprofiel(String bedrijfsprofiel) {
        this.bedrijfsprofiel = bedrijfsprofiel;
    }

    public String getAanbod() {
        return aanbod;
    }

    public void setAanbod(String aanbod) {
        this.aanbod = aanbod;
    }

    public String getEigenschappen() {
        return eigenschappen;
    }

    public void setEigenschappen(String eigenschappen) {
        this.eigenschappen = eigenschappen;
    }

    public String getEisen() {
        return eisen;
    }

    public void setEisen(String eisen) {
        this.eisen = eisen;
    }

    public String getKennis() {
        return kennis;
    }

    public void setKennis(String kennis) {
        this.kennis = kennis;
    }
    
    
}
