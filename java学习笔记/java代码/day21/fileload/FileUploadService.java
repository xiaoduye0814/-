package fileload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class FileUploadService implements Runnable {

    private Socket socket;
    public FileUploadService(Socket sock) {
        this.socket = sock;
    }

    public void run() {
        try {
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            out.write("欢迎光临本小站的文件上传功能, 请输入您要上传的文件名称".getBytes());

            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            System.out.println("-----------------");
                line = "E:\\upload\\" + br.readLine();
                File file = new File(line);
                boolean createMsg = file.createNewFile();
                System.out.println("===" + createMsg);
                out.write(String.valueOf(createMsg).getBytes());

                BufferedInputStream bis = new BufferedInputStream(in);
                BufferedOutputStream bos = new BufferedOutputStream(
                        new FileOutputStream(file));
                int len;
                byte[] but = new byte[1024];
                while ((len = bis.read(but)) != -1) {
                    bos.write(but, 0, len);
                    bos.flush();
                }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
