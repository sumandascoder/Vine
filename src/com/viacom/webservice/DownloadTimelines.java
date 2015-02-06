package com.viacom.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;

import com.example.myvine.R;
import com.viacom.datahandler.ProcessedVineDataValues;
import com.viacom.ui.ListViewerActivity;
import com.viacom.ui.VineActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.Settings;
import android.view.ContextThemeWrapper;
import android.widget.Toast;

/**
 * The DownloadTimelines class that connects to the API pointed, fetches the data to be displayed
 * @author sumansucharitdas
 *
 */
public class DownloadTimelines extends AsyncTask<JSONObject, Void, ProcessedVineDataValues>{
	private Context mainAppContext;
	private int responseCode;
	private AlertDialog.Builder alertServerResponse;
	private String userURL = null;
	private static VineMyJSONFormatter vine ;
	private static ProcessedVineDataValues processedVineDataValues;
	
	public DownloadTimelines(Context ctx, String url) {
		mainAppContext = ctx;
		userURL =  url;
	}
	
	@Override
	protected void onPreExecute() {
	    super.onPreExecute();
	    // The alert dialog for no Internet and wrong api calls
	    alertServerResponse = new AlertDialog.Builder(new ContextThemeWrapper(mainAppContext,
				R.style.theme_dialog));
	}
	
	@Override
	protected ProcessedVineDataValues doInBackground(JSONObject... params) {
		URL url;
		HttpURLConnection connection = null;
		try {
			if(userURL!=null){
				// Using GET method to fetch the info from the URL
				url = new URL(userURL);
				connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				responseCode = connection.getResponseCode();
				// If the query is successful
				if(responseCode == 200 ){
					System.out.println("\nSending 'POST' request to URL : " + url);
					System.out.println("Response Code : " + responseCode);
			 
					BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();
			 
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();
			 
					//Print the API response result
					System.out.println(response.toString());
					
					// Mappers and GSON can be used if all went fine with parsing.
					// ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
					// ProcessedVineData vineData = gson.fromJson(x, ProcessedVineData.class);
					// mapper.readValue(response.toString(), ProcessedVineData.class);
					// System.out.println(gson.toString());
					
					vine =  new VineMyJSONFormatter(response.toString(), mainAppContext);
					// All the data that we require to be displayed to our screen
					processedVineDataValues = new ProcessedVineDataValues();
					processedVineDataValues.thumbnailURLs = vine.thumbnailURLs;
					processedVineDataValues.videoURLs =  vine.videoURLs;
					processedVineDataValues.descriptions = vine.descriptions;
					processedVineDataValues.usernames = vine.usernames;
					return processedVineDataValues;
				}
				else if(responseCode == 404){
					Toast.makeText(mainAppContext, "Error Code : Page Not Available", Toast.LENGTH_LONG).show();;
				}
			}
			else{
				return null;
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
		// Closing the Progree Dialog
		if(VineActivity.progressDialog.isShowing()){
			VineActivity.progressDialog.dismiss();
		}
		// If response is accurate and no errors in the json
		if(responseCode == 200 && "".equals(vine.getError())){
			Intent myIntent = new Intent(mainAppContext, ListViewerActivity.class);
			myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			mainAppContext.startActivity(myIntent);
		}
		// Page not found issue
		else if(responseCode == 404){
			alertServerResponse.setTitle("API Results")
			.setMessage("Error Code : Page Not Available")
			.setIcon(R.drawable.ic_launcher)
			.setCancelable(true)
			.setPositiveButton("OK", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel(); 
				}
			});
			alertServerResponse.create().show();
		}
		// Rest of the cases like Internet not available, etc.
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
