package com.example.ui;

import com.example.myvine.R;
import com.example.webservice.ProcessedVineDataValues;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class DetailViewFragment extends Fragment {

	private static int clicked;
	private VideoView videoView;
	private MediaController mc;
	private TextView tv;
	private Uri uri;
	@Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.detailview_fragment, container, false);
		uri=Uri.parse(ProcessedVineDataValues.videoURLs.get(clicked));

	    videoView=(VideoView)view.findViewById(R.id.UploadVideo);
	    videoView.setVideoURI(uri);
	    mc = new MediaController(getActivity());
	    mc.setAnchorView(videoView);
	    mc.setMediaPlayer(videoView);
	    videoView.setMediaController(mc);
	    videoView.start();
	    tv = (TextView) view.findViewById(R.id.emptyy);
	    tv.setText("" + clicked);
	  return view;
	 }
	
	public void receiveMsg ( int i )
    {
       clicked = i;
       uri=Uri.parse(ProcessedVineDataValues.videoURLs.get(clicked));

	   videoView.setVideoURI(uri);
	   mc = new MediaController(getActivity());
	   mc.setAnchorView(videoView);
	   mc.setMediaPlayer(videoView);
	   videoView.setMediaController(mc);
	   videoView.start();
	   tv.setText("" + clicked);
    }
}
