package bici.gui;


import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import static bici.gui.CostantiGUI.*;
import static java.awt.Color.WHITE;

public class LettoreImmagini {

	static public Image leggiImmagineMattone() {
		return leggiImmagine(RISORSA_IMMAGINE_MATTONE);
	}
	static public Image leggiImmagineBici(Color color) {
		return leggImmagineRicolorata(RISORSA_IMMAGINE_BICI, color);		
	}
		
	static private Image leggiImmagine(String imagefilename) {
		try {
			return  ImageIO.read(new File(imagefilename));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	static private BufferedImage ricoloraImmagine(BufferedImage image, Color vecchio, Color nuovo) {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color originale = new Color(image.getRGB(x, y),true);
                if (originale.equals(vecchio)) {
                    image.setRGB(x, y, nuovo.getRGB());
                }
            }
        }
        return image;
    }

	static private Image leggImmagineRicolorata(String imagefilename, Color nuovo) {
		final BufferedImage image = (BufferedImage)leggiImmagine(imagefilename);
		return ricoloraImmagine(image, WHITE, nuovo);
	}

}
