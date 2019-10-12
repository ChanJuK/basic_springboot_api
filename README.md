# Basic Springboot api 
Spring boot Starter project, JPA, Apache Derby Database, SQL


----
# 문제해결

----
## 1. 데이터 파일을 데이터베이스에 저장하는 API 개발
[해결] 

- 데이터 CSV파일을 한줄씩 읽고 ','를 구별하여 데이터를 각 컬럼에 나눠서 배열에 넣는다.
- 사용할 두 테이블의 pk컬럼에 넣을 데이터가 빈값인지 검증한다.
- 지원금액 컬럼과 이차보전 컬럼은 BigDecimal 타입으로 데이터를 변환하여 세팅한다.
- 데이터를 다 담은 배열을 한줄씩 차례대로 저장한다.
- 실행한 결과 아래와 같이 저장한 두 테이블의 정보를 볼수있다.

[빌드방법]

일반적인 스프링 프로젝트 run을 하면된다.

[실행방법]

- GET방식
- 실행 url : http://localhost:8080/insertUploadCSV
- 실행결과 : 98건 처리되었습니다.



----
## 2. 지원하는 지자체 목록 전체 검색하는 API
[해결]

- 지자체지원정보 테이블과 지자체테이블을 지자체코드로 조인을 하여 조회한다.

[실행방법] 

