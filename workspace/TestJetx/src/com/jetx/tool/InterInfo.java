package com.jetx.tool;


import java.util.List;

public class InterInfo {
	
	String trcode = "";
	
	String desc = "";
	
	List<BodyInfo> bodys;
	
	List<BodyInfo> resp;

	public String getTrcode() {
		return trcode;
	}

	public void setTrcode(String trcode) {
		this.trcode = trcode;
	}

	public List<BodyInfo> getBodys() {
		return bodys;
	}

	public void setBodys(List<BodyInfo> bodys) {
		this.bodys = bodys;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<BodyInfo> getResp() {
		return resp;
	}

	public void setResp(List<BodyInfo> resp) {
		this.resp = resp;
	}
}
