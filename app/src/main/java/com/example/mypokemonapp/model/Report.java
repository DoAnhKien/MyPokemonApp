package com.example.mypokemonapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Report {

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
    private Integer reportCreateDate;
    @SerializedName("reportHandleDate")
    @Expose
    private Integer reportHandleDate;
    @SerializedName("reportContent")
    @Expose
    private String reportContent;
    @SerializedName("reportResult")
    @Expose
    private String reportResult;
    @SerializedName("reportStatus")
    @Expose
    private Boolean reportStatus;

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

    public Integer getReportCreateDate() {
        return reportCreateDate;
    }

    public void setReportCreateDate(Integer reportCreateDate) {
        this.reportCreateDate = reportCreateDate;
    }

    public Integer getReportHandleDate() {
        return reportHandleDate;
    }

    public void setReportHandleDate(Integer reportHandleDate) {
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

