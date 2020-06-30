<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div id="map" style="width:500px;height:400px;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	16f579279a1287e67ce21e5500798017&libraries=services,clusterer,drawing"></script>

<!-- 판매자의 대학교는 판매자 userId로 getAccountByUserId().getUniversity() -->
<script>
		var x1 = 127.0428;
		var y1 = 37.6065;
		
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center: new kakao.maps.LatLng(y1, x1), //지도의 중심좌표. 동덕여자대학교 디폴트 판매자의 위치 
			level: 3 //지도의 레벨(확대, 축소 정도)
		};

		var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();

		//애초에 회원가입할 때 대학에 도로명 주소를 입력하면..된다..? 
		//var uni = '성내로80'; 
		var uni = "${university}"; //실제 판매자 대학교의 도로명 주소 
		alert(test);
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch(uni, function(result, status) {

		    // 정상적으로 검색이 완료됐으면 
		     if (status === kakao.maps.services.Status.OK) {

		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords
		        });

		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new kakao.maps.InfoWindow({
		            content: '<div style="width:150px;text-align:center;padding:6px 0;">판매자 대학교</div>'
		        });
		        infowindow.open(map, marker);

		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
		    } 
		});    
		
/* 		// 마커가 표시될 위치입니다 -판매자의 마커와 유저의 마커 두개 만들기 
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
		marker2.setMap(map); */
		

</script>
