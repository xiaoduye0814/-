package baozhuang;

import java.io.IOException;
import java.io.Reader;

public class MyLineNumberReader extends MyBufferedReader {

    private int lineNum;

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public MyLineNumberReader(Reader r) {
        super(r);
    }
    
    public String readLine() throws IOException {
        lineNum++;
        return super.readLine();
    }

}
