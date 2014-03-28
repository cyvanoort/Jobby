package cv_vacature_bank;


public class TestDrive {

    public static void main(String[] argv) {
        //new PersonCrawler();
	//new PersonCrawler("http://nl.linkedin.com/pub/patrick-kramer/45/676/483");
        //new PersonCrawler("http://www.linkedin.com/pub/geerke-van-t-veer/10/616/93b");
        //new PersonCrawler("www.linkedin.com/in/williamhgates");
        //new PersonCrawler(296316671);
        //new LinkedinHandler();
        new CVCrawler("http://www.cvenvacaturebank.nl/cv?keywords=&sector=25&niveau=&ervaring=0&province=&plaats=");
        //new VacatureCrawler("http://www.cvenvacaturebank.nl/vacature?keywords=&sector=25&province=&plaats=");
    }
}
