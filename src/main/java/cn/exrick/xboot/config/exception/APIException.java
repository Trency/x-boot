package cn.exrick.xboot.config.exception;


import cn.exrick.xboot.config.enums.IEnumError;

public class APIException extends RuntimeException {

    private IEnumError error;

    private Integer code;

    public APIException(IEnumError error) {
        super(error.getLabel());
        this.code = error.getCode();
    }

    public APIException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public APIException(Throwable throwable) {
        super(throwable.getMessage());
        this.code = 500;
    }

    public IEnumError getError() {
        return error;
    }

    public void setError(IEnumError error) {
        this.error = error;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
