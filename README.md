# DVIS_Prototype
디미고 투표관리시스템(DVIS) 관리자 모듈 개발입니다.

디미고 출구조사/실시간 개표 정보 시스템(DVIS) 프로젝트 계획서

기획자: 한국디지털미디어고등학교 해킹방어과 3학년 5반 이은찬
작성일자: 2016 / 05 / 09
DVIS ( Dimigo Vote Information System )
서론
 본 프로젝트는 3학년 교육과정에 편성되어 있는 확률과 통계, 모바일 프로그래밍, 웹 프로그래밍, DB 실습을 위한 자발적 학교 공익 프로젝트이며 기획자의 경험적인 목적과 공익을 위해 만들어진다.

개발자 : 이은찬, DIMIGOIN 개발진
개발기간 : 5월 초 ~ 선거 2주전
테스트 기간 : 선거 1주 전까지

기대 효과
 출구조사와 실시간 개표 시스템을 구축함으로써 디미고 학생들의 전체적인 학생회에 대한 관심을 높여주고 알 권리를 보장할 수 있다. 또한 개발자 개인적인 관점에서는 전문교과를 제대로 적용할 수 있는 훌륭한 실습이 되며 확률과 통계의 통계 부분을 이용해 응용함으로써 창의적인 생각을 기를 수 있고 복습을 겸할 수 있다.
 
시스템 구상
 DB: 실질적인 데이터를 보관함. 교내 DB를 요청할 계획
 외부 Web: 지금은 직접 웹사이트 개발을 생각하고 있지 않으며 DB 데이터를 로드해 보여줄 수 있는 DIMIGO.IN 개발진들을 만나 관련 개발을 논의할 계획

MM
(Management Module)

외부 Web
 APP: 출구조사 APP, 실시간개표 APP을 따로 개발하여 실시간으로 DB에 데이터를 업데이트할 수 있게 할 예정
 MM(Management Module): 관리 모듈으로서 DB와 APP의 데이터를 조회하고 수치가 아닌 다른 데이터를 관리함 

출구조사 계획
 표본: 선거를 마치고 나오는 유권자 54명 대상(한 반당 남자 2명, 여자 1명 임의추출)
	(미응답자가 있어 출구조사의 신뢰성을 보장하지 못할 수 있으므로 향후 상세 계획에서 	자세히 정할 예정)
 신뢰구간: 10~ 18% 예상
 
 선거 후 직접 물어보아 얻은 결과를 APP으로 입력하여 통계적 추정 실시하고 결과를 데이터베이스로 보냄.

 이를 위해 학생부 선거관리위원회의 허가 및 협조를 구할 필요가 있음
 이를 위해 교내 DBA의 허가를 맡을 필요가 있음


실시간 개표정보 시스템 계획
 선거가 진행되는 동안 APP으로 실시간 득표수를 입력하여 DB로 보냄. 외부 사이트는 이 DB를 참조하여 실시간으로 득표 현황을 파악하여 웹사이트에 보여주게 할 예정임. 이를 위해 개발 전 사전 모임 및 회의가 필요하며 조정이 필요할 수 있음.

 이를 위해 학생부 선거관리위원회의 허가 및 협조를 구할 필요가 있음
 이를 위해 교내 DBA의 허가를 맡을 필요가 있음