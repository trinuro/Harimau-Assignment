/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Khiew
 */

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import org.apache.commons.codec.binary.Base64;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Properties;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.gmail.GmailScopes;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public class HarimauGmailer {

    private static final String APPLICATION_NAME = "test-project";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    public static void sendEmail(String destinationEmail, String subject, String bodyText) throws IOException, GeneralSecurityException, MessagingException {
        // Function to send email
        
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        System.out.println("1");
        InputStream inputStream = HarimauGmailer.class.getClassLoader()
                .getResourceAsStream("credentials.json");
        System.out.println(inputStream);
        System.out.println("2");
        GoogleCredentials googleCredentials = GoogleCredentials.fromStream(inputStream);
        System.out.println("3");
        HttpRequestInitializer credentials = new HttpCredentialsAdapter(googleCredentials);

        Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, credentials)
                .setApplicationName(APPLICATION_NAME)
                .build();

//        String attachmentFilePath = HarimauGmailer.class.getClassLoader()
//                .getResource("attachment.txt")
//                .getPath();

//        File file = new File(attachmentFilePath);
        final Message message = createEmail(destinationEmail, Secrets.getSenderEmail(), subject, bodyText);
        service.users().messages().send("me", message).execute();
    }

    public static Message createEmail(String toEmailAddress,
                                      String fromEmailAddress,
                                      String subject,
                                      String bodyText)
            throws MessagingException, IOException {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        MimeMessage email = new MimeMessage(session);

        email.setFrom(new InternetAddress(fromEmailAddress));
        email.addRecipient(javax.mail.Message.RecipientType.TO,
                new InternetAddress(toEmailAddress));
        email.setSubject(subject);
        email.setText(bodyText);

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
//        DataSource source = new FileDataSource(file);
//        mimeBodyPart.setDataHandler(new DataHandler(source));
//        mimeBodyPart.setFileName(file.getName());

//        Multipart multipart = new MimeMultipart();
//        multipart.addBodyPart(mimeBodyPart);
//        email.setContent(multipart);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        email.writeTo(buffer);
        byte[] rawMessageBytes = buffer.toByteArray();
        String encodedEmail = Base64.encodeBase64URLSafeString(rawMessageBytes);
        final Message message = new Message();
        message.setRaw(encodedEmail);

        return message;
    }
    public static void getRefreshToken(){
        try{
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            Credential credentials = getCredentials(HTTP_TRANSPORT);

            System.out.println(credentials.getRefreshToken());
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
        private static Credential getCredentials(final NetHttpTransport transport) throws IOException {
        AuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(transport,
                GsonFactory.getDefaultInstance(),
                Secrets.getClientID(), // Client id
                Secrets.getClientSecret(), // Client secrets
                Arrays.asList(GmailScopes.GMAIL_SEND))
                .setAccessType("offline")
                .build();

        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();

        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }
}