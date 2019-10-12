package io.kakaotask1.chanjukyung.service;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.CSVReader;
import io.kakaotask1.chanjukyung.dto.LocalGov;
import io.kakaotask1.chanjukyung.dto.SuppInfo;
import io.kakaotask1.chanjukyung.repository.LocalGovRepository;
import io.kakaotask1.chanjukyung.repository.LocalGovSuppInfoRepository;

@Service
public class InsertDataService {

	@Autowired
	private LocalGovSuppInfoRepository localGovSuppInfoRepository;//지자체 지원 정보 
	@Autowired
	private LocalGovRepository localGovRepository;//지자체 

	//현재일자 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	String curdate = sdf.format(Calendar.getInstance().getTime());


	//적재 
	@SuppressWarnings("resource")
	public String inserDataFile() throws NullPointerException, IOException{
		int insertCnt = 0;
		String rst = "정상처리되지 않았습니다.";
		

 		
		CSVReader reader;
		reader = new CSVReader(new FileReader("src/main/resources/UploadCSV.csv"), ',' , '"' , 1);
			//파일의 데이터를 한줄씩 읽는다. 
		String[] nextLine = null;
	      while ((nextLine = reader.readNext()) != null) {
	         if (nextLine != null) {
	        	 
	        	 //pk 값 파일 체크 
	     		if(nextLine[0] == null || "".equals(nextLine[0])) {
	    			throw new NullPointerException("[오류메시지] : "+insertCnt+"번째 줄에 구분값이 없습니다."); 
	    		}
	     		if(nextLine[1] == null || "".equals(nextLine[1])) {
	    			throw new NullPointerException("[오류메시지] : "+insertCnt+"번째 줄에 지자체명이 없습니다."); 
	    		}
	            
				//지원 지자체 정보를 적재한다.
				LocalGov r = new LocalGov();
				r.setRegionCode(nextLine[0]);//지자체코드 
				r.setRegion(nextLine[1]);//지자체 
				r.setRgstDt(curdate);//등록 일시 
				r.setUpdDt(curdate);//수정 일시 
				localGovRepository.save(r);
				

				//지자체 지원 정보를 적재할수있도록 DTO 세
				SuppInfo c = new SuppInfo();
				c.setId(nextLine[0]);//구분 
				c.setRegionCode(nextLine[0]);//지자체 코드 
				c.setTarget(nextLine[2]);//지원대상
				c.setUseage(nextLine[3]);//용도 
				
				//지원한도 값 세팅 
				String limit = nextLine[4];
				if(limit.contains("억")){
					c.setLimit(new BigDecimal(limit.substring(0, limit.indexOf("억"))+"00000000"));								
				}else if(limit.contains("백만")) {
					c.setLimit(new BigDecimal(limit.substring(0, limit.indexOf("백"))+"000000"));								
				}else {
					c.setLimit(null);													
				}
				
				//이차보전 값 세팅 
				if(!nextLine[5].contains("전액")) {					
					String[] rate = nextLine[5].replace("~", "").split("%");
					
					if(rate.length > 1) {
						c.setMinrate(new BigDecimal(rate[0]));
						c.setMaxrate(new BigDecimal(rate[1]));				
					}else {
						c.setMinrate(new BigDecimal("0"));
						c.setMaxrate(new BigDecimal(rate[0]));								
					}
				}else {
					c.setMinrate(null);
					c.setMaxrate(null);									
					
				}
				c.setInstitute(nextLine[6]);//추천기관 
				c.setMgmt(nextLine[7]);//관리점
				c.setReception(nextLine[8]);//취급점
				c.setRgstDt(curdate);//등록 일시 
				c.setUpdDt(curdate);//수정 일시 
				
				//지자체 지원 정보 저장 
				localGovSuppInfoRepository.save(c);	

				//적재 건수 카운트 
				insertCnt = insertCnt+1;
	         }
	       }
	      
	      rst = String.valueOf(insertCnt) + "건 정상처리되었습니다.";
			System.out.print("----> total insert rows : "+insertCnt);
			
		return rst;
			
			
			

	}




}
