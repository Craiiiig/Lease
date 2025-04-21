package com.atguigu.lease.common.exception;

import com.atguigu.lease.common.result.ResultCodeEnum;
import lombok.Data;

@Data
public class LeaseException extends RuntimeException {

    // Exception status code
    private Integer code;

    /**
     * Create an exception object using status code and error message
     * @param message Error message
     * @param code Status code
     */
    public LeaseException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    /**
     * Create an exception object using a response result enum object
     * @param resultCodeEnum Enum containing code and message
     */
    public LeaseException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "LeaseException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
