package com.inshare.concurrency.example.mp;

import lombok.Data;

import java.util.Date;

/**
 * @author Guichao
 * @since 2018/9/20
 */
@Data
public class Message {

    private long id;
    private String msg;
    private Date sendTime;
}
