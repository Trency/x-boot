package cn.exrick.xboot.config.enums;

public enum EnumHttp401Error implements IEnumError {

    NEED_LOGIN(401001, "请先登录"),

    LOGIN_EXPIRED(401002, "登录过期，请重新登录"),

    TOKEN_EXPIRED(401003, "token失效"),

    ;


    private Integer code;
    private String label;

    EnumHttp401Error(Integer code, String label) {
        this.code = code;
        this.label = label;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getLabel() {
        return this.label;
    }
}
