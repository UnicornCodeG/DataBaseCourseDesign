package com.bookmarketsys.databasejob.pojo;

public class BookDetail {
    private Integer id;

    private Integer bookId;

    private String detailImgPath;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getDetailImgPath() {
        return detailImgPath;
    }

    public void setDetailImgPath(String detailImgPath) {
        this.detailImgPath = detailImgPath == null ? null : detailImgPath.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}