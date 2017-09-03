package com.gaurav.client;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import weblogic.wsee.security.unt.ClientUNTCredentialProvider;
import weblogic.xml.crypto.wss.provider.CredentialProvider;
import weblogic.xml.crypto.wss.WSSecurityContext;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.imageio.ImageIO;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.MTOMFeature;
import javax.xml.ws.soap.SOAPBinding;

import com.gaurav.ws.HelloWorld;

public class HelloWorldClient {
	public static void main(String[] args) throws Exception {

		URL url = new URL(
				"http://192.168.1.64:7001/HelloWorldWS/HelloWorldImplService?WSDL");

		// 1st argument service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://ws.gaurav.com/",
				"HelloWorldImplService");

		Service service = Service.create(url, qname);

		HelloWorld hello = service.getPort(HelloWorld.class);

	

		String USERNAME = "user";
		String PASSWORD = "Gaurav1986";

		BindingProvider bindingProvider = (BindingProvider) hello;
		Map<String, Object> rc = (Map<String, Object>) bindingProvider.getRequestContext();
		List<CredentialProvider> credProviders = new ArrayList<CredentialProvider>();
		credProviders.add(new ClientUNTCredentialProvider(USERNAME.getBytes(),
				PASSWORD.getBytes()));
		rc.put(WSSecurityContext.CREDENTIAL_PROVIDER_LIST, credProviders);
		rc.put(BindingProvider.USERNAME_PROPERTY, USERNAME);
		rc.put(BindingProvider.PASSWORD_PROPERTY, PASSWORD);

		System.out.println("\n\n\t-----2 credProviders: " + credProviders);
		System.out.println(hello.getHelloWorldAsString("Gausrav"));

		
		  HelloWorldClient obj = new HelloWorldClient();
		  //obj.ImageUpload(hello); obj.ImageDownload(hello);
		  
		  Image image = hello.downloadImage("anushka.jpg");
		  
		  //display it in frame 
		  JFrame frame = new JFrame(); frame.setSize(300,
		  300); JLabel label = new JLabel(new ImageIcon(image));
		 frame.add(label); frame.setVisible(true);
		  
		  //
		  System.out.println("imageServer.downloadImage() : Download Successful!"
		  );
		 

	}

	public void getWSconnection() {

	}

	public void ImageUpload(HelloWorld hello) {
		/************ test upload ****************/
		Image imgUpload;
		try {
			System.out.println(hello.getHelloWorldAsString("Gaurav"));
			imgUpload = ImageIO.read(new File("b:\\uploads\\anushka.jpg"));
			BindingProvider bp = (BindingProvider) hello;
			SOAPBinding binding = (SOAPBinding) bp.getBinding();
			binding.setMTOMEnabled(true);

			String status = hello.uploadImage(imgUpload);
			System.out.println("imageServer.uploadImage() : " + status);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// enable MTOM in client

	}

	public void ImageDownload(HelloWorld hello) {
		System.out.println(hello.getHelloWorldAsString("Gaurav"));
		Image image = hello.downloadImage("anushka.jpg");

		// display it in frame
		JFrame frame = new JFrame();
		frame.setSize(300, 300);
		JLabel label = new JLabel(new ImageIcon(image));
		frame.add(label);
		frame.setVisible(true);

		System.out
		.println("imageServer.downloadImage() : Download Successful!");

	}

}
