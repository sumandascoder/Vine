package com.viacom.datahandler;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;

import com.example.myvine.R;
import com.viacom.webservice.VineMyJSONFormatter;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * The Adapter class to have images and text displayed in Viacom Format
 * @author sumansucharitdas
 *
 */
public class CustomListViewAdapter extends BaseAdapter {

	private static LayoutInflater inflater=null;
	private static Context mainContext;
	
	public CustomListViewAdapter(Context applicationContext, List<String> thumbnailURLs) {
		mainContext = applicationContext;
		inflater = ( LayoutInflater )mainContext.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public void registerDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getCount() {
		return ProcessedVineDataValues.thumbnailURLs.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// Using View Holder Pattern to have the content loaded dynamically 
		ViewHolder holder=new ViewHolder();
        if (convertView == null) {     
        	convertView = inflater.inflate(R.layout.row_item, null);
        	holder.tv=(TextView) convertView.findViewById(R.id.listText);
            holder.img=(ImageView) convertView.findViewById(R.id.listImage);       
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        // Add the text to be diplayed along the Thumbnails
        holder.tv.setText(ProcessedVineDataValues.usernames.get(position));
        holder.img.setImageBitmap(VineMyJSONFormatter.thumbnails.get(position)); 
   
        return convertView;
	}

	@Override
	public int getItemViewType(int position) {
		return position;
	}

	@Override
	public int getViewTypeCount() {
		if(ProcessedVineDataValues.thumbnailURLs.size() != 0){
			return ProcessedVineDataValues.thumbnailURLs.size();
		}
		else {
			return 1;
		}
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean areAllItemsEnabled() {
		return false;
	}

	@Override
	public boolean isEnabled(int position) {
		return true;
	}

	public Bitmap getBitmapFromURL(String src) {
	    try {
	        java.net.URL url = new java.net.URL(src);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setDoInput(true);
	        connection.connect();
	        InputStream input = connection.getInputStream();
	        Bitmap myBitmap = BitmapFactory.decodeStream(input);
	        return myBitmap;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}
