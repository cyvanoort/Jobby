package cv_vacature_bank;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
public abstract class AbstractCrawler {
    public List<String> crawled_Urls = new ArrayList<String>();
    public String url;
    public int page = 0;
    protected Jsonhandler jh;
    
    public AbstractCrawler(String url){
        jh = new Jsonhandler();
        this.url = url;
        error_url(url);
        
    }
    
    
    private void crawl(String input) {
        try {
            URL my_url = new URL(input);
            BufferedReader br = new BufferedReader(new InputStreamReader(my_url.openStream()));
            String strTemp = "";
            while (null != (strTemp = br.readLine())) {
                url_Filter(strTemp);
            }
            if (crawled_Urls != null) {
                String nextUrl = actionUrl();
                br.close();
                crawled_Urls.clear();
                if (!nextUrl.equals("")) {
                    error_url(nextUrl);
                }
            }
            
        } catch (IOException ex) {

        }
    }

    public void url_Filter(String strTemp) {
        if (strTemp.contains("<a href=")) {
            Pattern p = Pattern.compile("<a[^>]+href=\"([^\"]+)\"");
            Matcher m = p.matcher(strTemp);
            while (m.find()) {
                if (!crawled_Urls.contains(m.group(1))) {
                    if (m.group(1).contentEquals(url)) {
                        crawled_Urls.add(m.group(1));
                    } else {

                        String foundurl = m.group(1);
                        if (!foundurl.contains("http")) {
                            foundurl = "http://www.cvenvacaturebank.nl" + foundurl;
                        }
                        crawled_Urls.add(foundurl);

                    }
                }
            }
        }
    }

    private void error_url(String url) {
        page++;
        //return 2 * 20 = 40 records
        if(page > 2){
            return;
        }
        boolean check_http = url.startsWith("http://");
        boolean check_https = url.startsWith("https://");

        if (check_https || check_http) {
            crawl(url);
        } else {
            String good_url = "http://" + url;
            crawl(good_url);
        }
    }
    
    abstract protected String actionUrl();
}
