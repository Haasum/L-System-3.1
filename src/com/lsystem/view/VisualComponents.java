package com.lsystem.view;

import javax.imageio.ImageIO;
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
    private BufferedImage barkImg;
    public static TexturePaint barkTex;

    /***
     * * Constructs the VisualComponents object
     * <p>
     *     This contains the methods that the visualComponents class consist of,
     *     The method is runned, depending on the parameter shouldLoad:
     *     If shouldLoad is true, the images should be loaded.
     *     if shouldLoad is false, the images shouldnt be loaded.
     * </p>
     * @param shouldLoad boolean: should the images be loaded or = null (should the texture be on or off?)
     */
    public VisualComponents(boolean shouldLoad) {

        if (shouldLoad ==  true) {
            loadImages();
            barkTex = new TexturePaint( this.barkImg, new Rectangle(0, 0, 150, 150));
        }
        else {
            setImagestoNull();
            System.out.println("removing visualComponents");
        }
    }

    /**
     * Sets the images to null.
     * <p>
     *     The images are set to null, which means that there are no textures or images shown in the program frame.
     * </p>
     */
    private void setImagestoNull() {
        barkTex = null;
        barkImg = null;
        background = null;
        leafRight = null;
        leafLeft = null;

    }

    /**
     * Loads the images.
     * <p>
     *     This loads the images from the image package.
     * </p>
     */
    public void loadImages() {
        try {
            Toolkit tk = Toolkit.getDefaultToolkit();
            this.background = tk.createImage("Src//image_package//backgroundImage.jpg");
            this.leafRight = tk.createImage("Src//image_package//leafRight.png");
            this.leafLeft = tk.createImage("Src//image_package//leafleft.png");
            this.barkImg = ImageIO.read(new File("Src//image_package//barkTexture.jpg"));
        } catch (IOException var2) {
            Logger.getLogger(VisualComponents.class.getName()).log(Level.SEVERE, (String)null, var2);
        }
    }
}