- GET방식
- 실행 url : http://localhost:8080/selectAllShowUploadCSV
- 실행결과 : 
[{"region":"강릉시","target":"강릉시 소재 중소기업으로서 강릉시장이 추천한 자","useage":"운전","limit":"추천금액 이내","rate":"3.00%","institute":"강릉시","mgmt":"강릉지점","reception":"강릉시 소재 영업점"},{"region":"강원도","target":"강원도 소재 중소기업으로서 강원도지사가 추천한 자","useage":"운전","limit":"8억원 이내","rate":"3.00%~5.00%","institute":"강원도","mgmt":"춘천지점","reception":"강원도 소재 영업점"},{"region":"거제시","target":"거재시 소재 중소기업(소상공인 포함)으로서 거제시장이 추천한자","useage":"운전","limit":"3억원 이내","rate":"2.50%~5.00%","institute":"거제시, 경남신용보증재단","mgmt":"거제지점","reception":"거제시, 통영시에 소재영업점"},{"region":"경기도","target":"경기도 소재 중소기업으로서 경기도지사가 추천한 자","useage":"운전 및 시설","limit":"300억원 이내","rate":"0.30%~2.00%","institute":"경기신용보증재단","mgmt":"경수지역본부","reception":"전 영업점"},{"region":"경상남도","target":"경상남도 소재 중소기업으로서 경상남도지사가 추천한 자","useage":"운전 및 시설","limit":"8억원 이내","rate":"1.50%~3.50%","institute":"경상남도","mgmt":"창원지점","reception":"전 영업점"},{"region":"경상북도","target":"경상북도 소재 중소기업으로서 경상북도지사가 추천한 자","useage":"운전","limit":"5억원 이내","rate":"3.00%~4.00%","institute":"경상북도","mgmt":"대구경북동부지역본부","reception":"전 영업점"},{"region":"경주시","target":"경주시 소재 중소기업으로서 경주시장이 추천한 자","useage":"운전","limit":"5억원 이내","rate":"3.00%","institute":"경주시","mgmt":"대구경북동부지역본부","reception":"경주시 소재 영업점"},{"region":"고양시","target":"고양시 소재 중소기업으로서 고양시장이 추천한 자","useage":"운전","limit":"3억원 이내","rate":"2.00%~3.00%","institute":"고양시","mgmt":"일산마두지점","reception":"전 영업점"},{"region":"광명시","target":"광명시 소재 중소기업으로서 광명시장이 추천한 자","useage":"운전","limit":"3억원 이내","rate":"2.00%","institute":"광명시","mgmt":"광명지점","reception":"전 영업점"},{"region":"광양시","target":"광양시 소재 중소기업(소상공인 포함)으로서 광양시장이 추천한자","useage":"운전","limit":"2억원 이내","rate":"3.00%~4.00%","institute":"광양시","mgmt":"광양지점","reception":"광양지점"},{"region":"광주광역시","target":"광주광역시 소재 중소기업(소상공인, 벤처기업 포함)으로서 광주광역시장이 추천한자","useage":"운전","limit":"5억원 이내","rate":"2.00%~3.00%","institute":"광주광역시 경제고용진흥원, 광주신용보증재단, 광주광역시","mgmt":"호남지역본부","reception":"전 영업점"},{"region":"구미시","target":"구미시 소재 중소기업으로서 구미시장이 추천한 자","useage":"운전 및 시설","limit":"5억원 이내","rate":"2.50%~3.50%","institute":"구미시중소기업협의회, 구미시기업사랑본부","mgmt":"구미지점","reception":"구미시 소재 영업점"},{"region":"군산시","target":"군산시 소재 중소기업(소상공인 포함)으로서 군산시장이 추천한 자","useage":"운전 및 시설","limit":"5억원 이내","rate":"3.00%~6.00%","institute":"군산시, 전북신용보증재단","mgmt":"군산지점","reception":"군산시 소재 영업점"},{"region":"김제시","target":"김제시 소재 중소기업으로서 김제시장이 추천한 자","useage":"운전","limit":"2억원 이내","rate":"3.00%","institute":"김제시","mgmt":"호남지역본부","reception":"전주지점"},{"region":"김천시","target":"김천시 소재 중소기업으로서 김천시장이 추천한 자","useage":"운전","limit":"5억원 이내","rate":"4.00%","institute":"김천시","mgmt":"김천지점","reception":"전 영업점"},{"region":"김포시","target":"김포시 소재 중소기업(소상공인 포함)으로서 김포시장이 추천한 자","useage":"운전","limit":"2억원 이내","rate":"1.50%~2.00%","institute":"김포시","mgmt":"김포지점","reception":"김포시 관내 영업점"},{"region":"김해시","target":"김해시 소재 중소기업(소상공인 포함)으로서 김해시장이 추천한 자","useage":"운전 및 시설","limit":"3억원 이내","rate":"2.00%~2.50%","institute":"김해시, 경남신용보증재단 김해지점","mgmt":"김해지점","reception":"전 영업점"},{"region":"금천구","target":"금천구 소재 중소기업으로서 금천구청장이 추천한 자","useage":"운전","limit":"2억원 이내","rate":"0.10%~3.50%","institute":"금천구","mgmt":"가산디지털지점","reception":"전 영업점"},{"region":"나주시","target":"나주시 소재 중소기업으로서 나주시장이 추천한 자","useage":"운전","limit":"2억원 이내","rate":"2.00%","institute":"나주시","mgmt":"호남지역본부","reception":"나주시에서 취급점으로 지정한 영업점"},{"region":"남양주시","target":"남양주시 소재 중소기업으로서 남양주시장이 추천한 자","useage":"운전 및 시설","limit":"5억원 이내","rate":"1.50%","institute":"남양주시","mgmt":"호평지점","reception":"전 영업점"},{"region":"남원시","target":"남원시 소재 중소기업으로서 남원시장이 추천한 자","useage":"운전 및 시설","limit":"3억원 이내","rate":"3.00%~4.00%","institute":"남원시","mgmt":"남원지점","reception":"전 영업점"},{"region":"단양군","target":"단양군 소재 중소기업으로서 단양군수가 추천한 자","useage":"운전","limit":"2억원 이내","rate":"2.00%~3.00%","institute":"단양군","mgmt":"제천지점","reception":"제천지점"},{"region":"대구광역시","target":"대구광역시 소재 중소기업으로서 대구광역시장이 추천한 자","useage":"운전","limit":"10억원 이내","rate":"0.40%~1.80%","institute":"대구신용보증재단","mgmt":"대구경북동부지역본부","reception":"전 영업점"},{"region":"대전광역시","target":"대전광역시 소재 중소기업(소상공인포함)으로서 대전광역시장이 추천한 자","useage":"운전","limit":"5억원 이내","rate":"2.00%~3.00%","institute":"대전광역시 경제통상진흥원","mgmt":"충청지역본부","reception":"전 영업점"},{"region":"동해시","target":"동해시 소재 중소기업으로서 동해시장의 융자추천을 받은자","useage":"운전","limit":"2억원 이내","rate":"3.00%","institute":"동해시","mgmt":"동해지점","reception":"동해시 소재 영업점"},{"region":"마산시","target":"마산시 소재 중소기업으로서 마산시장의 융자추천을 받은 자","useage":"운전 및 시설","limit":"5억원 이내","rate":"2.50%~5.00%","institute":"마산시","mgmt":"마산지점","reception":"마산시 소재 영업점"},{"region":"목포시","target":"목포시 소재 중소기업으로서 목포시장의 추천을 받은 자","useage":"운전","limit":"3억원 이내","rate":"5.00%","institute":"목포시","mgmt":"목포지점","reception":"전 영업점"},{"region":"밀양시","target":"밀양시 소재 중소기업으로서 밀양시의 융자 추천을 받은 자","useage":"운전 및 시설","limit":"2억원 이내","rate":"4.00%","institute":"밀양시","mgmt":"창원지점","reception":"전 영업점"},{"region":"보령시","target":"보령시에 사업장을 두고 있는 자로서 충남신용보증재단의 보증서를 발급받은 소상공인","useage":"운전","limit":"30백만원 이내","rate":"2.00%~2.50%","institute":"충남신용보증재단 보령지점","mgmt":"대천지점","reception":"전 영업점"},{"region":"부산광역시","target":"부산광역시 소재 중소기업으로서 부산광역시장이 추천한 자","useage":"운전","limit":"3억원 이내","rate":"1.50%~2.50%","institute":"부산경제진흥원","mgmt":"부산지역본부","reception":"부산광역시에서 취급점으로 지정한 영업점"},{"region":"부천시","target":"부천시 소재 중소기업으로서 부천시장의 추천을 받은 자","useage":"운전 및 시설","limit":"5억원 이내","rate":"1.50%~2.50%","institute":"부천시","mgmt":"강서제주지역본부","reception":"전 영업점"},{"region":"사천시","target":"사천시 소재 중소기업으로서 사천시장의 융자추천을 받은 기업","useage":"운전 및 시설","limit":"2억원 이내","rate":"2.50%","institute":"사천시","mgmt":"진주지점","reception":"경상남도 소재 영업점"},{"region":"산청군","target":"산청군 소재 중소기업으로 산청군수의 추천을 받은 자","useage":"운전","limit":"3억원 이내","rate":"3.50%","institute":"산청군","mgmt":"진주지점","reception":"진주시 소재 영업점"},{"region":"서울특별시","target":"서울특별시 소재 중소기업 및 소상공인으로서 시장의 추천*을 받은 자","useage":"운전","limit":"5억원 이내","rate":"1.50%~2.50%","institute":"서울신용보증재단","mgmt":"여신기획부","reception":"전 영업점"},{"region":"성남시","target":"성남시 소재 중소기업으로서 성남시장의 추천을 받은 자","useage":"운전 및 시설","limit":"5억원 이내","rate":"1.80%","institute":"성남시","mgmt":"성남하이테크지","reception":"전 영업점"},{"region":"성동구","target":"서울특별시 성동구 소재 중소기업으로서 서울특별시 성동구청장의 추천을 받은 자","useage":"운전","limit":"2억원 이내","rate":"1.50%","institute":"서울시 성동구","mgmt":"성수동지점","reception":"전 영업점"},{"region":"세종특별자치시","target":"세종특별자치시에 소재하는 기업으로서 세종특별자치시장이 융자 추천하고 충남경제진흥원에서 추천서를 발급받은 자","useage":"운전 및 시설","limit":"5억원 이내","rate":"1.00%~2.00%","institute":"충청남도경제진흥원, 충남신용보증재단","mgmt":"충청지역본부","reception":"전 영업점"},{"region":"속초시","target":"속초시 소재 중소기업으로서 속초시장의 융자추천을 받은 중소기업","useage":"운전","limit":"3억원 이내","rate":"3.00%","institute":"속초시","mgmt":"속초지점","reception":"속초시 소재 영업점"},{"region":"수원시","target":"수원시 소재 중소기업으로서 수원시장의 융자 추천을 받은 자","useage":"운전","limit":"5억원 이내","rate":"2.00%","institute":"수원시","mgmt":"동수원지점","reception":"전 영업점"},{"region":"순창군","target":"순창군 소재 중소기업 및 소상공인으로서 순창군의 융자 추천을 받은 자","useage":"운전 및 시설","limit":"5억원 이내","rate":"4.00%","institute":"순창군","mgmt":"남원지점","reception":"전 영업점"},{"region":"시흥시","target":"시흥시 소재 중소기업 및 소상공인으로서 시흥시장이 추천한 자","useage":"운전","limit":"3억원 이내","rate":"1.00%~2.50%","institute":"시흥시","mgmt":"경서지역본부","reception":"전 영업점"},{"region":"안산시","target":"안산시 소재 중소기업으로서 안산시장이 추천한 자","useage":"시설","limit":"10억원 이내","rate":"대출이자 전액","institute":"안산시","mgmt":"경서지역본부","reception":"전 영업점"},{"region":"안성시","target":"안성시 소재 중소기업으로서 안성시장의 추천을 받은 자","useage":"운전","limit":"2억원 이내","rate":"2.00%~2.50%","institute":"안성시","mgmt":"안성지점","reception":"안성지점, 평택지점"},{"region":"안양시","target":"안양시 소재 중소기업으로서 취급점이 융자추천하고 안양시장이 대상자로 통보한 자","useage":"운전 및 시설","limit":"30억원 이내","rate":"1.00%~2.00%","institute":"안양시","mgmt":"안양지점","reception":"안양시 소재 영업"},{"region":"양주시","target":"양주시 소재 중소기업(소상공인 포함)으로서 양주시장의 추천을 받은 자","useage":"운전","limit":"2억원 이내","rate":"2.00%","institute":"양주시","mgmt":"양주지점","reception":"양주시 관내 영업점"},{"region":"양산시","target":"양산시 소재 소상공인으로서 경남신용보증재단의 신용보증서를 발급받은 자","useage":"운전","limit":"50백만원 이내","rate":"2.50%","institute":"경남신용보증재단 양산지점","mgmt":"양산지점","reception":"양산시 소재 영업점"},{"region":"용인시","target":"용인시 소재 중소기업으로서 용인시장의 추천을 받고, 경기신용보증재단에서 보증서를 발급받은 자","useage":"운전","limit":"2억원 이내","rate":"2.00%~2.50%","institute":"경기신용보증재단","mgmt":"용인지점","reception":"전 영업점"},{"region":"영광군","target":"영광군내에 소재하는 기업으로서 영광군수가 융자 추천한 자","useage":"운전 및 시설","limit":"3억원 이내","rate":"2.00%","institute":"영광군","mgmt":"호남지역본부","reception":"전 영업점"},{"region":"영암군","target":"영암군 소재 중소기업으로 영암군의 추천을 받은 자","useage":"운전 및 시설","limit":"2억원 이내","rate":"3.00%","institute":"영암군","mgmt":"목포지점","reception":"전 영업점"},{"region":"여수시","target":"여수시 소재 중소기업으로서 여수시장의 추천을 받은 자","useage":"운전","limit":"2억원 이내","rate":"2.00%~2.50%","institute":"여수시","mgmt":"여수지점","reception":"전 영업점"},{"region":"옥천군","target":"옥천군 소재 중소기업으로서 옥천군의 추천을 받은 자","useage":"운전","limit":"2억원 이내","rate":"2.00%~3.00%","institute":"옥천군, 충북신용보증재단","mgmt":"옥천지점","reception":"옥천지점"},{"region":"완주군","target":"완주군 소재 중소기업으로서 완주군수의 추천을 받은 자","useage":"운전","limit":"2억원 이내","rate":"2.00%~4.00%","institute":"완주군","mgmt":"호남지역본부","reception":"전 영업점"},{"region":"울산광역시","target":"울산광역시 소재 중소기업으로서 울산경제진흥원의 융자 추천을 받은 자","useage":"운전","limit":"5억원 이내","rate":"1.50%~3.00%","institute":"울산경제진흥원","mgmt":"부산울산지역본부","reception":"전 영업점"},{"region":"울산북구","target":"울산광역시 북구 소재 중소기업으로서 울산경제진흥원의받은 자","useage":"운전","limit":"2억원 이내","rate":"3.00%","institute":"울산경제진흥원","mgmt":"부산울산지역본부","reception":"울산광역시 소재 영업점"},{"region":"울산남구","target":"울산광역시 남구 소재 중소기업으로서 울산경제진흥원의 융자 추천을 받은 자","useage":"운전","limit":"2억원 이내","rate":"2.00%~3.00%","institute":"울산경제진흥원","mgmt":"부산울산지역본부","reception":"전 영업점"},{"region":"울산동구","target":"울산광역시 동구 소재 중소기업으로서 울산경제진흥원의받은 자","useage":"운전","limit":"1억원 이내","rate":"2.50%","institute":"울산경제진흥원","mgmt":"부산울산지역본부","reception":"전 영업점"},{"region":"울주군","target":"울주군 소재 중소기업으로서 울주군의 융자 추천을 받은 자","useage":"운전","limit":"2억원 이내","rate":"2.00%~3.00%","institute":"울주군","mgmt":"부산울산지역본부","reception":"전 영업점"},{"region":"원주시","target":"원주시 소재 중소기업으로 원주시장의 융자추천을 받은 자","useage":"운전 및 시설","limit":"3억원 이내","rate":"3.00%~3.50%","institute":"원주시","mgmt":"원주지점","reception":"원주시 소재 영업점에 한함"},{"region":"의왕시","target":"의왕시 소재 중소기업으로서 의왕시의 융자 추천을 받은 자","useage":"운전 및 시설","limit":"5억원 이내","rate":"1.00%~2.50%","institute":"의왕시","mgmt":"의왕지점","reception":"의왕지점, 의왕내손지점"},{"region":"익산시","target":"익산시 소재 중소기업으로서 익산시장의 추천을 받은 자","useage":"운전","limit":"2억원 이내","rate":"2.00%~4.00%","institute":"익산시, 전북신용보증재단","mgmt":"익산지점","reception":"전 영업점"},{"region":"인천광역시","target":"인천광역시 소재 중소기업으로서 인천광역시의 융자 추천을 받은 자","useage":"운전 및 시설","limit":"30억원 이내","rate":"0.30%~2.00%","institute":"인천광역시 경제통상진흥원","mgmt":"인천지역본부","reception":"전 영업점"},{"region":"인천남동구","target":"인천광역시 남동구 소재 중소기업으로서 남동구청장의 융자 추천을 받은 자","useage":"운전 및 시설","limit":"3억원 이내","rate":"1.50%~2.50%","institute":"남동구청","mgmt":"인천지역본부","reception":"전 영업점"},{"region":"인천부평구","target":"인천광역시 부평구 소재 중소기업으로서 부평구청장의 융자 추천을 받은 자","useage":"운전","limit":"4억원 이내","rate":"1.50%~2.00%","institute":"부평구","mgmt":"인천지역본부","reception":"전 영업점"},{"region":"인천서구","target":"인천광역시 서구 소재 중소기업으로서 인천광역시 서구청장의 추천을 받은 자","useage":"운전","limit":"2억원 이내","rate":"1.00%~2.00%","institute":"인천광역시 서구","mgmt":"인천지역본부","reception":"전 영업점"},{"region":"인천남구","target":"인천광역시 남구 소재 중소기업으로서 남구청장의 추천을 받은 자","useage":"운전","limit":"2억원 이내","rate":"3.00%","institute":"인천광역시 남구","mgmt":"인천지역본부","reception":"전 영업점"},{"region":"전라남도","target":"전라남도 소재 중소기업으로서 전라남도의 융자 추천을 받은 기업","useage":"운전","limit":"5억원 이내","rate":"2.00%~3.00%","institute":"전라남도 중소기업종합지원센터","mgmt":"호남지역본부","reception":"전 영업점"},{"region":"전라북도","target":"전라북도 소재 중소기업으로서 전라북도의 융자 추천을 받은 기업","useage":"운전","limit":"5억원 이내","rate":"2.00%~3.00%","institute":"전라북도 경제통상진흥원","mgmt":"호남지역본부","reception":"전 영업점"},{"region":"전주시","target":"전주시 소재 중소기업으로서 전주시장의 추천을 받은 중소기업","useage":"운전","limit":"3억원 이내","rate":"3.50%~4.00%","institute":"전주시","mgmt":"호남지역본부","reception":"전 영업점"},{"region":"정읍시","target":"정읍시 소재 중소기업으로서 정읍시의 융자 추천을 받은 자","useage":"운전","limit":"3억원 이내","rate":"2.00%~2.50%","institute":"정읍시, 전북신용보증재단","mgmt":"정읍지점","reception":"전 영업점"},{"region":"제주도","target":"제주특별자치도 소재 중소기업으로서 제주특별자치도지사의 융자 추천을 받은 자","useage":"운전 및 시설","limit":"90억원 이내","rate":"1.70%~2.80%","institute":"제주특별자치도","mgmt":"제주지점","reception":"제주특별자치도 소재 영업점"},{"region":"제천시","target":"제천시 소재 중소기업으로서 제천시장의 융자추천을 받은 중소기업","useage":"운전 및 시설","limit":"5억원 이내","rate":"4.00%","institute":"제천시","mgmt":"제천지점","reception":"전 영업점"},{"region":"진주시","target":"진주시 소재 중소기업으로서 진주시장이 추천한 자","useage":"운전","limit":"5억원 이내","rate":"1.50%~3.00%","institute":"경남신용보증재단, 진주시","mgmt":"진주지점","reception":"전 영업점"},{"region":"진천군","target":"진천군 소재 중소제조업체(소기업 포함)로서 진천군수의 융자 추천을 받은 자","useage":"운전","limit":"2억원 이내","rate":"3.00%","institute":"진천군","mgmt":"오창지점","reception":"충청북도 소재 영업점"},{"region":"창원시","target":"창원시 소재 중소기업으로서 창원시장이 추천한 자","useage":"운전 및 시설","limit":"5억원 이내","rate":"1.50%","institute":"창원시","mgmt":"창원지점","reception":"경상남도 내 소재 영업점"},{"region":"창녕군","target":"창녕군 소재 중소기업으로 창녕군수가 추천하는 기업","useage":"운전","limit":"2억원 이내","rate":"3.00%","institute":"창녕군","mgmt":"창원지점","reception":"창원지점"},{"region":"청원군","target":"청원군 소재 중소기업으로서 청원군수의 융자추천을 받은 중소기업","useage":"운전","limit":"5억원 이내","rate":"3.00%","institute":"청원군","mgmt":"청주지점","reception":"전영업점"},{"region":"청주시","target":"청주시 소재 중소기업으로서 청주시 기업지원과의 융자 추천을 받은 자","useage":"운전 및 시설","limit":"5억원 이내","rate":"3.00%","institute":"청주시","mgmt":"충청지역본부","reception":"전영업점"},{"region":"춘천시","target":"춘천시 소재 중소기업으로서 춘천시장이 추천한 자","useage":"운전 및 시설","limit":"8억원 이내","rate":"3.00%","institute":"춘천시","mgmt":"춘천지점","reception":"전영업점"},{"region":"충주시","target":"충주시 소재 중소기업으로서 충주시장의 융자추천을 받은 자","useage":"운전 및 시설","limit":"5억원 이내","rate":"2.00%~3.00%","institute":"충추시","mgmt":"충주지점","reception":"충주시 소재 영업점"},{"region":"충청남도","target":"충청남도 소재 중소기업으로서 충청남도지사가 추천한 자(소상공인은 충남신용보증재단으로부터 추천받은 자)","useage":"운전","limit":"3억원 이내","rate":"1.25%~2.00%","institute":"충청남도, 충남신용보증재단","mgmt":"충청지역본부","reception":"전영업점"},{"region":"충청북도","target":"충청북도에서 융자추천을 받은 자","useage":"운전 및 시설","limit":"5억원 이내","rate":"1.52%","institute":"충청북도지방기업진흥원","mgmt":"충청지역본부","reception":"전영업점"},{"region":"파주시","target":"파주시 소재 중소기업으로서 파주시장의 융자 추천을 받거나 파주시 소재 소상공인으로서 경기신용보증재단의 신용보증서를 발급 받은 자","useage":"운전","limit":"3억원 이내","rate":"2.00%","institute":"파주시, 경기신용보증재단","mgmt":"파주지점","reception":"전영업점"},{"region":"포천시","target":"포천시 소재 중소기업으로 포천시장의 추천을 받은 자","useage":"운전","limit":"1억원 이내","rate":"2.00%","institute":"포천시","mgmt":"포천지점","reception":"포천지점"},{"region":"평택시","target":"평택시에 사업장이 소재하고 있고 평택시장이 지원결정 후 당행에 통보한 자","useage":"운전","limit":"5억원 이내","rate":"2.00%","institute":"평택시","mgmt":"평택지점","reception":"전영업점"},{"region":"포항시","target":"포항시 소재 중소기업으로서 포항시장이 추천한 기업","useage":"운전","limit":"3억원 이내","rate":"3.00%","institute":"포항시","mgmt":"포항남지점","reception":"전영업점"},{"region":"태백시","target":"태백시 소재 중소기업으로서 태백시장의 융자추천을 받은 자","useage":"운전 및 시설","limit":"8억원 이내","rate":"5.00%","institute":"태백시","mgmt":"동해지점","reception":"전영업점"},{"region":"하남시","target":"하남시 소재 중소기업으로서 하남시장의 추천을 받은 자","useage":"운전","limit":"2억원 이내","rate":"1.50%","institute":"하남시","mgmt":"하남지점","reception":"하남시에서 취급점으로 지정한 영업점"},{"region":"화성시","target":"화성시 소재 중소기업으로서 화성시장이 추천한 자(소상공인은 화성시 소재 소상공인으로서 경기신용보증재단이 추천한 자)","useage":"운전","limit":"2억원 이내","rate":"2.00%","institute":"화성시, 경기신용보증재단","mgmt":"화성남양지점","reception":"전영업점"},{"region":"횡성군","target":"횡성군 소재 중소기업으로서 횡성군수의 융자 추천을 받은 자","useage":"운전","limit":"1억원 이내","rate":"4.00%","institute":"횡성군","mgmt":"원주지점","reception":"횡성군이 지정한 영업점"},{"region":"농림축산식품부","target":"농림수산식품부장관의 융자추천을 받은 기업","useage":"운전","limit":"추천금액 이내","rate":"3.53%","institute":"농림수산식품부","mgmt":"여신기획부","reception":"전영업점"},{"region":"중소기업진흥공단","target":"중소기업진흥공단에서 융자 추천서를 발급받은 자","useage":"운전","limit":"5억원 이내","rate":"2.00%","institute":"중소기업진흥공단","mgmt":"여신기획부","reception":"전영업점"},{"region":"한국방송통신전파진흥원","target":"한국방송통신전파진흥원으로부터 추천을 받은 기업","useage":"운전 및 시설","limit":"추천금액 이내","rate":"1.50%~3.86%","institute":"한국방송통신전파진흥원","mgmt":"여신기획부","reception":"전영업점"},{"region":"한국장애인고용공단","target":"한국장애인고용공단의 추천을 받은 자","useage":"시설","limit":"추천금액 이내","rate":"4.00%","institute":"한국장애인고용공단","mgmt":"여신기획부","reception":"전영업점"},{"region":"기술신용보증기금","target":"기보에서 발행한 ‘기술신용정보(TCB)’의 기술신용등급이 신용등급(기보 기준)보다 높은 기업, 기보에서 발행한 ‘기술신용정보(TCB)’의 기술등급이 T4등급 이상인 기업","useage":"운전","limit":"5억원 이내","rate":"1.00%~3.00%","institute":"기술신용보증기금","mgmt":"여신기획부","reception":"전영업점"},{"region":"소상공인시장진흥공단","target":"소상공인시장진흥공단 및 지방자치단체에서 추천한 소상공인","useage":"운전","limit":"1억원 이내","rate":"2.50%~3.30%","institute":"소상공인시장진흥공단","mgmt":"여신기획부","reception":"전영업점"},{"region":"근로복지공단","target":"근로복지공단으로부터 “고용환경개선” 용도로 자금추천을 받은 자","useage":"시설","limit":"추천금액 이내","rate":"4.00%","institute":"근로복지공단","mgmt":"여신기획부","reception":"전영업점"},{"region":"국토교통부","target":"업무용 부동산(비거주용)에 대하여 에너지 성능개선을 위한 리모델링을 구상 또는 실행중인 기업으로 국토교통부의 융자추천을 받은 기업","useage":"시설","limit":"50억원 이내","rate":"2.00%~4.00%","institute":"한국토지주택공사","mgmt":"여신기획부","reception":"전영업점"},{"region":"안양상공회의소","target":"안양상공회의소에서 추천하는 자","useage":"운전","limit":"1억원 이내","rate":"1.00%","institute":"안양상공회의소","mgmt":"여신기획부","reception":"전영업점"}]


