package com.example.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONObject;

import com.example.myvine.VineActivity;
import com.example.ui.ListViewerActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

public class DownloadTimelines extends AsyncTask<JSONObject, Void, ProcessedVineDataValues>{
	private Context mainAppContext;
	
	public DownloadTimelines(Context cxt) {
		mainAppContext = cxt.getApplicationContext();
		
	}
	
	@Override
	protected ProcessedVineDataValues doInBackground(JSONObject... params) {
		URL url;
		HttpURLConnection connection = null;
		try {
			url = new URL("https://vine.co/api/timelines/users/918753190470619136");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			int responseCode = connection.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
	 
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
	 
			//print result
			System.out.println(response.toString());
			
			//ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
			//ProcessedVineData vineData = gson.fromJson(x, ProcessedVineData.class);
					// mapper.readValue(response.toString(), ProcessedVineData.class);
			//System.out.println(gson.toString());
			
			VineMyJSONFormatter vine =  new VineMyJSONFormatter(response.toString());
			ProcessedVineDataValues processedVineDataValues = new ProcessedVineDataValues();
			processedVineDataValues.thumbnailURLs = vine.thumbnailURLs;
			processedVineDataValues.videoURLs =  vine.videoURLs;
			return processedVineDataValues;
			
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			connection.disconnect();
		}
		
		return null;
	}
	
	@Override
	protected void onPostExecute(ProcessedVineDataValues result) {
		if(VineActivity.progressDialog.isShowing()){
			VineActivity.progressDialog.dismiss();
		}
		Intent myIntent = new Intent(mainAppContext, ListViewerActivity.class);
		myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		mainAppContext.startActivity(myIntent);
	}
}
