package com.example.mypokemonapp.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FeedBack implements Serializable {

    @SerializedName("feedBackId")
    @Expose
    private Integer feedBackId;
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("feedBackDate")
    @Expose
    private String feedBackDate;
    @SerializedName("feedBackContent")
    @Expose
    private String feedBackContent;
    @SerializedName("isHandle")
    @Expose
    private boolean isHandle;


    public FeedBack() {
    }

    public FeedBack(Integer feedBackId, Integer userId, String feedBackDate, String feedBackContent, boolean isHandle) {
        this.feedBackId = feedBackId;
        this.userId = userId;
        this.feedBackDate = feedBackDate;
        this.feedBackContent = feedBackContent;
        this.isHandle = isHandle;
    }

    public Integer getFeedBackId() {
        return feedBackId;
    }

    public void setFeedBackId(Integer feedBackId) {
        this.feedBackId = feedBackId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFeedBackDate() {
        return feedBackDate;
    }

    public void setFeedBackDate(String feedBackDate) {
        this.feedBackDate = feedBackDate;
    }

    public String getFeedBackContent() {
        return feedBackContent;
    }

    public void setFeedBackContent(String feedBackContent) {
        this.feedBackContent = feedBackContent;
    }

    public boolean isHandle() {
        return isHandle;
    }

    public void setHandle(boolean handle) {
        isHandle = handle;
    }
}