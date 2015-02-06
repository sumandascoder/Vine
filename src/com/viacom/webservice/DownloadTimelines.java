package com.viacom.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;

import com.example.myvine.R;
import com.viacom.ui.ListViewerActivity;
import com.viacom.ui.VineActivity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.Settings;
import android.view.ContextThemeWrapper;

public class DownloadTimelines extends AsyncTask<JSONObject, Void, ProcessedVineDataValues>{
	private Context mainAppContext;
	private int responseCode;
	private AlertDialog.Builder alertServerResponse;
	
	public DownloadTimelines(Context ctx) {
		mainAppContext = ctx;
		
	}
	
	@Override
	protected void onPreExecute() {
	    super.onPreExecute();
	    alertServerResponse = new AlertDialog.Builder(new ContextThemeWrapper(mainAppContext,
				R.style.theme_dialog));
	}
	
	@Override
	protected ProcessedVineDataValues doInBackground(JSONObject... params) {
		URL url;
		HttpURLConnection connection = null;
		try {
			url = new URL("https://vine.co/api/timelines/users/918753190470619136");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			responseCode = connection.getResponseCode();
			if(responseCode == 200){
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
			
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
		if(responseCode == 200){
			Intent myIntent = new Intent(mainAppContext, ListViewerActivity.class);
			myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			mainAppContext.startActivity(myIntent);
		}
		else{
			alertServerResponse.setTitle("Internet Connection")
			.setMessage("Check Internet Connection")
			.setIcon(R.drawable.ic_none)
			.setCancelable(true)
			.setPositiveButton("Go to Settings", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					mainAppContext.startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
				}
			})
			.setNegativeButton("Cancel", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			});
			alertServerResponse.create().show();
		}
		
	}
}
