package com.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.biz.IStudentBiz;
import com.biz.impl.StudentBizImpl;
import com.commons.StrKit;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
private IStudentBiz sbiz = new StudentBizImpl();
	private String stuName;
	private String className;
	//private String Result;
	private JSONObject Result;
	/*//前台校验---后台校验
	@Override
	public void validate() {
		if(StrKit.isBlank(stuName)){
			this.addFieldError("stuName", "用户名不能空");
		}
		else if(stuName.length() < 6){
			this.addFieldError("stuName", "用户名不能少于6位");
		}
	}
*/

	/*public String ajaxStuName(){
		JSONObject jo = new JSONObject();
		boolean bl = sbiz.existStuName(this.getStuName());
		if(bl){
			//后台数据库中存在该用户
			jo.put("status", "exist");
		}else{
			//后台数据库中不存在该用户
			jo.put("status", "noexist");
		}
		
		this.setResult(JSON.toJSONString(jo));
		return "success";
	}*/
	
	public String ajaxStuName(){
		Result = new JSONObject();
		boolean bl = sbiz.existStuName(this.getStuName());
		if(bl){
			//后台数据库中存在该用户
			Result.put("status", "exist");
		}else{
			//后台数据库中不存在该用户
			Result.put("status", "noexist");
		}
		
		return "success";
	}
		
		public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	/*public String getResult() {
		return Result;
	}
	public void setResult(String result) {
		Result = result;
	}*/
	public String test(){
		return "success";
	}
	
	
	public JSONObject getResult() {
		return Result;
	}
	public void setResult(JSONObject result) {
		Result = result;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	
	
}
