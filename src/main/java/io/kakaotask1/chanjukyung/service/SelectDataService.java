package io.kakaotask1.chanjukyung.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kakaotask1.chanjukyung.dto.LocalGov;
import io.kakaotask1.chanjukyung.dto.SuppInfo;
import io.kakaotask1.chanjukyung.dto.ShowLocalGovSuppDTO;
import io.kakaotask1.chanjukyung.exception.MyException;
import io.kakaotask1.chanjukyung.repository.LocalGovRepository;
import io.kakaotask1.chanjukyung.repository.LocalGovSuppInfoRepository;
import io.kakaotask1.chanjukyung.repository.ShowLocalGovSuppRepository;

@Service
public class SelectDataService {
	
	@Autowired
	private LocalGovSuppInfoRepository localGovSuppInfoRepository;
	@Autowired
	private ShowLocalGovSuppRepository showUploadCSVRepository;
	
	@Autowired
	private LocalGovRepository uploadCSVRegionRepository;




	//지자체명으로 한건 조
	public List<ShowLocalGovSuppDTO> selectLocalGovSuppInfoByRegion(String region) {
		
		if(region == null || "".equals(region)) {
			throw new MyException("조회할 지자체명이 없습니다.");			
		}
		
		List<ShowLocalGovSuppDTO> data = showUploadCSVRepository.selectLocalGovSuppInfoByRegion(region);

		
		for(int i=0; i < data.size(); i++) {
			if(data.get(i).getLimit() == null) {
				data.get(i).setLimit("추천금액 이내");
				
			}else {
				BigDecimal limit = new BigDecimal(data.get(i).getLimit().replace(".00", ""));
				if(String.valueOf(limit).length() >= 9) {//억단
					BigDecimal l = limit.divide(new BigDecimal("100000000"));
					data.get(i).setLimit(String.valueOf(l)+"억원 이내");
				}else {//백만원 단
					BigDecimal l = limit.divide(new BigDecimal("1000000"));
					data.get(i).setLimit(String.valueOf(l)+"백만원 이내");					
				}
				
			}
			
		}

		
		return data;
	}
	
	
	//적재한 모든 가공된 데이터 조회 
	public List<ShowLocalGovSuppDTO> selectAllLocalGovSuppInfo(){
		List<ShowLocalGovSuppDTO> data = new ArrayList<>();
		data = showUploadCSVRepository.selectAllLocalGovSuppInfo();
		
		System.out.print(data.toString());
		
		for(int i=0; i < data.size(); i++) {
			if(data.get(i).getLimit() == null) {
				data.get(i).setLimit("추천금액 이내");
				
			}else {
				BigDecimal limit = new BigDecimal(data.get(i).getLimit().replace(".00", ""));
				if(String.valueOf(limit).length() >= 9) {//억단
					BigDecimal l = limit.divide(new BigDecimal("100000000"));
					data.get(i).setLimit(String.valueOf(l)+"억원 이내");
				}else {//백만원 단
					BigDecimal l = limit.divide(new BigDecimal("1000000"));
					data.get(i).setLimit(String.valueOf(l)+"백만원 이내");					
				}
				
			}
			
		}

		return data;
	}

	
	
	
	//적재한 모든 생 데이터 조회 
	public List<SuppInfo> selectAllUploadCSV() {
		List<SuppInfo> csv = new ArrayList<>();
		localGovSuppInfoRepository.findAll().forEach(csv :: add);
		
		return csv;
	}

	//적재한 모든 생 지자체 테이블 조회 
	public List<LocalGov> selectAllUploadCSVRegion() {
		List<LocalGov> csv = new ArrayList<>();
		uploadCSVRegionRepository.findAll().forEach(csv :: add);		
		return csv;
	}


}
