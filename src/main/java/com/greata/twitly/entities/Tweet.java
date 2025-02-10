package com.greata.twitly.entities;

public class Tweet {
    private long id;
    private String content;
    private long userId;
    private String createdAt;

    public Tweet() {
    }

    public Tweet(long userId, String content, String createdAt) {
        this.userId = userId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Tweet(long id,long userId, String content, String createdAt) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
