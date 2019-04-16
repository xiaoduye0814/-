

/**
 * 
 * @author Administrator
 *
 */
public enum TestEnum {

    ONLINE_STATE_ZERO("00", "在线0"), ONLINE_STATE_ONE("01", "在线1"), ONLINE_STATE_TWO(
            "02", "在线2"), ONLINE_STATE_THREE("03", "在线3");

    private String code;

    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    TestEnum(String code, String description) {
        this.code = code;
        this.description = description;

    }

    public static String getMessage(String code) {
        String desc = code;
        for (TestEnum bn : values()) {
            if (code.equals(bn.getCode())) {
                desc = bn.getDescription();

            }
        }
        return desc;
    }

    public static void main(String[] args) {
        System.out.println(TestEnum.getMessage("0981"));
    }
}
