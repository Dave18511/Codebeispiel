package org.isse.sopro.bo.MAIL;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import java.io.IOException;

public class EmailSever {


  /**
   *
   * Sends a mail with the password to email via sendgrid
   * just the example from sendgrid
   *
   * @param email
   * @param password
   * @throws IOException
   */
  public static void sendPassword(String email, String password) throws IOException {
    Email from = new Email("scherle.david@t-online.de");
    String subject = "Your new Password";
    Email to = new Email(email);
    Content content = new Content("text/plain", "Welcome, \n here is your Password for your new Acount: \n " + password);
    Mail mail = new Mail(from, subject, to, content);

    SendGrid sg = new SendGrid("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");
    Request request = new Request();
    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }

}
