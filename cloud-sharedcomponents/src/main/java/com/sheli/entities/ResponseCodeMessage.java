package com.sheli.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCodeMessage<T> {
    private Integer code;
    private String message;
    private T data;

    public ResponseCodeMessage(Integer code, String message) {
        this(code, message, null);
    }
}
