package com.ejie.nbrs.entity;

/**
 * 
 * ClassName:Account 账户实体
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017 2017年7月14日 下午5:55:21
 * @see
 */
public class LoginAccount {

  private String userName;

  private String password;

  // 验证码
  private String verificationCode;
  //修改密码
  private String repassword;

  
public String getRepassword() {
	return repassword;
}


public void setRepassword(String repassword) {
	this.repassword = repassword;
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "LoginAccount [userName=" + userName + ", password=" + password
			+ ", verificationCode=" + verificationCode + ", repassword="
			+ repassword + "]";
}

  /* 以下是getter setter */

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName == null ? null : userName.trim();
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password == null ? null : password.trim();
  }


  public String getVerificationCode() {
    return verificationCode;
  }

  public void setVerificationCode(String verificationCode) {
    this.verificationCode = verificationCode;
  }
}
