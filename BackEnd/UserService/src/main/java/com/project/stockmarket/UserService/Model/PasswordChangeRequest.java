package com.project.stockmarket.UserService.Model;

public class PasswordChangeRequest {
	private String username;
	private String oldPassword;
	private String newPassword;
	private String reNewPassword;
	public PasswordChangeRequest(String username, String oldPassword, String newPassword, String reNewPassword) {
		super();
		this.username = username;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.reNewPassword = reNewPassword;
	}
	public PasswordChangeRequest() {
		
		
	}
	@Override
	public String toString() {
		return "PasswordChangeRequest [username=" + username + ", oldPassword=" + oldPassword + ", newPassword="
				+ newPassword + ", reNewPassword=" + reNewPassword + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getReNewPassword() {
		return reNewPassword;
	}
	public void setReNewPassword(String reNewPassword) {
		this.reNewPassword = reNewPassword;
	}
	
	
}
