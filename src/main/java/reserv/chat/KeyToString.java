package reserv.chat;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

class KeyToString {

    static PrivateKey StringToKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
        String PrivateKeys = Main.privateKeyString;
        byte [] encoded = Base64.getDecoder().decode(PrivateKeys);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(keySpec);
    }
    static PublicKey StringPubKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
        String PublicKeys = Main.publicKeys1;
        byte [] encoded = Base64.getDecoder().decode(PublicKeys);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(keySpec);
    }
}