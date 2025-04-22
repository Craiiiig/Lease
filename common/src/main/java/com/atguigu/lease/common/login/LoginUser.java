package com.atguigu.lease.common.login;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginUser {

    private String username;
    private Long userId;
}
