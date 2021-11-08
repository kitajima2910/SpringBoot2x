package com.hoaipx.learn2021.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PXHException extends RuntimeException {

    private String msg;
    private String messCode;

    public PXHException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public PXHException(String msg, String messCode) {
        super(msg);
        this.msg = msg;
        this.messCode = messCode;
    }

}
