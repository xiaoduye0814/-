package reverseserver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ReverseClient {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws UnknownHostException 
	
	 */
	public static void main(String args[]) throws Exception {
		Socket sock = new Socket("127.0.0.1", 6999);
		//�����
		InputStream in = sock.getInputStream();
		OutputStream out = sock.getOutputStream();
		//���ջ�ӭ��
		Thread.sleep(10);
		int len = in.available();
		byte[] buf = new byte[len];
		in.read(buf);
		System.out.println(new String(buf));
		//�����̣��������
		BufferedReader br = 
			new BufferedReader(new InputStreamReader(System.in));
		String line;
		while(true) {
			line = br.readLine();
			out.write((line+"\r\n").getBytes());
			if("quit".equals(line))
				break;
			Thread.sleep(10);
			len = in.available();
			buf = new byte[len];
			in.read(buf);
			System.out.println(new String(buf));
		}
		sock.close();
	}
	

}
