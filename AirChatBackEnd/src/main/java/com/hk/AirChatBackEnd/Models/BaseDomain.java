package com.hk.AirChatBackEnd.Models;

import javax.persistence.Transient;

public class BaseDomain 
{
	//@Transient//if there is no need to persist data ,column will not be created
	public String errorCode;
	//@Transient
	public String errorMessage;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
