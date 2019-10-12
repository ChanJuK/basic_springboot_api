package io.kakaotask1.chanjukyung.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UploadCSVRegion")
public class LocalGov {
	
	//구분,지자체명(기관명),지원대상,용도,지원한도,이차보전,추천기관,관리점,취급점
	@Id
	@Column(name = "region_code")
	private String regionCode;
	@Column(name = "region")
	private String region;
	
	@Column(name = "rgst_dt")
	private String rgstDt;
	@Column(name = "upd_dt")
	private String updDt;
	
	public LocalGov() {
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
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
		return "UploadCSVRegion [regionCode=" + regionCode + ", region=" + region + ", rgstDt=" + rgstDt + ", updDt="
				+ updDt + "]";
	}

	public LocalGov(String regionCode, String region, String rgstDt, String updDt) {
		super();
		this.regionCode = regionCode;
		this.region = region;
		this.rgstDt = rgstDt;
		this.updDt = updDt;
	}



	
	



	
	
	
	
}
