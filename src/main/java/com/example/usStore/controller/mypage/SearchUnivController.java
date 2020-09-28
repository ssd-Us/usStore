package com.example.usStore.controller.mypage;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

@Controller
public class SearchUnivController<jsonnode> {

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
		String urlstr = "https://www.career.go.kr/cnet/openapi/getOpenApi?apiKey=64d783f84c56facec82aef2ec57357ee&svcType=api&svcCode=SCHOOL&contentType=json&gubun=univ_list&region=100260&searchSchulNm=동덕";
		URL url = new URL(urlstr);
		String readBuffer = readUrl(url);
		System.out.println("readBuffer : " + readBuffer); // 스트링으로 결과 나오면 json으로 파싱해서 University 객체에 값 넣어줘야함
//		parsing(readBuffer);


		//model로 가는 결과가 여러개인것을 주의하자
		// list로 결과 보내서 select로?? 선택할수 있게 결과 띄어주기 
		model.addAttribute("result", "동덕여자대학교");
		return "account/searchUniv";  //외부 api 쓰는 팝업창 (대학교 이름 결과 보내주기)
	}

	private static String readUrl(URL url) throws IOException {
		InputStream stream = null;
		HttpsURLConnection conn = null;
		String result = null;
//		BufferedInputStream reader = null;
//		try {
//			reader = new BufferedInputStream(url.openStream());
//			StringBuffer buffer = new StringBuffer();
//			int i;
//			byte[] b = new byte[4096];
//			while ((i = reader.read(b)) != -1) {
//				buffer.append(new String(b, 0, i));
//			}
//			return buffer.toString();
//		} finally {
//			if (reader != null) {
//				reader.close();
//			}
//		}
		try {
			conn = (HttpsURLConnection) url.openConnection();
			conn.setReadTimeout(3000);
			conn.setConnectTimeout(3000);
			conn.setRequestMethod("GET");
			conn.setDefaultUseCaches(false);
			conn.setRequestProperty("content-type", "application/json;charset=UTF-8");
			conn.setDoInput(true);
			conn.connect();
			int responseCode = conn.getResponseCode();
			if (responseCode != HttpsURLConnection.HTTP_OK){
				throw new IOException("HTTP error code: " + responseCode);
			}

			stream = conn.getInputStream();
			System.out.println("stream : " + stream);
			System.out.println("stream2 : " + stream.toString());


			if (stream != null){
				result = readStream(stream); //Stream -> String -> JSON
			}

		}finally {
			if(stream != null) {
				stream.close();
			}
			if(conn != null){
				conn.disconnect();
			}
		}
		return result;
	}

	private static String readStream(InputStream stream){
		StringBuilder result = new StringBuilder();

		try {
			InputStreamReader inputStreamReader = new InputStreamReader(stream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String readLine = bufferedReader.readLine();
			System.out.println(readLine);
			while(readLine != null){
				result.append(readLine + "\n");
				readLine = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result.toString();
	}

		private static void parsing(String result) throws ParseException, Exception {

			System.out.println("parsing 메소드 진입");

			JSONParser jsonparser = new JSONParser();
	        JSONObject jsonobject = (JSONObject)jsonparser.parse(result); // Json 객체로 만들어줌
	        System.out.println("jsonobject : " + jsonobject.toJSONString());

	        JSONObject dataSearch =  (JSONObject) jsonobject.get("dataSearch");
	        System.out.println("dataSearch : "  + dataSearch.toJSONString());

	        JSONArray content = (JSONArray)dataSearch.get("content");
	        System.out.println("content : " + content.toJSONString());

	        for(int i = 0 ; i < content.size(); i++){
	            JSONObject entity = (JSONObject)content.get(i);
	            String schoolName = (String) entity.get("schoolName");
	            System.out.println("학교 이름 결과 : " + schoolName);
	        }

		}


}
