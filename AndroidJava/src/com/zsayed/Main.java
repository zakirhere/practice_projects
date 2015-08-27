package com.zsayed;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by ZSayed on 7/9/2015.
 */
public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        
    }
    
    public static long getElapsedTime(String RecordedTime) throws ParseException {
//    	String RecordedTime = "2015-07-24T21:34:55.000-04:00";
    	RecordedTime = RecordedTime.replaceFirst("T", " ");
    	String getTimeStamp = RecordedTime.substring(0, 19);

    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date myDateStamp = format.parse(getTimeStamp);
    	Date currentDateStamp = new Date();

    	long timeDiff = currentDateStamp.getTime() - myDateStamp.getTime();
    	return timeDiff/1000 + 60;
    }
    
    public static String displayTimeDiff(long timeInSeconds) {
    	int getMins = 0;
    	int getSeconds = 0;
    	if(timeInSeconds > 59) {
    		getMins = (int) (timeInSeconds/60);
    		getSeconds = (int) (timeInSeconds % 60);
    	}
    	else {
    		return Integer.toString((int) timeInSeconds) + " (seconds)";
    	}
    	
    	return Integer.toString(getMins) + ":" + Integer.toString(getSeconds) + " (min:sec)";
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


