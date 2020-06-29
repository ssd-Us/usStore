<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<div id="map" style="width:500px;height:400px;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	16f579279a1287e67ce21e5500798017&libraries=services"></script>
<script>

		var ps = new kakao.maps.services.Places(); //마커
		var infowindow = new kakao.maps.InfoWindow({zIndex:1});

		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
			level: 3 //지도의 레벨(확대, 축소 정도)
		};

		var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

		function searchLocation(){ //장소 검색 객체를 생성합니다
			var loc = $("#searchLoc").val();
			ps.keywordSearch(loc, placesSearchCB);
		}

		//키워드 검색 완료 시 호출되는 콜백함수
		function placesSearchCB(data, status, pagination){
			if(status == kakao.maps.services.Status.OK){

				var bounds = new kakao.maps.LatLngBounds();

				for(var i = 0; i < data.length; i++){
					displayMarker(data[i]);
					bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
				}

				//검색된 장소 위치를 기준으로 재설정 
				map.setBounds(bounds);
			}
	
		}

		// 지도에 마커를 표시하는 함수
		function displayMarker(place){

			var marker = new kakao.maps.Marker({
				map: map,
				positon: new kakao.maps.LatLng(place.y, place.x)
			});
			//마커에 클릭이벤트를 등록
			kakao.maps.event.addListener(marker, 'click',
					 function(){
							infowindow.setContent('<div style="padding:5px;font-size:12px;">'
											+ place.place_name + '</div>');
							infowindow.open(map, marker);
					  }
			);
			
		}







</script>
