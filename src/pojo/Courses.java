package pojo;

import java.util.List;

public class Courses<webAutomation> {
	
	private List<webAutomation> webAutomation ;
	private List<Api> Api ;
	private List<Mobile> Mobile ;
	
	public List<webAutomation> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<webAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<pojo.Api> getApi() {
		return Api;
	}
	public void setApi(List<pojo.Api> api) {
		Api = api;
	}
	public List<pojo.Mobile> getMobile() {
		return Mobile;
	}
	public void setMobile(Mobile mobile) {
		Mobile = (List<pojo.Mobile>) mobile;
	}


	
}
