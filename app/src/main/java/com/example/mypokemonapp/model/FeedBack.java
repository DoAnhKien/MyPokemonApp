package com.example.mypokemonapp.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeedBack {

    @SerializedName("feedBackId")
    @Expose
    private Integer feedBackId;
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("feedBackDate")
    @Expose
    private Integer feedBackDate;
    @SerializedName("feedBackContent")
    @Expose
    private String feedBackContent;

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

    public Integer getFeedBackDate() {
        return feedBackDate;
    }

    public void setFeedBackDate(Integer feedBackDate) {
        this.feedBackDate = feedBackDate;
    }

    public String getFeedBackContent() {
        return feedBackContent;
    }

    public void setFeedBackContent(String feedBackContent) {
        this.feedBackContent = feedBackContent;
    }

}