package com.greata.twitly.entities;

public class Follow {
    private long followerId;
    private long followingId;

    public Follow(long followerId, long followingId) {
        this.followerId = followerId;
        this.followingId = followingId;
    }

    public long getFollowerId() {
        return followerId;
    }
    public long getFollowingId() {
        return followingId;
    }

    public void setFollowerId(long followerId) {
        this.followerId = followerId;
    }
    public void setFollowingId(long followingId) {
        this.followingId = followingId;
    }
}
