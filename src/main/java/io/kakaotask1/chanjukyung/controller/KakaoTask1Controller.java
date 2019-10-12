package io.kakaotask1.chanjukyung.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.kakaotask1.chanjukyung.dto.LocalGov;
import io.kakaotask1.chanjukyung.dto.SuppInfo;
import io.kakaotask1.chanjukyung.dto.ShowLocalGovSuppDTO;
import io.kakaotask1.chanjukyung.exception.MyException;
import io.kakaotask1.chanjukyung.service.InsertDataService;
import io.kakaotask1.chanjukyung.service.SelectDataService;
import io.kakaotask1.chanjukyung.service.SelectMinMaxService;
import io.kakaotask1.chanjukyung.service.UpdateDataService;

@RestController
public class KakaoTask1Controller {
	
	//서비스 선언
	@Autowired
	private InsertDataService insertDataService;//파일 업로드 하는 서비스
	@Autowired
	private UpdateDataService updateDataService;//파일 업로드 하는 서비스
	@Autowired
	private SelectDataService selectDataService;//적재 데이터 단순 조회하는 서비스 
	@Autowired
	private SelectMinMaxService selectMinMaxService;//적재 데이터의 최대 최소를 조회하는 서비스 

	//MyException 메시지 출력 
    @ExceptionHandler(value = MyException.class)
    public String nfeHandler(MyException e){
        return e.getMessage();
    }
	
	//csv파일 데이터를 디비에 적재한다.
	@RequestMapping("/inserDataFile")
	public void inserDataFile() throws NullPointerException, IOException{

		String rst = insertDataService.inserDataFile();

//		return rst;
	}
	//파일로 업로드한 지자체지원 정보 테이블 전체 로우데이터 조회  
	@RequestMapping("/selectAllUploadCSV")//url주
	public List<SuppInfo> selectAllUploadCSV(){
		return selectDataService.selectAllUploadCSV();
	}
	//파일로 업로드한 지자체지원 정보 테이블 전체 로우데이터 조회  
	@RequestMapping("/selectAllUploadCSVRegion")//url주
	public List<LocalGov> selectAllUploadCSVRegion(){
		return selectDataService.selectAllUploadCSVRegion();
	}

	

	
	
	

	
	
	//전체 데이터 조회
	@RequestMapping("/selectAllLocalGovSuppInfo")//GET
	public List<ShowLocalGovSuppDTO> selectAllLocalGovSuppInfo(){
		return selectDataService.selectAllLocalGovSuppInfo();
	}
	
	//지자체명으로 조회 
	@RequestMapping("/selectLocalGovSuppInfoByRegion/{region}")//GET
	public List<ShowLocalGovSuppDTO> selectLocalGovSuppInfoByRegion(@PathVariable String region){
		return selectDataService.selectLocalGovSuppInfoByRegion(region);
	}
	
	//지자체 지원 정보 수정 
	@RequestMapping(method=RequestMethod.POST, value="/updateUploadCSV" )
	public String updateUploadCSV(@RequestBody ShowLocalGovSuppDTO ShowUploadCSV) {
		return updateDataService.updatelocalGovSuppInfo(ShowUploadCSV);
	}	


	//이차보전 비율이 제일 적은 기관명 구하기 
	@RequestMapping("/selectMinRateInstitute")//url주
	public String selectMinRateInstitute() {//id값이 그 값이라고 선언하는 방법 @PathVariable
		return selectMinMaxService.selectMinRateInstitute();
	}	



	//입력한 개수 만큼의 내림차순 정렬으로 지원금이 많은 순으로 지자체명 조회 
	@RequestMapping("/selectMaxLimitRegion/{showCnt}")
	public List<String> selectMaxLimitRegion(@PathVariable int showCnt) {
		return selectMinMaxService.selectMaxLimitRegion(showCnt);
	}	

}



