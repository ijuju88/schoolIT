package com.tcp;

import java.io.*;
import java.net.Socket;

public class ReceiverThread extends Thread {
	Socket s;
	ChatClientFrame ccf;
	String strTot="";
	
	public ReceiverThread(Socket s, ChatClientFrame ccf) {
		this.s = s;
		this.ccf=ccf;
	}
	
	public ReceiverThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try {
			
			BufferedReader reader = new BufferedReader(new
			InputStreamReader(s.getInputStream()));
			while(true){
				String str = reader.readLine();
				if(str==null)
				break;
				System.out.println(str);
				/*strTot+=str+"\n";
				ccf.jta.setText(strTot);*/
				}

	}catch (Exception e) {
		// TODO: handle exception
	}}
}
