package Lab20_Cryptography;

import java.awt.*;

public class PhotoMagic {

    public static void main(String[] args) {
        Picture original = new Picture("/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab20_Cryptography/pipe.png");
        original.show();
        Picture encrypted = transform(original, new LFSR("01101000010100010000", 16));
        encrypted.show();
    }

    public static Picture transform(Picture pic, LFSR lfsr) {
        Picture encoded = new Picture("/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab20_Cryptography/pipe.png");
        for (int r = 0; r < pic.height(); r++) {
            for (int c = 0; c < pic.width(); c++) {
                Color color = pic.get(c, r);
                Color transformed = new Color(color.getRed() ^ lfsr.generate(8), color.getGreen() ^ lfsr.generate(8), color.getBlue() ^ lfsr.generate(8));
                encoded.set(c, r, transformed);
            }
        }
        return encoded;
    }

}
