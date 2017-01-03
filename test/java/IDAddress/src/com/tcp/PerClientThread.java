package com.tcp;

import java.io.*;
import java.net.*;
import java.util.*;

public class PerClientThread extends Thread {
	Socket socket;
	PrintWriter writer;
	static List<PrintWriter> list =
			Collections.synchronizedList(new ArrayList<PrintWriter>());
	public PerClientThread(Socket socket) {
		this.socket = socket;

		try {
			// 소켓의 얻어진 writer를 저장합니다.
			writer = new PrintWriter(socket.getOutputStream());
			list.add(writer);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	public void run() {
		String name = null;

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			name = reader.readLine();
			sendAll("#" + name + "님께서 채팅에 참여하였습니다.");

			while (true) {
				String str = reader.readLine();
				if (str == null) {
					break;
				}
				sendAll(name+"▶"+str);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			list.remove(writer);
			sendAll("#" + name + "님께서 채팅에서 나갔습니다.");
			
			try {
				socket.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
	}

	private void sendAll(String str) {
		for(PrintWriter writer : list){
			writer.println(str);
			writer.flush();
		}
	}

}
