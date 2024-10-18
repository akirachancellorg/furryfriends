package com.entjava.furryfriends.model;

public class ApiResponse<T> {
    private T data; // Move the data field above
    private String username; // Keep the username at the bottom

    public ApiResponse(T data, String username) { // Constructor order is important
        this.data = data;
        this.username = username;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}