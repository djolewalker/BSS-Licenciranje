package bssapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.imageio.stream.FileImageInputStream;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

public class HTMLService {

    private static String filePath = "/home/dimitrije/NetBeansProjects/bssApp/src/main/java/Formular/Formular.html";

    //////////////////////////////////////////////////////////////////////////////
    //             LOAD HTML FILE WHICH REPRESENT REGISTRATION FORM             //
    //////////////////////////////////////////////////////////////////////////////
    public static Document getHtml() throws FileNotFoundException, IOException {
        return Jsoup.parse(new FileInputStream(filePath), "UTF-8", "", Parser.htmlParser());
    }
    
    public static Document setData(Document doc, List<Object> row){
        
        doc.getElementById("klub").text(row.get(2).toString());
        doc.getElementById("klub-adresa").text(row.get(3).toString());
        doc.getElementById("uci-tim").text(row.get(4).toString());
        doc.getElementById("klub-email").text(row.get(5).toString());
        doc.getElementById("ime-prezime").text(row.get(6).toString());
        doc.getElementById("kategorija").text(row.get(7).toString());
        doc.getElementById("dat-rodj").text(row.get(8).toString());
        doc.getElementById("jmbg").text(row.get(9).toString());
        doc.getElementById("uci-id").text(row.get(10).toString());
        doc.getElementById("nacionalnost").text(row.get(11).toString());
        doc.getElementById("pol").text(row.get(12).toString());
        doc.getElementById("ime-rod").text(row.get(13).toString());
        doc.getElementById("tel").text(row.get(14).toString());
        doc.getElementById("e-mail").text(row.get(1).toString());
        doc.getElementById("mesto-adresa").text(row.get(16).toString()+" , "+row.get(15).toString());
        doc.getElementById("zemlja").text(row.get(18).toString()+" , "+row.get(17).toString());
        doc.getElementById("drzavljanstva").text(row.get(19).toString());
        doc.getElementById("kontakt-osoba").text(row.get(20).toString()+" , "+row.get(21).toString());
        doc.getElementById("izdavalac-last").text(row.get(22).toString());
        doc.getElementById("izdavalac-last-odbio").text(row.get(23).toString());
        doc.getElementById("izdavalac-last-suspenzija").text(row.get(24).toString());
        doc.getElementById("suspenzija-pocetak").text(row.get(25).toString());
        doc.getElementById("lekarski-datumi").text(row.get(26).toString());
        doc.getElementById("os-drustvo").text(row.get(29).toString()+" , "+row.get(30).toString());
        doc.getElementById("osiguranik").text(row.get(31).toString()+" , "+row.get(32).toString());
        doc.getElementById("polisa-vazenje").text(row.get(34).toString()+" - "+row.get(35).toString());
        doc.getElementById("polisa-suma").text(row.get(33).toString());
        doc.getElementById("polisa-teritorija").text(row.get(36).toString());
        
        System.out.println(doc.body());
        
        return doc;
    }

}
