import java.io.*;


public class Demo {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("Secret2.txt");
		FileOutputStream fos= new FileOutputStream("Secret3.txt");
		int ch;
		System.out.println("请输入密钥：");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String key = br.readLine();
		while((ch=fis.read())!=-1){
			ch=ch^Integer.valueOf(key);
			fos.write(ch);
		}
		
	}
}
