package reverseserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ReverseServer {

	/**
	 * �����������ṩ�ַ���
	 */
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			//����������������˿�
			ss = new ServerSocket(6999);
			while(true) {
				//�ȴ��û�����������
				Socket sock = ss.accept();
				//�����̣߳��ṩ����
				new Thread(new ReverseServicer(sock)).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ss!=null)
					ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
