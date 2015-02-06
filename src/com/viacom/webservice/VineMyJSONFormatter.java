package com.viacom.webservice;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * JSON Parser for the API call necessary, we extract the desired data
 * @author sumansucharitdas
 *
 */
public class VineMyJSONFormatter {
	
	private JSONObject vineObj;
	private final String TAG_CODE = "code";
	private final String TAG_DATA = "data";
	private final String TAG_COUNT = "count";
	private final String TAG_ANCH = "anchorStr";
	private final String TAG_RECORDS = "records";
	private final String TAG_VIDEO = "videoUrl";
	private final String TAG_THUMBNAIL = "thumbnailUrl";
	private final String TAG_DESCRIPTION = "description";
	private final String TAG_USERNAME = "username";
	private final String TAG_CREATED = "created";
	private final String TAG_ERROR = "error";
	private final String TAG_SUCCESS = "success";
	
	public static List<String> videoURLs = new ArrayList<String>();
	public static List<String> thumbnailURLs= new ArrayList<String>();
	public static List<Bitmap> thumbnails = new ArrayList<Bitmap>();
	public static List<String> descriptions = new ArrayList<String>();
	public static List<String> usernames = new ArrayList<String>();
	
	// Code that specify API call is successful or failed
	private String code;
	private String error;
	
	
	public VineMyJSONFormatter(String string, Context mainAppContext) {
		try {
			JSONObject json =  new JSONObject(string);
			setVineObj(json, mainAppContext);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public JSONObject getVineObj() {
		return vineObj;
	}

	/**
	 * Format
	 * @param vineObj: the response JSON
	 * @param mainAppContext : The applications that launched the query
	 */
	public void setVineObj(JSONObject vineObj, Context mainAppContext) {
		this.vineObj = vineObj;
		try {
			String code = this.vineObj.getString(TAG_CODE);
			String error = this.vineObj.getString(TAG_ERROR);
			String success = this.vineObj.getString(TAG_SUCCESS);
			JSONObject data = this.vineObj.getJSONObject(TAG_DATA);
			int count1 = data.getInt(TAG_COUNT);
			String anchor = data.getString(TAG_ANCH);
			JSONArray records = data.getJSONArray(TAG_RECORDS);
			for (int i = 0 ; i < records.length(); i++){
				if("".equals(code)){
					JSONObject record = records.getJSONObject(i);
					videoURLs.add(record.getString(TAG_VIDEO));
					thumbnailURLs.add(record.getString(TAG_THUMBNAIL));
					descriptions.add(record.getString(TAG_DESCRIPTION));
					usernames.add(record.getString(TAG_USERNAME) + "\n" + "Created on : " 
							+ record.getString(TAG_CREATED).replace("T", " "));
					thumbnails.add(getBitmapFromURL(record.getString(TAG_THUMBNAIL)));
				}
				setCode(code);
				setError(error);
			}
			System.out.print("Reponse Result is " + success);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Download the URL for display purpose
	 * @param src : The link
	 * @return : The bitmap Image
	 */
	public Bitmap getBitmapFromURL(String src) {
	    try {
	        java.net.URL url = new java.net.URL(src);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setDoInput(true);
	        connection.setRequestMethod("GET");
	        InputStream input = connection.getInputStream();
	        Bitmap myBitmap = BitmapFactory.decodeStream(input);
	        return myBitmap;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	/**
	 * Getters and Setters for the API Response Result 
	 */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
