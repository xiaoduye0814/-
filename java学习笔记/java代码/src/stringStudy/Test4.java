package stringStudy;

import java.util.ArrayList;
import java.util.List;


public class Test4 {
        /**数据同步 审查起诉案件*/
    /**数据同步 审查起诉案件*/
    public static final List<String> SYNC_SCQS = new ArrayList<String>() {
        private static final long serialVersionUID = 2L;
        {
            //起诉
            add("0322110101000");
            //符合刑诉法第十五条情形不起诉
            add("0322110102011");
            //批没有犯罪事实不起诉
        }
    };

    public static final String STR = "hwhw";

    public static void main(String[] args) {
        System.out.println(SYNC_SCQS.size());
        SYNC_SCQS.add("111");
        System.out.println(SYNC_SCQS.size());
    }
}
