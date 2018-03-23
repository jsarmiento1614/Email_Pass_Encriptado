/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author Jsarmiento
 */
public class SendMail {
    
    public void enviar(String email){
    Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
                String asunto="AVISO: Jsarmiento - Se ha evitado un inicio de sesión sospechoso.";
                String descripcion="Alertas de actividad de inicio de sesión sospechosa.\n\n "
                        + "Para poder minimizar los daños de un acceso no autorizado a tu cuenta, JSarmiento te envía un correo electrónico o un mensaje de texto cuando se detecta un intento de inicio de sesión sospechoso."
                        + "\n\nSi no eres tu el que intento iniciar sesion te recomendamos modifiques tu contraseña.\n\n\n\n\n\n"
                        + "Att. Sistema Seguridad JSarmeinto©";
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
                                @Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("jsarmiento.proyects@gmail.com","jsarmientoxrl15");
				}
			});

		try {
                            Message message = new MimeMessage(session);
                            message.setFrom(new InternetAddress(email));
                            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                            message.setSubject(asunto);
                            message.setText(descripcion);
                            Transport.send(message);                 
                //Regreso a la clase perfil.
                        System.out.println();
                        System.exit(0);

		} catch (MessagingException e) {
			System.out.println("\nHa sucedido Algo...");
		}
    
    }
    
}