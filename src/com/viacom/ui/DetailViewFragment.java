package com.viacom.ui;

import com.example.myvine.R;
import com.viacom.datahandler.ProcessedVineDataValues;
import com.viacom.webservice.VineMyJSONFormatter;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * The Fragment that displays the Video, Video Player and Video Description
 * @author sumansucharitdas
 *
 */
public class DetailViewFragment extends Fragment {

	private VideoView videoView;
	private MediaController mc;
	private TextView tv;
	private Uri uri;
	
	@Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.detailview_fragment, container, false);
		uri=Uri.parse(ProcessedVineDataValues.videoURLs.get(0));

	    videoView=(VideoView)view.findViewById(R.id.UploadVideo);
	    videoView.setVideoURI(uri);
	    mc = new MediaController(getActivity());
	    mc.setAnchorView(videoView);
	    mc.setMediaPlayer(videoView);
	    videoView.setMediaController(mc);
	    videoView.start();
	    tv = (TextView) view.findViewById(R.id.emptyy);
	    
	    // Obtain the description, the default one that is first thumbnail
	    tv.setText(VineMyJSONFormatter.descriptions.get(0));
	    return view;
	 }
	
	public void receiveMsg ( int i )
    {
		// Receive the Clicked Position through communicator
       uri=Uri.parse(ProcessedVineDataValues.videoURLs.get(i));
       // Set the Video to be played and the description
	   videoView.setVideoURI(uri);
	   mc = new MediaController(getActivity());
	   mc.setAnchorView(videoView);
	   mc.setMediaPlayer(videoView);
	   videoView.setMediaController(mc);
	   videoView.start();
	   tv.setText(VineMyJSONFormatter.descriptions.get(i));
    }
}
