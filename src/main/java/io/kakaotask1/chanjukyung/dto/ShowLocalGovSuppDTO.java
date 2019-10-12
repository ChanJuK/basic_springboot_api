package io.kakaotask1.chanjukyung.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShowLocalGovSuppDTO {
	
	//구분,지자체명(기관명),지원대상,용도,지원한도,이차보전,추천기관,관리점,취급점
	@Id
	private String region;
	private String target;
	private String useage;
	private String limit;
	private String rate;
	private String institute;
	private String mgmt;
	private String reception;
	
	
	public ShowLocalGovSuppDTO() {
	}
	
	
	

	public ShowLocalGovSuppDTO(String region, String target, String useage, String limit, String minrate,
			String rate, String institute, String mgmt, String reception) {
		super();
		this.region = region;
		this.target = target;
		this.useage = useage;
		this.limit = limit;
		this.rate = rate;
		this.institute = institute;
		this.mgmt = mgmt;
		this.reception = reception;
	}




	public String getRegion() {
		return region;
	}


	public void setRegionCode(String region) {
		this.region = region;
	}


	public String getTarget() {
		return target;
	}


	public void setTarget(String target) {
		this.target = target;
	}


	public String getUseage() {
		return useage;
	}


	public void setUseage(String useage) {
		this.useage = useage;
	}


	public String getLimit() {
		return limit;
	}


	public void setLimit(String limit) {
		this.limit = limit;
	}


	public String getRate() {
		return rate;
	}


	public void setRate(String rate) {
		this.rate = rate;
	}


	public String getInstitute() {
		return institute;
	}


	public void setInstitute(String institute) {
		this.institute = institute;
	}


	public String getMgmt() {
		return mgmt;
	}


	public void setMgmt(String mgmt) {
		this.mgmt = mgmt;
	}


	public String getReception() {
		return reception;
	}


	public void setReception(String reception) {
		this.reception = reception;
	}


	@Override
	public String toString() {
		return "UploadCSV [region=" + region + ", target=" + target + ", useage=" + useage
				+ ", limit=" + limit + ", rate=" + rate + ", institute=" + institute
				+ ", mgmt=" + mgmt + ", reception=" + reception + "]";
	}

	
	


	
	
	
	
	
	
}
