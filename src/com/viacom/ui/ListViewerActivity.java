package com.viacom.ui;

import com.example.myvine.R;

import android.os.Bundle; 
import android.support.v4.app.FragmentActivity;

public class ListViewerActivity extends FragmentActivity implements FragmentCommunicator{
	
	@Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
  
        // We'll define a custom screen layout here (the one shown above), but
        // typically, you could just use the standard ListActivity layout.
        setContentView(R.layout.custom_list_view);
        
	}

	@Override
	public void sendId(int id) {
		DetailViewFragment detailFragment = (DetailViewFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
		detailFragment.receiveMsg(id);
	}

	
}
