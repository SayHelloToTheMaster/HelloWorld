package com.helloworld.utils;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The type Response model.
 */
@JsonPropertyOrder({"status", "message", "message_code", "data"})
public class ResponseModel {
    /**
     * The Status.
     */
    private int status;
    /**
     * The Message.
     */
    private String message;
    /**
     * The Message Code.
     */
    private String message_code;
    /**
     * The Data.
     */
    private Object data;

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     * @return the message
     */
    public ResponseModel setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Gets data.
     *
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     * @return the data
     */
    public ResponseModel setData(Object data) {
        this.data = data;
        return this;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     * @return the status
     */
    public ResponseModel setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMessage_code() {
        return message_code;
    }

    public ResponseModel setMessage_code(String message_code) {
        this.message_code = message_code;
        return this;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "ResponseModel{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", message_code='" + message_code + '\'' +
                ", data=" + data +
                '}';
    }

}

