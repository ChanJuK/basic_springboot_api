package io.kakaotask1.chanjukyung.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UploadCSV")
public class SuppInfo {
	
	//구분,지자체명(기관명),지원대상,용도,지원한도,이차보전,추천기관,관리점,취급점
	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "region_code")
	private String regionCode;
	@Column(name = "target")
	private String target;
	@Column(name = "useage")
	private String useage;
	@Column(name = "limit")
	private BigDecimal limit;
	@Column(name = "minrate")
	private BigDecimal minrate;
	@Column(name = "maxrate")
	private BigDecimal maxrate;
	@Column(name = "institute")
	private String institute;
	@Column(name = "mgmt")
	private String mgmt;
	@Column(name = "reception")
	private String reception;
	
	@Column(name = "rgst_dt")
	private String rgstDt;
	@Column(name = "upd_dt")
	private String updDt;
	
	
	
	public SuppInfo() {
	}






	public SuppInfo(String id, String regionCode, String target, String useage, BigDecimal limit, BigDecimal minrate,
			BigDecimal maxrate, String institute, String mgmt, String reception, String rgstDt, String updDt) {
		super();
		this.id = id;
		this.regionCode = regionCode;
		this.target = target;
		this.useage = useage;
		this.limit = limit;
		this.minrate = minrate;
		this.maxrate = maxrate;
		this.institute = institute;
		this.mgmt = mgmt;
		this.reception = reception;
		this.rgstDt = rgstDt;
		this.updDt = updDt;
	}






	public String getId() {
		return id;
	}






	public void setId(String id) {
		this.id = id;
	}






	public String getRegionCode() {
		return regionCode;
	}






	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
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






	public BigDecimal getLimit() {
		return limit;
	}






	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}






	public BigDecimal getMinrate() {
		return minrate;
	}






	public void setMinrate(BigDecimal minrate) {
		this.minrate = minrate;
	}






	public BigDecimal getMaxrate() {
		return maxrate;
	}






	public void setMaxrate(BigDecimal maxrate) {
		this.maxrate = maxrate;
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






	public String getRgstDt() {
		return rgstDt;
	}






	public void setRgstDt(String rgstDt) {
		this.rgstDt = rgstDt;
	}






	public String getUpdDt() {
		return updDt;
	}






	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}






	@Override
	public String toString() {
		return "UploadCSV [id=" + id + ", regionCode=" + regionCode + ", target=" + target + ", useage=" + useage
				+ ", limit=" + limit + ", minrate=" + minrate + ", maxrate=" + maxrate + ", institute=" + institute
				+ ", mgmt=" + mgmt + ", reception=" + reception + ", rgstDt=" + rgstDt + ", updDt=" + updDt + "]";
	}
	
	
	



	
	
	
	
	
	
}
