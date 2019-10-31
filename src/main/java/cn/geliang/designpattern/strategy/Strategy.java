package cn.geliang.designpattern.strategy;

public enum Strategy {
    NORMAL(1,"正常收费"),
    RETURN(2,"满300返100"),
    REBATE(3,"打八折")
    ;

    public final int code;
    public final String desc;

    Strategy(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
