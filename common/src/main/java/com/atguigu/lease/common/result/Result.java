package com.atguigu.lease.common.result;

import lombok.Data;

/**
 * Standardized API Response Class
 */
@Data
public class Result<T> {

    //Return code
    private Integer code;

    //Return message
    private String message;

    //Return data
    private T data;

    public Result() {
    }

    /**
     * Creates a Result object with the provided data.
     *
     * @param data the data to be set in the Result object, can be null
     * @param <T>  the type of the data
     * @return a Result object containing the data (or empty if data is null)
     */
    private static <T> Result<T> build(T data) {
        Result<T> result = new Result<>();
        if (data != null)
            result.setData(data);
        return result;
    }

    /**
     * Creates a Result object with the provided body data and result code.
     *
     * @param body           the data to be set in the Result object, can be null
     * @param resultCodeEnum the enum representing the result code and message
     * @param <T>            the type of the body data
     * @return a Result object containing the data, code, and message
     */
    public static <T> Result<T> build(T body, ResultCodeEnum resultCodeEnum) {
        Result<T> result = build(body);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }


    public static <T> Result<T> ok(T data) {
        return build(data, ResultCodeEnum.SUCCESS);
    }

    public static <T> Result<T> ok() {
        return Result.ok(null);
    }

    public static <T> Result<T> fail() {
        return build(null, ResultCodeEnum.FAIL);
    }
}
