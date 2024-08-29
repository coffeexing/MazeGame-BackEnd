package com.xingclay.mazegame.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String massage;
    private T data;

    public static Result success() {
        return new Result(200, "success", null);
    }

    public static Result success(String message) {
        return new Result(200, message, null);
    }

    //查询 成功响应
    public static <E> Result<E> success(E data) {
        return new Result(200, "success", data);
    }

    public static <E> Result<E> success(String message, E data) {
        return new Result(200, message, data);
    }

    //失败响应
    public static Result error(int code, String message) {
        return new Result(code, message, null);
    }
}

