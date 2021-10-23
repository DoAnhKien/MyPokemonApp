package com.example.mypokemonapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Report implements Serializable {

    @SerializedName("reportId")
    @Expose
    private Integer reportId;
    @SerializedName("adminId")
    @Expose
    private Integer adminId;
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("reportCreateDate")
    @Expose
    private String reportCreateDate;
    @SerializedName("reportHandleDate")
    @Expose
    private String reportHandleDate;
    @SerializedName("reportContent")
    @Expose
    private String reportContent;
    @SerializedName("reportResult")
    @Expose
    private String reportResult;
    @SerializedName("reportStatus")
    @Expose
    private Boolean reportStatus;


    public Report() {
    }

    public Report(Integer reportId, Integer adminId, Integer userId, String reportCreateDate, String reportHandleDate, String reportContent, String reportResult, Boolean reportStatus) {
        this.reportId = reportId;
        this.adminId = adminId;
        this.userId = userId;
        this.reportCreateDate = reportCreateDate;
        this.reportHandleDate = reportHandleDate;
        this.reportContent = reportContent;
        this.reportResult = reportResult;
        this.reportStatus = reportStatus;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReportCreateDate() {
        return reportCreateDate;
    }

    public void setReportCreateDate(String reportCreateDate) {
        this.reportCreateDate = reportCreateDate;
    }

    public String getReportHandleDate() {
        return reportHandleDate;
    }

    public void setReportHandleDate(String reportHandleDate) {
        this.reportHandleDate = reportHandleDate;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public String getReportResult() {
        return reportResult;
    }

    public void setReportResult(String reportResult) {
        this.reportResult = reportResult;
    }

    public Boolean getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Boolean reportStatus) {
        this.reportStatus = reportStatus;
    }
}

