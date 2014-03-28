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
public class VacatureCrawler extends AbstractCrawler {

    public VacatureCrawler(String url) {
        super(url);
    }

    @Override
    protected String actionUrl() {
        String nextUrl = "";
        VacatureFactory vcf = new VacatureFactory();
        for (String crawled_url : crawled_Urls) {
            //add regex voor nummers na laatste /
            if (crawled_url.contains("http://www.cvenvacaturebank.nl/vacature/") && !crawled_url.contains("plaats")) {
                //System.out.println(crawled_url);
                Vacature vc = vcf.crawlVacature(crawled_url);
                jh.VacatureJson(vc);
                System.out.println(vc.getBeroep() + " " + vc.getDienstverband());
            }
            if (crawled_url.contains("http://www.cvenvacaturebank.nl/vacature?o=" + 20 * page)) {
                nextUrl = crawled_url;
            }
        }
        return nextUrl;
    }
}
