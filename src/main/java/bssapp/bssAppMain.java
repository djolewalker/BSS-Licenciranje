package bssapp;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import bssapp.GoogleService;
import org.jsoup.nodes.Document;

public class bssAppMain {

    public static void main(String... args) throws IOException, GeneralSecurityException {

        //load data from google sheet
        List<List<Object>> sheet = GoogleService.readSheet();

//        if (sheet == null || sheet.isEmpty()) {
//            System.out.println("No data found.");
//        } else {
//            System.out.println("Podaci:");
//            for (List row : sheet) {
//                // Print columns A and E, which correspond to indices 0 and 4.
//                for (int i = 0; i < 29; i++) {
//                    System.out.printf(row.get(i).toString() + '\n');
//                }
//
//            }
//        }

        Document doc = HTMLService.getHtml();
        
        HTMLService.setData(doc, sheet.get(1));
        
        GoogleService.getFiles();
        
        

    }
}