----
## 3. 지원하는 지자체 명을 입력받아 해당 지원정보를 출력하는 API

[해결]]

- 입력받은 지자체명으로 지자체지원정보 테이블과 지자체테이블을 지자체코드로 조인을 하여 조회한다.

[실행방법] 

- GET방식
- 실행 url : http://localhost:8080/selectOneShowUploadCSV/강원도
- 실행결과 : [{"region":"강원도","target":"강원도 소재 중소기업으로서 강원도지사가 추천한 자","useage":"운전","limit":"8억원 이내","rate":"3.00%~5.00%","institute":"강원도","mgmt":"춘천지점","reception":"강원도 소재 영업점"}]


----
## 4. 지원지자체 정보 수정하는 API

[해결]

- 수정할 지자체명과 정보를 입력해서 실행한다.
- 입력받은 지자체명에 해당하는 정보를 조회하여, 기존데이터를 수정한다.

[실행방법] 

- POST방식
- 실행 url : http://localhost:8080/updateUploadCSV
    {
        "region": "강원도",
        "target": "updated name is topics3",
        "useage": "updated this is description3",
        "limit": "9억원 이내",
        "rate": "5%",
        "institute": "updated this is description3",
        "mgmt": "강원도",
        "reception": "updated name is topics3"
    }
