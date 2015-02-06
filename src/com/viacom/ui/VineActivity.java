package com.viacom.ui;

import org.json.JSONObject;

import com.example.myvine.R;
import com.viacom.webservice.DownloadTimelines;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * The entry Activity that handles the first hand UX when the App is used
 * @author sumansucharitdas
 *
 */
public class VineActivity extends Activity {

	public static ProgressDialog progressDialog;
	
	/* Provided URL and in case user wants to use another link, other than this string
	* the edit text field helps to enter new data
	*/ 
	private String urlUserString = "";
	private String urlApiString = "https://vine.co/api/timelines/users/"; // Basic API String
	private ImageView viacomImage; // The Viacom Image animator
	private EditText userProfile; // Editable Text Box to take user Input
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// View Settings
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_vine_activity);
		setTitle(R.string.app_name);
		
		// View Page Animator for the cartoon Flintstone
		viacomImage = (ImageView) findViewById(R.id.ViacomImage);
		viacomImage.setImageResource(R.drawable.ic_flintstone); 
		TranslateAnimation animation = new TranslateAnimation(0.0f, 400.0f,0.0f, 0.0f);
		animation.setDuration(5000);
		animation.setRepeatCount(Animation.INFINITE);
		animation.setRepeatMode(2);
		animation.setFillAfter(true);
		viacomImage.startAnimation(animation);

		// View Page animator for the Mtv logo 
		final Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
		final ImageView mtvLogo = (ImageView)findViewById(R.id.ViacomImageMtv);
		mtvLogo.setImageResource(R.drawable.ic_mtv);
		mtvLogo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mtvLogo.startAnimation(shake);
			}
		});
			    		
		
		// Progress Dialog for the JSON Parsing and JSON handling
		progressDialog = new ProgressDialog(this);
		
		// The context to be passed to Async Processing
		final Context vineContext =  this;
		
        userProfile = (EditText) findViewById(R.id.userProfile);
        
        // Make the Keyboard hidden initially
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        // Show the Keyboard when edit text is clicked
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(userProfile.getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
        
        
        /**
         * User seeks to fetch Data for a particular user Profile
         */
        Button viacomResults = (Button) findViewById(R.id.ViacomResults);
		viacomResults.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				urlUserString = userProfile.getText().toString();
				if(urlUserString.length() == 0 || "".equals(urlUserString)){
					// Default String
					urlUserString = "";
					urlUserString = urlApiString;
					urlUserString += "918753190470619136";
				}
				else{
					// User Entered String
					urlUserString = "";
					urlUserString = urlApiString;
					urlUserString += userProfile.getText().toString();
				}
				// Start the Progress dialog
				progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		        progressDialog.setTitle("User Profile");
		        progressDialog.setMessage("Fetching the user uploaded Videos");
		        progressDialog.setCancelable(false);
		        progressDialog.setCanceledOnTouchOutside(false);
		        progressDialog.show();
		        
		        // Call to the Async Task Execution
				new DownloadTimelines(vineContext, urlUserString.toString()).execute(new JSONObject());
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
			Toast.makeText(this, "No settings Required", Toast.LENGTH_LONG).show();;
			return true;
		}
		else if(id == R.id.help){
			/**
			 * New User help
			 */
			AlertDialog.Builder helpAlert =  new AlertDialog.Builder(new ContextThemeWrapper(this,
					R.style.theme_dialog));
			helpAlert.setTitle("I am a helper")
				.setMessage("Provide the user link you want to view the content for and click "
						+ "watch all the uploaded user videos.")
				.setIcon(R.drawable.ic_launcher)
				.setCancelable(true)
				.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
			helpAlert.create().show();
		}
		return super.onOptionsItemSelected(item);
	}
}
