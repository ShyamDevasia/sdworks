package com.sdworks.auth.vo;

public class MessageVO {
	
	private String message;
	private Boolean flag;
	
	public MessageVO() {
		setMessage("invalid");
		setFlag(false);
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

}
