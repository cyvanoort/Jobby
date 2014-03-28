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
public class CVCrawler extends AbstractCrawler {

    
    
    //crawl sector (25 = ICT)
    //http://www.cvenvacaturebank.nl/cv?keywords=&sector=25&niveau=&ervaring=0&province=&plaats=
    //cv pagina
    //http://www.cvenvacaturebank.nl/cv/104799/Accountmanager_Beinsdorp.html
    //volgende pagina O elke pagina is +20 alleen gebruikte keywords zijn nodig
    //http://www.cvenvacaturebank.nl/cv?o=20&keywords=&sector=25
    public CVCrawler(String url) {
        super(url);
        
    }

    @Override
    protected String actionUrl() {
        String nextUrl = "";
        CVFactory cvf = new CVFactory();
        for (String crawled_url : crawled_Urls) {
            //add regex voor nummers na laatste /
            if (crawled_url.contains("http://www.cvenvacaturebank.nl/cv/1")) {
                //System.out.println(crawled_url);
                CV cv = cvf.crawlCV(crawled_url);
                cv.cleaner();
                System.out.println(cv.toString());
                jh.CVJson(cv);
                System.out.println(cv.getBeroep() + " " + cv.getLeeftijd());
            }
            if (crawled_url.contains("http://www.cvenvacaturebank.nl/cv?o=" + 20 * page)) {
                nextUrl = crawled_url;
            }
        }
        return nextUrl;
    }
}
