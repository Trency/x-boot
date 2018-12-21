package cn.exrick.xboot.config.enums;

public enum EnumHttp403Error implements IEnumError {

    CANSHU_IS_NULL(403001, "参数为空"),
    CANSHU_IS_ERROR(403002, "参数不正确"),
    USER_NOT_FOUND(403003, "无此用户"),
    USER_PASSWORD_ERROR(403004, "密码错误"),
    USER_CELLPHONE_FOUND(403005, "您的手机号已注册"),
    USER_NOT_PRODUCT(403006, "无此贷款产品"),
    LIMIT_ERRO(403007, "额度不够"),
    ALIPAY_IS_NULL(403008, "支付宝为空"),
    LEND_IS_NULL(403009, "无此贷款订单"),
    EXAMINESTATUS_IS_ERROR(403010, "审核状态错误"),
    REPAYMENTSTATUS_IS_ERROR(403011, "还款状态错误"),
    LENDORDERSTATU_IS_ERROR(403012, "贷款订单状态错误"),
    HAS_ALIPAYACCOUNT(403013, "支付宝账号已存在"),
    IDCARD_IS_NULL(403014, "身份证号为空"),
    IDCARDNOBACKPHOTO_IS_NULL(403015, "身份证反面为空"),
    IDCARDNOFRONTPHOTO_IS_NULL(403016, "身份证正面面为空"),
    SCHOOL_IS_NULL(403017, "学校为空"),
    STUDENTNUMBER_IS_NULL(403018, "学号为空"),
    TOKEN_NOT_CAN(403019, "token值不正确"),
    NOT_LOGIN(403020, "未登录"),
    ACTIVITY_NOT_EXIST(403021, "活动不存在"),
    MSG_SEND_ERROR(403022, "验证码发送过于频繁,请稍后请求验证码"),
    VALIDATECODE__EXPIRED(403022, "短信验证码已过期或未发送过验证码"),
    SMS_VCODE_ERROR(403023, "短信验证码错误"),
    INCOMPLETE_INFORMATION(403024, "贷款资料提供不全"),
    PAYMENTSTATUS_IS_ERROR(403025, "放款状态错误"),


    ;


    private Integer code;
    private String label;

    EnumHttp403Error(Integer code, String label) {
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
