package com.hk.AirChatBackEnd.Models;

import javax.persistence.Transient;

public class BaseDomain 
{
	@Transient//if there is no need to persist data ,column will not be created
	public int errorCode;
	@Transient
	public String errorMessage;
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
