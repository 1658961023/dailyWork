package com.jetx.tool;
import java.util.List;

public class BodyInfo {
	
	String name = "";
	
	String type = "";
	
	String attr = "";
	
	String generictype = "";
	
	DtoInfo dto;
	
	List<DtoInfo> dtolist;
	
	List<String> lists;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAttr() {
		return attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public DtoInfo getDto() {
		return dto;
	}

	public void setDto(DtoInfo dto) {
		this.dto = dto;
	}

	public List<DtoInfo> getDtolist() {
		return dtolist;
	}

	public void setDtolist(List<DtoInfo> dtolist) {
		this.dtolist = dtolist;
	}

	public List<String> getLists() {
		return lists;
	}

	public void setLists(List<String> lists) {
		this.lists = lists;
	}

	public String getGenerictype() {
		return generictype;
	}

	public void setGenerictype(String generictype) {
		this.generictype = generictype;
	}
}
