package com.viacom.ui;

import com.example.myvine.R;

import android.os.Bundle; 
import android.support.v4.app.FragmentActivity;

/**
 * Container to hold the Fragments, ListView and Detail Views
 * it adds the communicator that makes the fragment interactive
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

	
}
