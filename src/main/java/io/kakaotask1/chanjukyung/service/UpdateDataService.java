package io.kakaotask1.chanjukyung.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kakaotask1.chanjukyung.dto.SuppInfo;
import io.kakaotask1.chanjukyung.dto.ShowLocalGovSuppDTO;
import io.kakaotask1.chanjukyung.exception.MyException;
import io.kakaotask1.chanjukyung.repository.LocalGovSuppInfoRepository;

@Service//서비스선

public class UpdateDataService {

	@Autowired
	private LocalGovSuppInfoRepository localGovSuppInfoRepository;


	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	String curdate = sdf.format(Calendar.getInstance().getTime());
	String line = "";

	
	
	//지자체명에 해당하는 건 수정 
	public String updatelocalGovSuppInfo(ShowLocalGovSuppDTO data) {
		String msg = "정상 처리되지 않았습니다.";
	
		if(data.getRegion() == null || "".equals(data.getRegion())) {
			throw new MyException("수정할 지자체명을 입력해주세요.");
		}
		
		List<SuppInfo> update = localGovSuppInfoRepository.selectOneUploadCSV(data.getRegion());

		if(update.size() <= 0) {
			throw new MyException("등록되지 않은 지자체명 입니다.");
		}

			
		for(int i=0; i < update.size();i++) {

			update.get(i).setTarget(data.getTarget());
			update.get(i).setUseage(data.getUseage());
			String limit = data.getLimit();

			if(limit.contains("억")){
				update.get(i).setLimit(new BigDecimal(limit.substring(0, limit.indexOf("억"))+"00000000"));								
			}else if(limit.contains("백만")) {
				update.get(i).setLimit(new BigDecimal(limit.substring(0, limit.indexOf("백"))+"000000"));								
			}else {
				update.get(i).setLimit(null);													
			}
			
			String ratestr = data.getRate();
			if(!ratestr.contains("전액")) {					
				String[] rate = ratestr.replace("~", "").split("%");
				
				if(rate.length > 1) {
					update.get(i).setMinrate(new BigDecimal(rate[0]));
					update.get(i).setMaxrate(new BigDecimal(rate[1]));				
				}else {
					update.get(i).setMinrate(new BigDecimal("0"));
					update.get(i).setMaxrate(new BigDecimal(rate[0]));								
				}
			}else {
				update.get(i).setMinrate(null);
				update.get(i).setMaxrate(null);									
				
			}
			update.get(i).setInstitute(data.getInstitute());
			update.get(i).setMgmt(data.getMgmt());
			update.get(i).setReception(data.getReception());
			update.get(i).setUpdDt(curdate);    	
							
			localGovSuppInfoRepository.save(update.get(0));
			
		}
	
	
		msg = "정상처리 되었습니다.";
		System.out.print(msg);
		 
		return msg;
	}

}
