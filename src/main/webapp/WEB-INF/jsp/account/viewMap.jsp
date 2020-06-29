<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div id="map" style="width:500px;height:400px;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	16f579279a1287e67ce21e5500798017&libraries=services,clusterer,drawing"></script>
<script>

		var x1 = 127.0428;
		var y1 = 37.6065;

		var x2 = 127.0427;
		var y2 = 37.6064;
		
		var ps = new kakao.maps.services.Places(); //마커
		var infowindow = new kakao.maps.InfoWindow({zIndex:1});

		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center: new kakao.maps.LatLng(y1, x1), //지도의 중심좌표. 동덕여자대학교 디폴트 판매자의 위치 
			level: 3 //지도의 레벨(확대, 축소 정도)
		};

		var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
		
		// 마커가 표시될 위치입니다 -판매자의 마커와 유저의 마커 두개 만들기 
		var markerPosition1  = new kakao.maps.LatLng(y1, x1); 
		var markerPosition2  = new kakao.maps.LatLng(y2, x2); 
		
		// 마커를 생성합니다
		var marker1 = new kakao.maps.Marker({
		    position: markerPosition1
		});

		var marker2 = new kakao.maps.Marker({
		    position: markerPosition2
		});

		// 마커가 지도 위에 표시되도록 설정합니다
		marker1.setMap(map);
		marker2.setMap(map);
		

</script>
