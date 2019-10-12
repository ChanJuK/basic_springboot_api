package io.kakaotask1.chanjukyung.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import io.kakaotask1.chanjukyung.dto.SuppInfo;

public interface LocalGovSuppInfoRepository extends CrudRepository<SuppInfo, String>{
	
	  public List<SuppInfo> findByLimit(String Limit, Sort sort);

	
	
	
	@Query(value="SELECT * "
			+ "FROM SuppInfo order by maxrate asc "
			, nativeQuery = true)
	List<SuppInfo> selectMinRateInstitute();

	
	@Query(value="SELECT a.limit "
			+ ", count(1) as cnt  "
			+ "FROM SuppInfo a "
			+ "group by a.limit "
			+ "order by a.limit desc "
			, nativeQuery = true)
	String[][] countLimit();

	
	@Query(value="SELECT institute "
			+ "FROM SuppInfo orederby "
			, nativeQuery = true)
	String[] selectMaxLimitRegion();


	
	//0.지자체명 입력하면 해당 정보 조회
	@Query(value="SELECT a.* "
			+ "FROM SuppInfo a "
			+ "inner join "
			+ "LocalGov b "
			+ "on a.region_code = b.region_code "
			+ "and b.region = :region"
			, nativeQuery = true)
	List<SuppInfo> selectOneUploadCSV(@Param("region") String region);

	
	
}
