package bway.scrape;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	try {
    		Document page = Jsoup.connect("https://www.bookstores.com/browse/books/?c=000001").userAgent("https://www.bookstores.com/").get();
        	Elements header = page.getElementsByClass("col col-1-of-3");
        	
        	FileOutputStream fout = new FileOutputStream("scrape.csv");
        	PrintStream csv = new PrintStream(fout);
        	csv.println("Subjects");
        	
//        	List<String> h1 = new ArrayList<String>();
        	
        	for (Element e: header) {
//        		h1.add(e.text());
        		csv.println(e.text());
        		
        	}
//        	System.out.println(h1);
        	System.out.println("Running");
        	fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
