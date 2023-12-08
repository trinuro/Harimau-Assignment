///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//
///**
// *
// * @author Khiew
// */
//import com.google.api.client.auth.oauth2.Credential;
//import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
//import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
//import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.googleapis.json.GoogleJsonError;
//import com.google.api.client.googleapis.json.GoogleJsonResponseException;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.gson.GsonFactory;
//import com.google.api.client.util.store.FileDataStoreFactory;
//import com.google.api.services.gmail.Gmail;
//import com.google.api.services.gmail.model.Message;
//import org.apache.commons.codec.binary.Base64;
//
//import javax.mail.Session;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.nio.file.Paths;
//import java.util.Properties;
//import java.util.Set;
//
//import static com.google.api.services.gmail.GmailScopes.GMAIL_SEND;
//import static javax.mail.Message.RecipientType.TO;
//
//public class HarimauGmailer {
//    private final Gmail service;
//
//    public HarimauGmailer() throws Exception {
//        NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
//        GsonFactory jsonFactory = GsonFactory.getDefaultInstance();
//        service = new Gmail.Builder(httpTransport, jsonFactory, getCredentials(httpTransport, jsonFactory))
//                .setApplicationName("Test Mailer")
//                .build();
//    }
//
////    private static Credential getCredentials(final NetHttpTransport httpTransport, GsonFactory jsonFactory)
////            throws IOException {
////        // Set path to your secret JSON
////        System.out.println("1");
////        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory, new InputStreamReader(HarimauGmailer.class.getResourceAsStream(Secrets.getJSON())));
////        System.out.println("2");
////        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
////                httpTransport, jsonFactory, clientSecrets, Set.of(GMAIL_SEND))
////                .setDataStoreFactory(new FileDataStoreFactory(Paths.get("tokens").toFile()))
////                .setAccessType("offline")
////                .build();
////
////        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
////        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
////    }
//
//    public void sendMail(String sender_email, String recipient_email, String subject, String message) throws Exception {
//        Properties props = new Properties();
//        Session session = Session.getDefaultInstance(props, null);
//        MimeMessage email = new MimeMessage(session);
//        email.setFrom(new InternetAddress(sender_email));
//        // Set recipient email
//        email.addRecipient(TO, new InternetAddress(recipient_email));
//        email.setSubject(subject);
//        email.setText(message);
//
//        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//        email.writeTo(buffer);
//        byte[] rawMessageBytes = buffer.toByteArray();
//        String encodedEmail = Base64.encodeBase64URLSafeString(rawMessageBytes);
//        Message msg = new Message();
//        msg.setRaw(encodedEmail);
//
//        try {
//            msg = service.users().messages().send("me", msg).execute();
//            System.out.println("Message id: " + msg.getId());
//            System.out.println(msg.toPrettyString());
//        } catch (GoogleJsonResponseException e) {
//            GoogleJsonError error = e.getDetails();
//            if (error.getCode() == 403) {
//                System.err.println("Unable to send message: " + e.getDetails());
//            } else {
//                throw e;
//            }
//        }
//    }
//}
