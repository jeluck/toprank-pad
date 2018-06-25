package cc.toprank.byd.web.constant;

/**
 * @Description： 业务响应信息
 * @Author：LanZY
 * @Time: 2017-3-16 12:01
 * @Version 2.0.0
 */
public  class BusinessResponse {
	private int status;
	private String msg;
	private Object data = "";
	public BusinessResponse() {
		
	}
	
	public BusinessResponse(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	public BusinessResponse(int status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		if(data==null){
			this.data = "";
		}else{
			this.data = data;
		}
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		if(data==null){
			this.data = "";
		}else{
			this.data = data;
		}
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
