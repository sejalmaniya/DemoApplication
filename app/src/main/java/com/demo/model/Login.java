package com.demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by DeLL on 16-12-2017.
 */

public class Login {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("data")
    @Expose
    private List<LoginDatum> data = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<LoginDatum> getData() {
        return data;
    }

    public void setData(List<LoginDatum> data) {
        this.data = data;
    }


}
