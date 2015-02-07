package com.viacom.ui;

import com.example.myvine.R;
import com.viacom.webservice.FragmentCommunicator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle; 
import android.support.v4.app.FragmentActivity;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Container to hold the Fragments, ListView and DetailView.
 * It adds the communicator that makes the fragment interactive
 * to each other
 * @author sumansucharitdas
 *
 */
public class ListViewerActivity extends FragmentActivity implements FragmentCommunicator{
	
	@Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
  
        // Custom List View Layout rather than using a standard ListView Layout
        setContentView(R.layout.custom_list_view);
	}

	@Override
	public void sendId(int id) {
		// Initiating the detail fragment to receive inputs from list view fragment
		DetailViewFragment detailFragment = (DetailViewFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
		detailFragment.receiveMsg(id);
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
