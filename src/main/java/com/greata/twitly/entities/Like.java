package com.greata.twitly.entities;

public class Like {
    private long id;
    private long userId;
    private long tweetId;

    public Like() {
    }

    public Like( long userId, long tweetId) {
        this.userId = userId;
        this.tweetId = tweetId;
    }

    public Like(long id, long userId, long tweetId) {
        this.id = id;
        this.userId = userId;
        this.tweetId = tweetId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTweetId() {
        return tweetId;
    }

    public void setTweetId(long tweetId) {
        this.tweetId = tweetId;
    }
}
