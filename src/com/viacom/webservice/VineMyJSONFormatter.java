package com.viacom.webservice;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class VineMyJSONFormatter {
	
	private JSONObject vineObj;
	private final String TAG_CODE = "code";
	private final String TAG_DATA = "data";
	private final String TAG_COUNT = "count";
	private final String TAG_ANCH = "anchorStr";
	private final String TAG_RECORDS = "records";
	private final String TAG_VIDEO = "videoUrl";
	private final String TAG_THUMBNAIL = "thumbnailUrl";
	
	public static List<String> videoURLs = new ArrayList<String>();
	public static List<String> thumbnailURLs= new ArrayList<String>();
	public static List<Bitmap> thumbnails = new ArrayList<Bitmap>();
	
	public VineMyJSONFormatter(String string) {
		try {
			JSONObject json =  new JSONObject(string);
			setVineObj(json);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public JSONObject getVineObj() {
		return vineObj;
	}

	public void setVineObj(JSONObject vineObj) {
		this.vineObj = vineObj;
		try {
			String code = this.vineObj.getString(TAG_CODE);
			JSONObject data = this.vineObj.getJSONObject(TAG_DATA);
			int count1 = data.getInt(TAG_COUNT);
			String anchor = data.getString(TAG_ANCH);
			JSONArray records = data.getJSONArray(TAG_RECORDS);
			for (int i = 0 ; i < records.length(); i++){
				JSONObject record = records.getJSONObject(i);
				videoURLs.add(record.getString(TAG_VIDEO));
				thumbnailURLs.add(record.getString(TAG_THUMBNAIL));
				thumbnails.add(getBitmapFromURL(record.getString(TAG_THUMBNAIL)));
			}
			
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
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
}
