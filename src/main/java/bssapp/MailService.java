/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bssapp;

import com.sun.mail.smtp.SMTPTransport;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author dimitrije
 */
public class MailService {

    private static final String SMTP_SERVER = "127.0.0.1";
    private static final String USERNAME = "dimitrije";
    private static final String PASSWORD = "dimi159951";

    private static final String EMAIL_FROM = "Dimitrije Zarkovic <djole.bss@as-bss.com>";

    public static void sendEMail(String mail) throws Exception {
        System.out.println(mail);
        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", SMTP_SERVER); //optional, defined in SMTPTransport
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "25"); // default port 25

        Session session = Session.getInstance(prop, null);

        Message msg = new MimeMessage(session);

        try {
            msg.setFrom(new InternetAddress(EMAIL_FROM));

            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(mail, true));

            msg.setSubject("Zahtev za licencu 2020");

            msg.setSentDate(new Date());
            
            msg.setHeader("Content-Type", "text/plain; charset=UTF-8");

            MimeBodyPart p1 = new MimeBodyPart();
            p1.setText(
                    "\nPozdrav,\n\n"
                +   "Uspesno ste podneli zahtev. \nPoslednji korak je da odstampate i potpisete ovaj zahtev. \n"
                +   "Ovaj zahtev kao i ostala potrebna dokumenta potrebno je dostaviti savezu na uvid.\n"
                +   "Odstampan i potpisan zahtev mozete poslati u digitalnoj formi (skenirana dokumenta) na adresu ili na adresu biciklistickog saveza.\n"
                +   "Ovo je genericki mail, na njega ne treba da odgovarate.\n\n\n"
                +   "Sa postovanjem,\n"
                +   "ASocijacija sudija BSS\n"
                +   "Ulica Ulica bb/bb\n"
                +   "+381 111 111 111\n"
                +   "www.bss.rs");

            MimeBodyPart p2 = new MimeBodyPart();
            FileDataSource fds = new FileDataSource(HTMLService.LOCAL_USER_PATH_PDF);
            p2.setDataHandler(new DataHandler(fds));
            p2.setFileName("Zahtev za licencu 2020.pdf");

            Multipart mp = new MimeMultipart();
            mp.addBodyPart(p1);
            mp.addBodyPart(p2);

            msg.setContent(mp,"text/plain");

            SMTPTransport.send(msg, USERNAME, PASSWORD);

        } catch (Exception e) {
            System.out.println("Mail is not sent: " + e);
        }
    }
}
