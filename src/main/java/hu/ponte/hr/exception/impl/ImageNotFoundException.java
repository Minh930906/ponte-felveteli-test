package hu.ponte.hr.exception.impl;

import hu.ponte.hr.exception.ExceptionBase;

public enum ImageNotFoundException implements ExceptionBase {

    IMAGE_NOT_FOUND("Image could not be found.", 415);

    ImageNotFoundException(String msg, Integer code){
        this.msg = msg;
        this.code = code;
    }
    private final String msg;
    private final Integer code;

    @Override
    public String getMsg() {
            return msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
