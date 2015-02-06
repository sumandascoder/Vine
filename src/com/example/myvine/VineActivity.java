package com.example.myvine;

import org.json.JSONObject;

import com.example.webservice.DownloadTimelines;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class VineActivity extends Activity {

	public static ProgressDialog progressDialog;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_vine_activity);
		setTitle(R.string.app_name);
		final DownloadTimelines dt = null;
		progressDialog = new ProgressDialog(this);
        
		Button viacomResults = (Button) findViewById(R.id.ViacomResults);
		viacomResults.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		        progressDialog.setTitle("Processing");
		        progressDialog.setCancelable(false);
		        progressDialog.setCanceledOnTouchOutside(false);
		        progressDialog.show();
				new DownloadTimelines(getApplicationContext()).execute(new JSONObject());
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.vine, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
