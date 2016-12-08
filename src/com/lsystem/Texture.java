package com.lsystem;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Created by naja on 30-11-2016.
 */
public class Texture {
    public static Image backImg;
    public static Image soilImg; //TODO: skal slettes hvis vi ikke bruger groundObject
    public static Image barkImg2;
    public static Image leafImg;
    public static Image leafImg2;
    public static Image leafHigh;
    private BufferedImage barkImg;
    public static TexturePaint soilTex; //TODO: skal slettes hvis vi ikke bruger groundObject
    public static TexturePaint barkTex;
    public Texture(boolean shouldLoad) {
        if (shouldLoad ==  true) {
            loadImages();
            barkTex = new TexturePaint( this.barkImg, new Rectangle(0, 0, 150, 150));
        }
        else {
            setImagestoNull();
            System.out.println("trying to remove texture");
        }
    }
    private void setImagestoNull() {
        barkTex = null;
        barkImg = null;
        backImg = null;
        leafImg = null;
        leafImg2 = null;
        leafHigh = null;
    }
    public void loadImages() {
        try {
            Toolkit tk = Toolkit.getDefaultToolkit();
            this.backImg = tk.createImage("Src//ImagePackage//backgroundImage.jpg");
            this.soilImg = tk.createImage("Src//ImagePackage//soilTex.jpg"); //TODO: skal slettes hvis vi ikke bruger groundObject
            this.leafImg = tk.createImage("Src//ImagePackage//leafRight.png");
            this.leafImg2 = tk.createImage("Src//ImagePackage//leafleft.png");
            this.leafHigh = tk.createImage("Src//ImagePackage//leafHorizontal.png");
            this.barkImg2 = tk.createImage("Src//ImagePackage//barkTexture.jpg");
            this.barkImg = ImageIO.read(new File("Src//ImagePackage//barkTexture.jpg"));
        } catch (IOException var2) {
            Logger.getLogger(Texture.class.getName()).log(Level.SEVERE, (String)null, var2);
        }
    }
}