- 실행결과 : 정상처리되었습니다.
그 후에 다시 http://localhost:8080/selectOneShowUploadCSV/강원도 로 조회 

강원도의 지자체정보가 변경된것을 확인함.

[{"region":"강원도","target":"updated name is topics3","useage":"updated this is description3","limit":"9억원 이내","rate":"0.00%~5.00%","institute":"updated this is description3","mgmt":"강원도","reception":"updated name is topics3"}]



----
## 5. 최대 지원금액순으로 지자체명을 K개수만큼 출력하는 API

[해결]

- 지원금액컬럼을 내림차순으로 정렬하고 각 지원금액에 해당하는 정보 개수를 구한다.
- 지원금액으로 해당 정보를 조회후 이차보전의 평균값의 적은 순으로 정렬해여 list에 넣는다.
- 출력할 list가 K개수만큼 차면 실행을 종료하고 결과를 출력한다.

[실행방법]

- GET방식
- 실행 url : http://localhost:8080/selectMinRateIns
- 실행 결과 : 이차보전 비율이 가장 작은 추천 기관명 : 안양상공회의소





----
## 6. 이차보전 컬럼에서 보전 비율이 가장 작은 기관명 출력하는 API

[해결]

- 지자체정보 테이블에서 이차보전 컬럼을 minrate와 maxrate로 나눠서 적재했다.
- 가작 적은 비율을 구하는 것이므로 maxrate가 제일 적은 기관명을 조회하여 출력한다.

[실행방법] 

- GET방식
- 실행 url : http://localhost:8080/selectMaxLimit/20
- 실행 결과 : ["한국방송통신전파진흥원","강릉시","농림축산식품부","근로복지공단","한국장애인고용공단","경기도","제주도","국토교통부","인천광역시","안양시","대구광역시","안산시","강원도","경상남도","춘천시","태백시","창원시","세종특별자치시","남양주시","충청북도"]





감사합니다.



