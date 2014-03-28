package cv_vacature_bank;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import org.json.simple.JSONObject;

/**
 *
 * @author Bert
 */
public class Jsonhandler {

    protected int id;
    private ArrayList<JSONObject> objs = new ArrayList<JSONObject>(20);

    public Jsonhandler() {
        id = 0;
    }

    public void CVJson(CV cv) {
        if (cv == null) {
            return;
        }
        JSONObject cvj = new JSONObject();
        cvj.put("url", cv.getUrl());
        cvj.put("geplaatst", cv.getGeplaatst());
        cvj.put("beroep", cv.getBeroep());
        cvj.put("vakgebied", cv.getVakgebied());
        cvj.put("werkervaring", cv.getWerkervaring());
        cvj.put("opleidingsNiveau", cv.getOpleidingsNiveau());
        cvj.put("opleiding", cv.getOpleiding());
        cvj.put("zoekt", cv.getZoekt());
        cvj.put("woonplaats", cv.getWoonplaats());
        cvj.put("provincie", cv.getProvincie());
        cvj.put("geslacht", cv.getGeslacht());
        cvj.put("leeftijd", cv.getLeeftijd());
        cvj.put("rijbewijs", cv.getRijbewijs());
        cvj.put("auto", cv.getAuto());
        
        objs.add(cvj);
        
        if(objs.size() == 20){
            createFile("CV");
            objs.clear();
        }

    }
    
    public void VacatureJson(Vacature vc) {
        if (vc == null) {
            return;
        }
        JSONObject vcj = new JSONObject();
        vcj.put("url", vc.getUrl());
        vcj.put("beroep", vc.getBeroep());
        vcj.put("omschrijving", vc.getOmschrijving());
        vcj.put("regio", vc.getRegio());
        vcj.put("sector", vc.getSector());
        vcj.put("niveau", vc.getNiveau());
        vcj.put("dienstverband", vc.getDienstverband());
        vcj.put("bedrijfsprofiel", vc.getBedrijfsprofiel());
        vcj.put("aanbod", vc.getAanbod());
        vcj.put("eigenschappen", vc.getEigenschappen());
        vcj.put("eisen", vc.getEisen());
        vcj.put("kennis", vc.getKennis());
        
        objs.add(vcj);
        
        if(objs.size() == 20){
            createFile("Vacature");
            objs.clear();
        }

    }

    public void createFile(String type) {
        Writer writer = null;
        id++;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(type + Integer.toString(id) + ".txt"), "utf-8"));

            for (JSONObject jo : objs) {
                writer.write(jo.toJSONString() + "\n\n");
            }
        } catch (IOException ex) {
            // report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
            }
        }
    }
}
