package com.the_last_castle.backend.DTO.Reponse;

public class ResponDTO {
    private String code;
    private Object result;
    private String message;

    public ResponDTO(String code, Object result) {
        this.code = "SUCCESS";
        this.result = result;
    }

    public ResponDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
