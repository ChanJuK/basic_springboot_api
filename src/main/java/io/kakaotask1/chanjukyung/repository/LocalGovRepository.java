package io.kakaotask1.chanjukyung.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import io.kakaotask1.chanjukyung.dto.LocalGov;

public interface LocalGovRepository extends CrudRepository<LocalGov, String>{
	
	
	@Query(value="select r.region_code, r.region, r.rgst_dt, r.upd_dt "
			+ "from LocalGov r "
			+ "where r.region = :region", nativeQuery = true)
	LocalGov findLocalGovByRegion(@Param("region") String region);
	

	//지원금으로 지자체명 조
	@Query(value="SELECT b.region "
			+ "FROM SuppInfo a "
			+ "inner join LocalGov b "
			+ "on b.region_code = a.region_code "
			+ "and a.limit is null "
			+ "order by (nullif(a.minrate,100) + nullif(a.maxrate,100))/2 asc "
			, nativeQuery = true)
	List<String> selectSortNullAvgRateAsc();

	
	
	//지원금으로 이자보전의 평균값을 내림차순으로 정렬후 지자체명 조회 
	@Query(value="SELECT b.region "
			+ "FROM SuppInfo a "
			+ "inner join LocalGov b "
			+ "on b.region_code = a.region_code "
			+ "and a.limit = :limit "
			+ "order by (nullif(a.minrate,100) + nullif(a.maxrate,100))/2 asc "
			, nativeQuery = true)
	List<String> selectSortAvgRateAsc(@Param("limit") String limit);

}
