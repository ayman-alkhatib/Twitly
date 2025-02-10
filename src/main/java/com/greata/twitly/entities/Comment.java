package com.greata.twitly.entities;

public class Comment {
    private long id;
    private long tweetId;
    private long userId;
    private String content;

    public Comment( ) {
    }

    public Comment( long tweetId, String content, long userId) {
        this.tweetId = tweetId;
        this.content = content;
        this.userId = userId;
    }

    public Comment(long id, long tweetId, String content, long userId) {
        this.id = id;
        this.tweetId = tweetId;
        this.content = content;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTweetId() {
        return tweetId;
    }

    public void setTweetId(long tweetId) {
        this.tweetId = tweetId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
