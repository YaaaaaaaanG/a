package com.qf.common;

import lombok.Data;

@Data
public class BaseResult {

    private Integer code;

    private String message;

    private Object data;

    private Long total;
}
