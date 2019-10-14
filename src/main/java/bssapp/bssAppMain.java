package bssapp;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import bssapp.GoogleService;
import org.jsoup.nodes.Document;

public class bssAppMain {

    public static void main(String... args) throws Exception {

        //load data from google sheet
        List<List<Object>> sheet = GoogleService.readSheet();

        //parse data from pattern
        Document doc = HTMLService.getHtml();
        
        //make email notification for every new aplication
        HTMLService.setData(doc, sheet.get(4));
   }
}