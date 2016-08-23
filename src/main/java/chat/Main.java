package chat;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.math.BigInteger;
import java.util.Properties;
import java.util.Scanner;


public class Main {

    private static Scanner scanner = new Scanner(System.in);
    static String encryptedText;
    static String publicKeys1;
    static String textToDecrypt;
    static String privateKeyString;
    private static String cryptoMessage;

    static final private String FROMEMAIL = "summerjava570@gmail.com";
    static final private String MYPASS = "Cryptography";
    static private Properties props;

    public static void main(String[] args) throws Exception {

        new Main().start();
    }

    private void start() {

        hello();
        selectChoice();
    }

    private static void hello() {

        System.out.println("              Crypto Chat          ");
        System.out.println(1 + " " + "crypt");
        System.out.println(2 + " " + "decrypt");
        System.out.println(3 + " " + "send to email");
        System.out.println(4 + " " + "Open key generator");
        System.out.println(5 + " " + "exit");
    }

    private void selectChoice() {

        switch (scanner.nextInt()) {
            case 1:
                System.out.println("enter your message");
                encryptedText = scanner.next();
                System.out.println("enter ur public key");
                publicKeys1 = scanner.next();
                publicKeys1.replaceAll("[\\s]{2,}", " ");
                try {
                    cryptoMessage = Encrypt.EncryptText();
                    System.out.println("encrypted  = " + cryptoMessage);
                } catch (Exception e) {
                    System.out.println("something went wrong please try again");
                    start();
                }
                start();
                break;
            case 2:
                System.out.println("enter ur crypt message");
                textToDecrypt = scanner.next();
                System.out.println("enter ur private key");
                privateKeyString = scanner.next();
                privateKeyString.replaceAll("[\\s]{2,}", " ");
                try {
                    System.out.println("decrypted  = " + Decrypt.Decrypt());
                } catch (Exception e) {
                    System.out.println("something went wrong please try again");
                    start();
                }
                start();
            case 3:
                System.out.println("please enter ur email");
                String toEmail = scanner.next();
                send("Crypto Message", toEmail);
                start();
                break;
            case 4:
                try {
                    KeyGen.keyGen();
                } catch (Exception e) {
                    System.out.println("something went wrong please try again");
                    start();
                }
                start();
                break;
            case 5:
                break;
            default:
                System.out.println("wrong choice please try again");
                start();
                break;
        }
    }

    private void send(String subject, String toEmail) {

        createProps();

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROMEMAIL, MYPASS);
            }
        });

        try {
            Message message = new MimeMessage(session);
            //від кого
            message.setFrom(new InternetAddress(FROMEMAIL));
            //кому
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            //тема
            message.setSubject(subject);
            //текст
            message.setText(cryptoMessage);
            //відправка
            Transport.send(message);
            System.out.println("ur message sent");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createProps() {
        props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
    }
}