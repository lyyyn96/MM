package com.proto.mm.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.proto.mm.model.Movie;

@Service
public class ChattingService {
	public static ArrayList<Movie> movieList = new ArrayList<Movie>();
	public static boolean flag;

	public static String MM_Chat(Model model,HttpServletRequest request,
 			HttpServletResponse response) {
    	 
    	String requestMessage = request.getParameter("chat");
        String chatbotMessage = "";
        
        System.out.println(requestMessage);
        try {
            String apiURL = "https://7a47b2dd7e4f474c9f005449eea5498a.apigw.ntruss.com/custom/v1/4538/cb0d389e53c35e44cd04b1cd16c8aa634346534bc939545a1a7581a164ece9d9";

            URL url = new URL(apiURL);

           // String voiceMessage="문 열어요?";
            String message = getReqMessage(requestMessage);
            //System.out.println("##" + message);

            String secretKey="TnpGRHVmaHd6bVNRc3JTZkNRRk9oeUdOc251eG1PUUM=";
            String encodeBase64String = makeSignature(message, secretKey);

            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json;UTF-8");
            con.setRequestProperty("X-NCP-CHATBOT_SIGNATURE", encodeBase64String);

            // post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.write(message.getBytes("UTF-8"));
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();

            BufferedReader br;

            if(responseCode==200) { // Normal call
                //System.out.println(con.getResponseMessage());

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                con.getInputStream(),"UTF-8"));
                String decodedString;
                while ((decodedString = in.readLine()) != null) {
                    chatbotMessage = decodedString;
                }
                //chatbotMessage = decodedString;
                in.close();

            } else {  // Error occurred
                chatbotMessage = con.getResponseMessage();
            }     
            System.out.println(chatbotMessage);
            
            JSONObject o=new org.json.JSONObject(chatbotMessage);
            JSONArray bubbles=o.getJSONArray("bubbles");
            JSONObject bubbles0=bubbles.getJSONObject(0);
            JSONObject data=bubbles0.getJSONObject("data");
            String description=(String) data.get("description");
            System.out.println("--->"+description);
            
            
            if(description.contains("어떤 장르")){
                JSONArray slot=bubbles0.getJSONArray("slot");
                Movie p=new Movie();
                slot.forEach((item)->{
                    System.out.print("item:"+item+"\t"+p+"\n");
                    JSONObject jo=(JSONObject)item;
                    String name=jo.getString("name");
                    if(name.contains("커피종류")){
                        p.setProduct_name(jo.getString("value"));
                    }else if(name.contains("커피온도")){
                        p.setProduct_name(jo.getString("value")+" "+p.getProduct_name());
                    }else if(name.contains("커피수량")){
                        String quantity_str=jo.getString("value");
                        int quantity=0;
                        if(quantity_str.contains("한")){
                            quantity=1;
                        }else if(quantity_str.contains("두")){
                            quantity=2;
                        }else if(quantity_str.contains("세")){
                            quantity=3;
                        }else if(quantity_str.contains("네")){
                            quantity=4;
                        }else if(quantity_str.contains("다섯")){
                            quantity=5;
                        }else{
                            System.out.println("커피수량 입력 오류");
                        }
                        p.setQuantity(quantity);                        
                    }
                });//end foreach
                productList.add(p);
            }
            return description;
        } catch (Exception e) {
            System.out.println(e);
            return "죄송합니다. 다시 입력해주세요";
        }       
        
    }

    public static String makeSignature(String message, String secretKey) {

        String encodeBase64String = "";

        try {
            byte[] secrete_key_bytes = secretKey.getBytes("UTF-8");

            SecretKeySpec signingKey = new SecretKeySpec(secrete_key_bytes, "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);

            byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
            encodeBase64String = Base64.getEncoder().encodeToString(rawHmac);//0x00000002
            System.out.println(encodeBase64String);


            return encodeBase64String;

        } catch (Exception e){
            System.out.println(e);
        }

        return encodeBase64String;

    }

    public static String getReqMessage(String voiceMessage) {

        String requestBody = "";

        try {

            JSONObject obj = new JSONObject();

            long timestamp = new Date().getTime();

            //System.out.println("##"+timestamp);

            obj.put("version", "v2");
            obj.put("userId", "U47b00b58c90f8e47428af8b7bddc1231heo2jes");
//=> userId is a unique code for each chat user, not a fixed value, recommend use UUID. use different id for each user could help you to split chat history for users.

            obj.put("timestamp", timestamp);

            JSONObject bubbles_obj = new JSONObject();

            bubbles_obj.put("type", "text");

            JSONObject data_obj = new JSONObject();
            data_obj.put("description", voiceMessage);

            bubbles_obj.put("type", "text");
            bubbles_obj.put("data", data_obj);

            JSONArray bubbles_array = new JSONArray();
            bubbles_array.put(bubbles_obj);

            obj.put("bubbles", bubbles_array);
            obj.put("event", "send");

            requestBody = obj.toString();

        } catch (Exception e){
            System.out.println("## Exception : " + e);
        }

        return requestBody;

    }
    

}