package kr.co.hf.domain;

public class PreviewVO {
	private int previewID;
	private int postID;
	private String previewContent;
	private String previewLink;
	
	
	@Override
	public String toString() {
		return "PreviewVO [previewID=" + previewID + ", postID=" + postID + ", previewContent=" + previewContent
				+ ", previewLink=" + previewLink + "]";
	}


	public int getPreviewID() {
		return previewID;
	}


	public void setPreviewID(int previewID) {
		this.previewID = previewID;
	}


	public int getPostID() {
		return postID;
	}


	public void setPostID(int postID) {
		this.postID = postID;
	}


	public String getPreviewContent() {
		return previewContent;
	}


	public void setPreviewContent(String previewContent) {
		this.previewContent = previewContent;
	}


	public String getPreviewLink() {
		return previewLink;
	}


	public void setPreviewLink(String previewLink) {
		this.previewLink = previewLink;
	}
	
	
	
	
}
