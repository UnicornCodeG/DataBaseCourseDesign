package com.bookmarketsys.databasejob.pojo;

import java.util.Date;

public class Book {
    private Integer id;

    private String name;

    private String author;

    private String press;

    private String translationAuthor;

    private String type;

    private Integer menuId;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    public String getTranslationAuthor() {
        return translationAuthor;
    }

    public void setTranslationAuthor(String translationAuthor) {
        this.translationAuthor = translationAuthor == null ? null : translationAuthor.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
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