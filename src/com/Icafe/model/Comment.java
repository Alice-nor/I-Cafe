package com.Icafe.model;

public class Comment {

	protected int c_id; //留言編號（顧客與管理者共用）
	protected String name; //顧客姓名
	protected String email; //顧客信箱
	protected String comment; //留言內容
	protected String published_at; //留言發布日期
	
	protected String m_name; //管理者姓名
	protected String replyComment; //管理者回覆內容
	protected String ry_published_at; //留言回覆發佈時間
	
	public Comment(int c_id, String name, String email, String comment, String published_at, String m_name,
			String replyComment, String ry_published_at) {
		super();
		this.c_id = c_id;
		this.name = name;
		this.email = email;
		this.comment = comment;
		this.published_at = published_at;
		this.m_name = m_name;
		this.replyComment = replyComment;
		this.ry_published_at = ry_published_at;
	}
	
	public Comment(String name, String email, String comment, String published_at, String m_name,
			String replyComment, String ry_published_at) {
		super();
		this.name = name;
		this.email = email;
		this.comment = comment;
		this.published_at = published_at;
		this.m_name = m_name;
		this.replyComment = replyComment;
		this.ry_published_at = ry_published_at;
	}

	//顧客輸入
	public Comment(String name, String email, String comment, String published_at) {
		super();
		this.name = name;
		this.email = email;
		this.comment = comment;
		this.published_at = published_at;
	}
	
	//管理者輸入
	public Comment(String m_name,String replyComment, String ry_published_at) {
		super();
		this.m_name = m_name;
		this.replyComment = replyComment;
		this.ry_published_at = ry_published_at;
	}
	
	
	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getPublished_at() {
		return published_at;
	}

	public void setPublished_at(String published_at) {
		this.published_at = published_at;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getReplyComment() {
		return replyComment;
	}

	public void setReplyComment(String replyComment) {
		this.replyComment = replyComment;
	}

	public String getRy_published_at() {
		return ry_published_at;
	}

	public void setRy_published_at(String ry_published_at) {
		this.ry_published_at = ry_published_at;
	}
	
	
	
	
}
