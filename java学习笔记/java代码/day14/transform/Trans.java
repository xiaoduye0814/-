package transform;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Trans {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                System.out));
        try {
            String line;
            while (true) {
                line = br.readLine();
                bw.write(line);
                bw.newLine();
                bw.flush();
                if ("bye".equals(line)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                CloseUtil.close(null, null, br, bw);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
