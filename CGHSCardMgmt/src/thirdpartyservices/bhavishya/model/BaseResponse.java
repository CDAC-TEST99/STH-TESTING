package thirdpartyservices.bhavishya.model;

public class BaseResponse {
	
	private int statusCode;
	private String data;
	private String token;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "BaseResponse [statusCode=" + statusCode + ", data=" + data + ", token=" + token + ", message=" + message
				+ "]";
	}
	
}
