package com.tu.duduse.common.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResultData<T> {

    private String code;

    private String msg;

    private T data;


    public ResultData() {
        this.code = SUCCESS;
        this.msg = "操作成功";
    }

    public ResultData(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultData(T data) {
        this.code = SUCCESS;
        this.data = data;
    }

    public ResultData(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static final String SUCCESS = "1000";
    public static final String ERROR = "1100";
}
