package com.viacom.ui;

import com.example.myvine.R;
import com.viacom.datahandler.CustomListViewAdapter;
import com.viacom.webservice.ProcessedVineDataValues;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;

public class ListViewFragment extends Fragment{

	private ListView thumbnailList;
	private FragmentCommunicator communicator;
	private static int pos;
	
	@Override
	 public void onActivityCreated(Bundle savedInstanceState){
		 super.onActivityCreated(savedInstanceState);
		 setHasOptionsMenu(true);
		 //thumbnailList = (ListView)view.findViewById(R.id.list);
		 thumbnailList.setAdapter(new CustomListViewAdapter(thumbnailList.getContext(),ProcessedVineDataValues.thumbnailURLs));
		 thumbnailList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				pos = position;
				updateVideo();
			}
		});
			
	}
	
	@Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	  Bundle savedInstanceState) {
	  thumbnailList = (ListView) inflater.inflate(R.layout.listview_fragment, container, false);
	  return thumbnailList;
	 }
	
	@Override
	 public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
	    	super.onCreateOptionsMenu(menu, inflater);
		 	inflater.inflate(R.menu.vine, menu);
	 }
	
	@Override
	 public void onAttach(Activity activity) {
	  super.onAttach(activity);
	  try{
			 if (getActivity() instanceof FragmentCommunicator) {
				  communicator = (FragmentCommunicator) getActivity();
			  } 
		 }
		 catch (Exception e){
			 e.printStackTrace();
		 }
		 
	}
	
	
	private void updateVideo() {
		communicator.sendId(pos);
	}
}
