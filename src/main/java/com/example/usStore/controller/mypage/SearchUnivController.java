package com.example.usStore.controller.mypage;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchUnivController {
	
	static String urlstr;
	
	@RequestMapping("/searchUniv.do")
	public String handleRequest() throws Exception {
		
		return "account/searchUniv";  //외부 api 쓰는 팝업창 보여주기 
	}
	
	@RequestMapping("/api/university.do")
	public String findUniversity(@ModelAttribute SearchUniversity searchUniv,
			Model model) throws Exception {

		String region = searchUniv.getRegion();
		String searchSchulNm = searchUniv.getUnivName();
		//ArrayList<String> results = new ArrayList<String>(); // 대학교 검색 결과 여러개 담

		int regionCode = UnivRegionEnum.getCode(region);
		System.out.println(regionCode + " : " + searchSchulNm);
		if (regionCode == -1) { //선택하세요 클릭 시에 리다이렉트 해주기 
			return "redirect:/searchUniv.do";
		}
		
		//open api 사용 
		urlstr = "http://www.career.go.kr/cnet/openapi/getOpenApi?apiKey=64d783f84c56facec82aef2ec57357ee&svcType=api&svcCode=SCHOOL&contentType=json&gubun=univ_list&region=100260&searchSchulNm=동";

		parsing2();
		//urlConnection();
	
		//model로 가는 결과가 여러개인것을 주의하자
		// list로 결과 보내서 select로?? 선택할수 있게 결과 띄어주기 
		model.addAttribute("result", "동덕여자대학교");
		return "account/searchUniv";  //외부 api 쓰는 팝업창 (대학교 이름 결과 보내주기)
	}
	
//	private static void urlConnection() throws IOException {
//		
////		URL url = new URL(urlstr);
////		BufferedReader reader = null;
////		
////		HttpURLConnection con = (HttpURLConnection) url.openConnection();
////		con.setRequestMethod("GET");
////		con.setReadTimeout(1000);
////		con.connect();
////		
////		reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF8"));
////		
////		String inputLine = null;
////		while((inputLine = reader.readLine()) != null){
////			System.out.println("inputLine: " + inputLine);
////			
////		}
////		reader.close();
//	}
	
	
	  
	private static String readUrl() throws Exception {
		  
	        BufferedInputStream reader = null;
	        try {
	            URL url = new URL(urlstr);
	        
	            reader = new BufferedInputStream(url.openStream());
	            StringBuffer buffer = new StringBuffer();
	            int i;
	            byte[] b = new byte[4096];
	            while( (i = reader.read(b)) != -1){
	              buffer.append(new String(b, 0, i));
	            }
	            System.out.println("readUrl() : " + buffer.toString());
	            return buffer.toString();
	        } finally {
	            if (reader != null)
	                reader.close();
	        }
	    }
	
		private void parsing() throws ParseException, Exception {
			
			System.out.println("parsing 메소드 진입");
			
	        JSONParser jsonparser = new JSONParser();
	        JSONObject jsonobject = (JSONObject)jsonparser.parse(readUrl()); // Json 객체로 만들어줌 
	        System.out.println("jsonobject : " + jsonobject.toJSONString());
	        
	        JSONObject json =  (JSONObject) jsonobject.get("dataSearch");
	        System.out.println("json : "  + json.toJSONString());
	        
	        JSONArray array = (JSONArray)json.get("content");
	        System.out.println("array : " + array.toJSONString());
	        
	        for(int i = 0 ; i < array.size(); i++){
	            JSONObject entity = (JSONObject)array.get(i);
	            String schoolName = (String) entity.get("schoolName");
	            System.out.println("학교 이름 결과 : " + schoolName);
	        }
	        
		}
		
		
		private void parsing2() throws UnsupportedEncodingException, IOException {
			/* 공통부분 */
			URL url = new URL(urlstr);
			InputStreamReader isr = new InputStreamReader(url.openConnection().getInputStream(), "UTF-8");
			JSONObject object = (JSONObject)JSONValue.parse(isr);

			/* Object로 받을 경우 */
			JSONObject dataSearch = (JSONObject) object.get("dataSearch");
			JSONObject content = (JSONObject) dataSearch.get("content");
			System.out.println(content.toString());
			

			/* Array로 받을 경우 */
			JSONArray contentArray = (JSONArray) object.get("content");
			for(int i = 0 ; i < contentArray.size(); i++) 
			{
				JSONObject data = (JSONObject) contentArray.get(i);        
				System.out.println(data.get("schoolName").toString());
			}

			
		}
		
}
