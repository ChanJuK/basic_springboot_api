package io.kakaotask1.chanjukyung.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.kakaotask1.chanjukyung.dto.ShowLocalGovSuppDTO;

public interface ShowLocalGovSuppRepository extends JpaRepository<ShowLocalGovSuppDTO, String>{
	

			@Query(value="SELECT b.region, a.target, a.useage "
			+ ", a.limit "
			+ ", ( case when a.minrate is null "
			+ "			then '대출이자 전액' "
			+ "		else RTRIM(char(a.minrate)) ||'%~'|| RTRIM(char(a.maxrate))||'%' end )as rate"
			+ ", a.institute, a.mgmt, a.reception "
			+ "FROM SuppInfo a "
			+ "inner join "
			+ "LocalGov b "
			+ "on b.region_code = a.region_code"
			, nativeQuery = true)
		List<ShowLocalGovSuppDTO> selectAllLocalGovSuppInfo();

			
			
		//0.지자체명 입력하면 해당 정보 조회
		@Query(value="SELECT b.region, a.target, a.useage "
				+ ", a.limit "
				+ ", ( case when a.minrate is null "
				+ "			then '대출이자 전액' "
				+ "		else RTRIM(char(a.minrate)) ||'%~'|| RTRIM(char(a.maxrate))||'%' end )as rate"
				+ ", a.institute, a.mgmt, a.reception "
				+ "FROM SuppInfo a "
				+ "inner join "
				+ "LocalGov b "
				+ "on b.region_code = a.region_code "
				+ "and b.region = :region"
				, nativeQuery = true)
		List<ShowLocalGovSuppDTO> selectLocalGovSuppInfoByRegion(@Param("region") String region);


		
		
		
}

