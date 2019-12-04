package com.bookmarketsys.databasejob.pojo;

import java.util.Date;

public class BillProcess {
    private Integer id;

    private String processName;

    private Integer billId;

    private Date createTime;

    private String createOpr;

    private Date updateTime;

    private String updateOpr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName == null ? null : processName.trim();
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateOpr() {
        return createOpr;
    }

    public void setCreateOpr(String createOpr) {
        this.createOpr = createOpr == null ? null : createOpr.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateOpr() {
        return updateOpr;
    }

    public void setUpdateOpr(String updateOpr) {
        this.updateOpr = updateOpr == null ? null : updateOpr.trim();
    }
}