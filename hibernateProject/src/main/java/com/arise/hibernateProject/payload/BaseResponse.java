package com.arise.hibernateProject.payload;

import java.util.List;

import com.arise.hibernateProject.util.Error;

public class BaseResponse {

	private List<Error> errList;

	public List<Error> getErrList() {
		return errList;
	}

	public void setErrList(List<Error> errList) {
		this.errList = errList;
	}
}
