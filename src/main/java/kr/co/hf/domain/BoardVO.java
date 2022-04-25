package kr.co.hf.domain;

import java.sql.Date;

public class BoardVO {

    private int postID;
    private String postAuthor;
    private String postTitle;
    private Date postLastModified;
    private Date postTime;
    private String postContent;
    private int viewCount;
    private int postType;
    public int getPostID() {
        return postID;
    }
    public void setPostID(int postID) {
        this.postID = postID;
    }
    public String getPostAuthor() {
        return postAuthor;
    }
    public void setPostAuthor(String postAuthor) {
        this.postAuthor = postAuthor;
    }
    public String getPostTitle() {
        return postTitle;
    }
    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }
    public Date getPostLastModified() {
        return postLastModified;
    }
    public void setPostLastModified(Date postLastModified) {
        this.postLastModified = postLastModified;
    }
    public Date getPostTime() {
        return postTime;
    }
    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }
    public String getPostContent() {
        return postContent;
    }
    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
    public int getViewCount() {
        return viewCount;
    }
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
    public int getPostType() {
        return postType;
    }
    public void setPostType(int postType) {
        this.postType = postType;
    }
    @Override
    public String toString() {
        return "BoardVO [postID=" + postID + ", postAuthor=" + postAuthor + ", postTitle=" + postTitle
                + ", postLastModified=" + postLastModified + ", postTime=" + postTime + ", postContent=" + postContent
                + ", viewCount=" + viewCount + ", postType=" + postType + "]";
    }

}