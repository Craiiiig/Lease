package com.atguigu.lease.common.result;

import lombok.Getter;

/**
 * Unified Response Status Information Enum
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(200, "Success"),
    FAIL(201, "Failure"),
    PARAM_ERROR(202, "Invalid Parameters"),
    SERVICE_ERROR(203, "Service Exception"),
    DATA_ERROR(204, "Data Error"),
    ILLEGAL_REQUEST(205, "Illegal Request"),
    REPEAT_SUBMIT(206, "Duplicate Submission"),
    DELETE_ERROR(207, "Please Delete Subset First"),

    ADMIN_ACCOUNT_EXIST_ERROR(301, "Account Already Exists"),
    ADMIN_CAPTCHA_CODE_ERROR(302, "Captcha Code Error"),
    ADMIN_CAPTCHA_CODE_EXPIRED(303, "Captcha Code Expired"),
    ADMIN_CAPTCHA_CODE_NOT_FOUND(304, "Captcha Code Not Provided"),

    ADMIN_LOGIN_AUTH(305, "Not Logged In"),
    ADMIN_ACCOUNT_NOT_EXIST_ERROR(306, "Account Does Not Exist"),
    ADMIN_ACCOUNT_ERROR(307, "Username or Password Incorrect"),
    ADMIN_ACCOUNT_DISABLED_ERROR(308, "Account Disabled"),
    ADMIN_ACCESS_FORBIDDEN(309, "Access Forbidden"),

    APP_LOGIN_AUTH(501, "Not Logged In"),
    APP_LOGIN_PHONE_EMPTY(502, "Phone Number is Empty"),
    APP_LOGIN_CODE_EMPTY(503, "Verification Code is Empty"),
    APP_SEND_SMS_TOO_OFTEN(504, "Verification Code Sent Too Frequently"),
    APP_LOGIN_CODE_EXPIRED(505, "Verification Code Expired"),
    APP_LOGIN_CODE_ERROR(506, "Incorrect Verification Code"),
    APP_ACCOUNT_DISABLED_ERROR(507, "Account Disabled"),

    TOKEN_EXPIRED(601, "Token Expired"),
    TOKEN_INVALID(602, "Invalid Token");

    private final Integer code;
    private final String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
