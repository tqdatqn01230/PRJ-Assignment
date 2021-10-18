/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattq.sendfile;

import dattq.sendfile.Action;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
/**
 *
 * @author Administrator
 */
public class Entry {
    public static void main(String[] args){
        Entry a=new Entry();
        a.sendmail("tqdatqn01230@gmail.com", "khong co code");
    }
    public void sendmail(String mail,String code){
        Session sess = Action.Login("dattqse150059@fpt.edu.vn", "NgocThieu7");
        SendMail sender = new SendMail(sess);
        String[] list1={mail};
        String[] list2=null;
        String[] list3=null;
        sender.sendEmail(list1,list2,list3,"Your code is: "+code, "", "We from PorHub, We send you verified code");
    }
}
