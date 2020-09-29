package com.example.usStore.controller.mypage;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.sun.xml.messaging.saaj.packaging.mime.internet.ParseException;

@Controller
public class SearchUnivController {

	private static RestTemplate restTemplate = new RestTemplate();
	private static List<String> schNameList = null;

	@RequestMapping("/searchUniv.do")
	public String handleRequest() throws Exception {
		
		return "account/searchUniv";  //외부 api 쓰는 팝업창 보여주기 
	}
	
	@RequestMapping("/api/university.do")
	//@ResponseBody
	public String findUniversity(@ModelAttribute SearchUniv searchUniv,
			Model model) throws Exception {

		String region = searchUniv.getRegion();
		String searchSchulNm = searchUniv.getUnivName();

		int regionCode = UnivRegionEnum.getCode(region);
		System.out.println(regionCode + " : " + searchSchulNm);
		
		String uri = "http://www.career.go.kr/cnet/openapi/getOpenApi?"
				+ "apiKey=64d783f84c56facec82aef2ec57357ee&svcType=api&svcCode=SCHOOL&contentType=json&gubun=univ_list"
				+ "&searchSchulNm="+searchSchulNm;
		
		if (regionCode != -1) { //선택하세요 아닐 때 
			uri += "&region="+regionCode;
			return "redirect:/searchUniv.do";
		}
		
		//open api 요청
		String body = restTemplate.getForObject(uri, String.class);
		System.out.println("body : " + body);
		
		parsing(body);
		if (schNameList != null) {  //null이면 result란 객체가 없는거????? 다시 생각하기 
			model.addAttribute("results", schNameList);
		}else {
			System.out.println("결과가 없다...");
		}

		DataSearch data = restTemplate.getForObject(uri, DataSearch.class);
		System.out.println(data.toString()); //리스트를 아예 못읽어옴 
//		System.out.println(dataSearch.getContents());


		//model로 가는 결과가 여러개인것을 주의하자
		// list로 결과 보내서 select로?? 선택할수 있게 결과 띄어주기 
		
		return "account/searchUniv";  //외부 api 쓰는 팝업창 (대학교 이름 결과 보내주기)
	}

	//public String 
	
	
	
	
	
	private static void parsing(String result) throws ParseException, Exception {

			System.out.println("parsing 메소드 진입");

			JSONParser jsonparser = new JSONParser();
	        JSONObject jsonobject = (JSONObject)jsonparser.parse(result); // Json 객체로 만들어줌
	        System.out.println("jsonobject : " + jsonobject.toJSONString());

	        JSONObject dataSearch =  (JSONObject) jsonobject.get("dataSearch");
	        System.out.println("dataSearch : "  + dataSearch.toJSONString());

	        JSONArray content = (JSONArray)dataSearch.get("content");
	        System.out.println("content : " + content.toJSONString());

	        schNameList = new ArrayList<String>();
	        
	        for(int i = 0 ; i < content.size(); i++){
	            JSONObject entity = (JSONObject)content.get(i);
	            String schoolName = (String) entity.get("schoolName");
	            System.out.println("학교 이름 결과 : " + schoolName);
	            schNameList.add(schoolName);
	        }

		}


}
