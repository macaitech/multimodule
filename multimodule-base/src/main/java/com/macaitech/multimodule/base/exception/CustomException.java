package com.macaitech.multimodule.base.exception;

/**
 * 自定义异常.
 * <p>
 */
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 19877735178528844L;

	protected int code = 500;

    protected ErrorCode errorCode;

    @Deprecated
    public CustomException(int code) {
        this.code = code;
    }

    //    @Deprecated
    public CustomException(int code, String message) {
        super(message);
        this.code = code;
    }

    public CustomException(Throwable cause) {
        super(cause);
    }
    
    public CustomException(int code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public CustomException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public CustomException(ErrorCode errorCode) {
        super(formatMsg(errorCode));
        this.code = errorCode.getCode();
        this.errorCode = errorCode;
    }

    public CustomException(ErrorCode errorCode, Throwable cause) {
        super(formatMsg(errorCode), cause);
        this.code = errorCode.getCode();
        this.errorCode = errorCode;
    }

    public int getCode() {
        return this.code;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final static String formatMsg(ErrorCode errorCode) {
        return String.format("%s-%s", errorCode.getCode(), errorCode.getMessage());
    }

}
