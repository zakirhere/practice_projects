package com.zsayed;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by ZSayed on 7/9/2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        
    	String input_file = String.join("\n", Files.readAllLines(Paths.get("C://Users//zsayed//Desktop//deleteme.json")));

        //System.out.println(input_file);
//        parseJSON(input_file);
        
    	JSONObject json = new JSONObject(input_file);
    	
    	String parser_string = "posts.comments[0].cm1()";
        System.out.println(smartJsonParser(json, parser_string));
        
        
    }

    public static void parseJSON(String responseText) {
        // Convert String to json object
        JSONObject json = new JSONObject(responseText);
        JSONObject json_LL = json.getJSONObject("posts");

        JSONArray j_ary = json_LL.getJSONArray("comments");
        String str_value=j_ary.getJSONObject(0).getString("cm1"); //<< get value here
        
        System.out.println(str_value);
    }
    
    
    public static myResult getArrayValues(String elm) {
//    	String elm = "jsonArray[5]";
		String[] splitted = elm.split(Pattern.quote("["));
		System.out.println(splitted[0]);
		int Index = Integer.parseInt(splitted[1].replaceAll(Pattern.quote("]"), ""));
		System.out.println(Index);
		
		return new myResult(splitted[0], Index);
    }
    
    public static String smartJsonParser(JSONObject json, String jsonPath) {

    	String[] jsonElements = jsonPath.split("[.]");
    	for(String elm: jsonElements) {
    		if(elm.endsWith("()")) {
    			return json.getString(elm.replaceAll("[()]", ""));
    		}
    		else if(elm.endsWith("]")) {
    			myResult splitted = getArrayValues(elm);
    			JSONArray j_arry = json.getJSONArray(splitted.getName());
    			json = j_arry.getJSONObject(splitted.getIndex()); //<< get value here
    	        
    		}
    		else {
    			json = json.getJSONObject(elm);
    	    	
    		}
    	}
    	
    	return "not found";
    }
    

}


