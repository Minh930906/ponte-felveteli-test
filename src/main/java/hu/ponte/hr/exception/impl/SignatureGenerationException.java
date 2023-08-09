package hu.ponte.hr.exception.impl;

import hu.ponte.hr.exception.ExceptionBase;

public enum SignatureGenerationException implements ExceptionBase {

    SIGNATURE_EXCEPTION("Error with generating signature.", 501);

    SignatureGenerationException(String msg, Integer code){
        this.msg = msg;
        this.code = code;
    }
    private final String msg;
    private final Integer code;

    @Override
    public String getMsg() {
        return null;
    }

    @Override
    public Integer getCode() {
        return null;
    }
}
