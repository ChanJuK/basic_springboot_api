package io.kakaotask1.chanjukyung.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kakaotask1.chanjukyung.dto.SuppInfo;
import io.kakaotask1.chanjukyung.exception.MyException;
import io.kakaotask1.chanjukyung.repository.LocalGovRepository;
import io.kakaotask1.chanjukyung.repository.LocalGovSuppInfoRepository;

@Service//서비스선
public class SelectMinMaxService {

	@Autowired
	private LocalGovSuppInfoRepository localGovSuppInfoRepository;
	@Autowired
	private LocalGovRepository uploadCSVRegionRepository;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	String curdate = sdf.format(Calendar.getInstance().getTime());
	String line = "";

	
	//4.이차보전 비율이 제일 적은 기관명 구하기 
	public String selectMinRateInstitute() {
		//min(minrate) in  uploadcsv table
		List<SuppInfo> data = localGovSuppInfoRepository.selectMinRateInstitute();
		String msg = "";
		if(data.size() > 0) {
			msg = "이차보전 비율이 가장 작은 추천 기관명 : "+data.get(0).getInstitute() 
					+ "(이차보전 :" +data.get(0).getMinrate()+"%~"+data.get(0).getMaxrate()+"%)";			
		}else {
			msg = "조회할 데이터가 없습니다.";
		}
		return msg;
	}

	
	public List<String> selectMaxLimitRegion(int showCnt) {
		List<String> data = new ArrayList<String>();
				
		if(showCnt <=0 ) {
			throw new MyException("조회할 지자체명의 개수를 입력해주세요.");
		}
		System.out.print("\n--------------- 몇개 조회해라 ------------->"+showCnt);

		
		
		//group by count limit
		String[][] cntLimit = localGovSuppInfoRepository.countLimit();		
		if(cntLimit.length <=0 ) {
			throw new MyException("조회할 지자체 지원 정보가 없습니다.");
		}

		List<String> r = new ArrayList<String>();
		
		
		for(int i=0; i< cntLimit.length; i++) {
			
			
			if(cntLimit[i][0] == null ) {
				r = uploadCSVRegionRepository.selectSortNullAvgRateAsc();
				
			}else {
				r = uploadCSVRegionRepository.selectSortAvgRateAsc(cntLimit[i][0]);

			}


			System.out.print(r);
			
			int remain = showCnt - data.size();
			if(data.size() < showCnt) {
				if(r.size() > remain) {
					data.addAll(r.subList(0, remain));
					
				}else if(r.size() > 0){
					data.addAll(r);
					
				}
			}else {
				break;
			}
			
			

		}
		
		System.out.print("\n--------------final -------------->"+data.size());

	      return data;
	}

}
