package com.lsystem.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VisualComponents {

    public static Image background;
    public static Image leafRight;
    public static Image leafLeft;
    public static BufferedImage textureOff;
    public static Image textureOn;
    private BufferedImage barkImg;
    public static TexturePaint barkTex;
    public static ImageIcon texOffIcon;

    public VisualComponents(boolean shouldLoad) {
        if (shouldLoad ==  true) {
            loadImages();
            barkTex = new TexturePaint( this.barkImg, new Rectangle(0, 0, 150, 150));
            texOffIcon = new ImageIcon(this.textureOff);
        }
        else {
            setImagestoNull();
            System.out.println("trying to remove visualComponents");
        }
    }
    private void setImagestoNull() {
        barkTex = null;
        barkImg = null;
        background = null;
        leafRight = null;
        leafLeft = null;

    }
    public void loadImages() {
        try {
            Toolkit tk = Toolkit.getDefaultToolkit();
            this.background = tk.createImage("Src//image_package//backgroundImage.jpg");
            this.leafRight = tk.createImage("Src//image_package//leafRight.png");
            this.leafLeft = tk.createImage("Src//image_package//leafleft.png");
            this.barkImg = ImageIO.read(new File("Src//image_package//barkTexture.jpg"));
            this.textureOff = ImageIO.read(new File("Src//image_package//textureoff.png"));
            this.textureOn = ImageIO.read(new File("Src//image_package//textureOn.png"));
        } catch (IOException var2) {
            Logger.getLogger(VisualComponents.class.getName()).log(Level.SEVERE, (String)null, var2);
        }
    }
}