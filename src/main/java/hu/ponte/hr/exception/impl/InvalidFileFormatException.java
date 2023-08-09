package hu.ponte.hr.exception.impl;

import hu.ponte.hr.exception.ExceptionBase;

public enum InvalidFileFormatException implements ExceptionBase {

    INVALID_FILE_FORMAT_EXCEPTION("Invalid file was uploaded.", 415);

    InvalidFileFormatException(String msg, Integer code){
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
