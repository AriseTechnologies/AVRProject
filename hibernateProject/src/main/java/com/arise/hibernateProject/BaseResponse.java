package com.arise.hibernateProject;

import java.util.List;

public class BaseResponse {

	private List<Error> errList;

	public List<Error> getErrList() {
		return errList;
	}

	public void setErrList(List<Error> errList) {
		this.errList = errList;
	}
}
