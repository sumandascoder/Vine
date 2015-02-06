package com.viacom.ui;

import org.json.JSONObject;

import com.example.myvine.R;
import com.viacom.webservice.DownloadTimelines;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class VineActivity extends Activity {

	public static ProgressDialog progressDialog;
	private String urlString = "https://vine.co/api/timelines/users/918753190470619136";
	private ImageView viacomImage;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_vine_activity);
		setTitle(R.string.app_name);
		progressDialog = new ProgressDialog(this);
		final Context vineContext =  this;
        
		Button viacomResults = (Button) findViewById(R.id.ViacomResults);
		viacomResults.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		        progressDialog.setTitle("Processing");
		        progressDialog.setCancelable(false);
		        progressDialog.setCanceledOnTouchOutside(false);
		        progressDialog.show();
				new DownloadTimelines(vineContext, urlString).execute(new JSONObject());
			}
		});
		
		viacomImage = (ImageView) findViewById(R.id.ViacomImage);
		viacomImage.setImageResource(R.drawable.ic_flintstone); 
		TranslateAnimation animation = new TranslateAnimation(0.0f, 400.0f,
		    0.0f, 0.0f);
		  animation.setDuration(5000);
		  animation.setRepeatCount(Animation.INFINITE);
		  animation.setRepeatMode(2);
		  animation.setFillAfter(true);
		  viacomImage.startAnimation(animation);

		final Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
	    final ImageView mtvLogo = (ImageView)findViewById(R.id.ViacomImageMtv);
	    mtvLogo.setImageResource(R.drawable.ic_mtv);
	    mtvLogo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mtvLogo.startAnimation(shake);
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
