package com.lin.common;

import lombok.Data;

/**
 * @author lin
 * @version 03:21
 * @date 2023-08-25
 */
@Data
public class Result  {

    private Integer code;
    private String message;
    private Object data;
    private boolean success;
    public Result(Object data){
        this.data = data;
        this.code = 200;
        this.message = "success";
        this.success = true;
    }
    public Result(String message,Object data){
        this.data = data;
        this.code = 200;
        this.message = message;
        this.success = true;
    }

    public Result() {
        this.code = 200;
        this.message = "success";
        this.success = true;
    }

    public Result(Integer code, String message, Object data, boolean success) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.success = success;
    }
}
