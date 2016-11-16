package reserv.chat;

import java.security.*;

/**
 * author Igor
 */
public class Keys {

    private static PrivateKey privateKey;
    private static PublicKey publicKey;

    public static KeyPair keyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        privateKey = keyPair.getPrivate();
        publicKey = keyPair.getPublic();
        return null;
    }
}
