package reverseserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ReverseServicer implements Runnable {

	private Socket sock;
	public ReverseServicer(Socket sock) {
		this.sock = sock;
	}

	public void run() {
		
		try {
			//�����
			InputStream in = sock.getInputStream();
			OutputStream out = sock.getOutputStream();
			// ���ͻ�ӭ��
            out.write("欢迎使用本网站的字符翻转功能".getBytes());
			//���տͻ��˷��͵���ݣ����򣬷��͸�ͻ���
			BufferedReader br = 
				new BufferedReader(new InputStreamReader(in));
			String line;
			while(true) {
				line = br.readLine();
				if("quit".equals(line))
					break;
				System.out.println(line);
				System.out.println(line.length());
				//a b d backspace c   c backspace d b a
				StringBuilder sb = new StringBuilder(line);
				sb.reverse();
				System.out.println(sb);
				out.write(sb.toString().getBytes());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				sock.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
