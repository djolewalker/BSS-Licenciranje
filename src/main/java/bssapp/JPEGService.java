/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bssapp;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author dimitrije
 */
public class JPEGService {
    
    private static final String USER_PICTURE_PATH = "/home/dimitrije/NetBeansProjects/bssApp/files/korisnik.jpg";

    public static FileOutputStream getFOS() throws IOException {
        return new FileOutputStream(USER_PICTURE_PATH);
    }

}
