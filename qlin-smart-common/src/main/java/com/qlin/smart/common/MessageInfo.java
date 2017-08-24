package com.qlin.smart.common;

import java.io.Serializable;

/**
 * 作者：fangbin fangbin12@metersbonwe.com
 * 日期：2017-08-24
 * 描述：
 */

public class MessageInfo<E> implements Serializable {

    private static final long serialVersionUID = -7122226153545621086L;

    public void copyMessage(MessageInfo<?> message) {
        this.setStatus(message.getStatus());
        this.setMessage(message.getMessage());
    }

    public MessageInfo() {
        status = MessageStatus.OK.getStatus();
        message = MessageStatus.OK.getMessage();
    }

    public MessageInfo(MessageStatus messgeStatus) {
        status = messgeStatus.getStatus();
        message = messgeStatus.getMessage();
    }

    public MessageInfo(int status2, String message2) {
        this.setStatus(status2);
        this.setMessage(message2);
    }

    private String message;
    private int status;
    private E data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;

    }

    public void setStatus(int status) {
        this.status = status;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return MessageStatus.OK.getStatus() == this.status;
    }

    public void setMessageStatus(MessageStatus code, Object... args) {
        this.setStatus(code.getStatus());
        if (args.length == 0) {
            this.setMessage(code.getMessage());
        } else {
            this.setMessage(String.format(code.getMessage(), args));
        }
    }

    public void setStatusAndMessage(int statusCode, String message) {

        this.setStatus(statusCode);
        this.setMessage(message);

    }

    public static <T> MessageInfo<T> getMessage(MessageStatus code, Object... args) {
        MessageInfo<T> message = new MessageInfo<T>();
        message.setStatus(code.getStatus());
        message.setData(null);
        if (args.length == 0) {
            message.setMessage(code.getMessage());
        } else {
            message.setMessage(String.format(code.getMessage(), args));
        }
        return message;
    }

    public static <T> MessageInfo<T> getMessage(T t, MessageStatus code, Object... args) {
        MessageInfo<T> message = new MessageInfo<T>();
        message.setStatus(code.getStatus());
        message.setData(t);
        if (args.length == 0) {
            message.setMessage(code.getMessage());
        } else {
            message.setMessage(String.format(code.getMessage(), args));
        }
        return message;
    }

    public static <T> MessageInfo<T> getMessage(int code, String msg) {
        MessageInfo<T> message = new MessageInfo<T>();
        message.setStatus(code);
        message.setData(null);
        message.setMessage(msg);
        return message;
    }

    public static <T> MessageInfo<T> getMessage(T t, int code, String msg) {
        MessageInfo<T> message = new MessageInfo<T>();
        message.setStatus(code);
        message.setMessage(msg);
        message.setData(t);
        return message;
    }
}
