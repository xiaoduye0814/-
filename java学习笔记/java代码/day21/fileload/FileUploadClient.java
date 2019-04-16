package fileload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class FileUploadClient {
    public static void main(String[] args) {
        Socket ss = null;
        try {
            ss = new Socket("127.0.0.1", 5656);
            InputStream in = ss.getInputStream();
            OutputStream out = ss.getOutputStream();
            Thread.sleep(10);
            int len = in.available();
            byte[] buf = new byte[len];
            in.read(buf);
            System.out.println(new String(buf));

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    System.in));
            uploadFile(br, in, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ss != null) {
                    ss.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void uploadFile(BufferedReader br, InputStream in,
            OutputStream out) throws IOException, InterruptedException {
        String line;
        File file = null;
        while (true) {
            line = br.readLine();
            file = isValidFile(line);
            if (file != null) {
                out.write((file.getName() + "\r\n").getBytes());
                break;

            }
        }
        Thread.sleep(1000);
        int lenth = in.available();
        byte[] bufFile = new byte[1024];
        int lej = in.read(bufFile);
        boolean b = Boolean.getBoolean(new String(bufFile, 0, lej));
        System.out.println("b========" + b);
        // 如果创建文件成功,开始传流
        if (b) {
            BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream(file));
            BufferedOutputStream bos = new BufferedOutputStream(out);
            byte[] upByte = new byte[1024];
            int read;
            while ((read = bis.read(upByte)) != -1) {
                bos.write(upByte, 0, read);
                bos.flush();
            }
        }
        if (!b) {
            System.out.println("文件已经存在，请重新上传");
            uploadFile(br, in, out);
        }
    }

    private static File isValidFile(String line) {
        File file = new File(line);
        if (file.isFile()) {
            return file;
        }
        return null;
    }

}
