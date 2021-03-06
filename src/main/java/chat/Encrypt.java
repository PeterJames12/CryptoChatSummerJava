package chat;

import javax.crypto.Cipher;
import java.security.PublicKey;
import java.util.Base64;


class Encrypt {

    static String EncryptText() throws Exception {

        Cipher cipher = Cipher.getInstance("RSA");
        PublicKey key = KeyToString.StringPubKey();
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(Together.cryptograma.getBytes());
        return new String(Base64.getEncoder().encode(encryptedBytes));
    }
}