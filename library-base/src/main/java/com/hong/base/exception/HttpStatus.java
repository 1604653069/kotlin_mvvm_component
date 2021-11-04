package com.hong.base.exception;

/**
 * 网路状态类
 */
public class HttpStatus {
    private boolean success;
    //网络状态码
    private int errorCode;
    //网络状态信息
    private String errorMsg;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public boolean isSuccess() {
        return success;
    }

    /**
 * API是否请求失败
 *
 * @return 失败返回true, 成功返回false
 */
    public boolean isCodeInvalid() {
        return errorCode==0;
    }


}