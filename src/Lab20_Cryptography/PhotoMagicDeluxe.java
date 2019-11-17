package Lab20_Cryptography;

public class PhotoMagicDeluxe {

    static String base64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    public static Picture transform(Picture pic, String password, int tap) {
        StringBuffer binary = new StringBuffer();
        for (char c : password.toCharArray()) {
            String shortBinary = Integer.toBinaryString(base64.indexOf(c));
            binary.append("000000".substring(shortBinary.length()) + shortBinary);
        }
        System.out.println(binary);
        PhotoMagic.transform(pic, new LFSR(binary.toString(), tap));
        return pic;
    }

    public static void main(String[] args) {
        Picture original = new Picture("/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab20_Cryptography/mystery.png");
        original.show();
        Picture encrypted = transform(original, "OPENSESAME", 58);
        encrypted.show();
    }

}
