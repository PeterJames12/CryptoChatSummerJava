package chat;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;


class Decrypt {
    static String Decrypt() throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        PrivateKey key = KeyToString.StringToKey();
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] cipherTextBytes = Base64.getDecoder().decode(Main.textToDecrypt.getBytes());
        byte[] decryptedBytes = cipher.doFinal(cipherTextBytes);
        return new String(decryptedBytes);
    }
}