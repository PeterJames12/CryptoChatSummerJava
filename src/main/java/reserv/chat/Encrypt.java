package reserv.chat;

import javax.crypto.Cipher;
import java.security.PublicKey;
import java.util.Base64;


class Encrypt {

    private static String textEc = Main.encryptedText;

    static String EncryptText() throws Exception {

        Cipher cipher = Cipher.getInstance("RSA");
        PublicKey key = KeyToString.StringPubKey();
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(textEc.getBytes());
        return new String(Base64.getEncoder().encode(encryptedBytes));
    }
}