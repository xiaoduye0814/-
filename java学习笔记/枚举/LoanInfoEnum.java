package com.cofco.graincircle.fsp.constant;

/*
 * 功能描述:t_loan_info表STATUS字段枚举
 * @author
 * @date
 * @param
 * @return
 */
public enum LoanInfoEnum {


    INITIAL_STATE("00", "初始状态"),
    PRE_APPLICATION("01", "预申请提交"),
    IN_LOAN_APPLICATION("02", "申请中"),
    SUCESS_LOAN_APPLICATION("03", "待放款"),
    IN_GRAIN_APPLICATION("04", "放款中"),
    SUCESS_GRAIN_APPLICATION("05", "已放款"),
    IN_REPAY_APPLICATION("06", "还款中"),
    SUCESS_REPAY_APPLICATION("07", "已结清"),
    IN_LOCK_HANDLE("08", "申请中"),
    FAIL("09", "失败"),
    RD("10", "熔断"),
    YQ("11", "逾期"),
    IN_UNLOCK_HANDLE("12","已失效"),
    REPAY_BYMONEY("1","用钱还"),
    REPAY_BYLOAN("2","用粮还")
    ;



    private String code;

    private String description;

    LoanInfoEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static String getMessage(String code) {
        String desc = code;
        for (LoanInfoEnum bn : values()) {
            if (code.equals(bn.getCode())) {
                desc = bn.description;
                break;
            }
        }
        return desc;
    }
}
