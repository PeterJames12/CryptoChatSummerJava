package chat;

/**
 * @author Igor on 10/4/16.
 */
public class Together {

    static String privateKey;

    static String publicKey;

    static String cryptograma = "HALO";

    static String decrypter;

    public static void main(String[] args) throws Exception {


        privateKey = new KeyGen().generatePrivateKey();
        publicKey = new KeyGen().generatePublicKey();

        decrypter = Encrypt.EncryptText();

        Decrypt.Decrypt();

    }
}
