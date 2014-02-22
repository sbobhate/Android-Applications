package com.example.orient;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Fragment2 extends Fragment {
	
	TextView text;
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.activity_fragment2, container, false);
		text = (TextView) view.findViewById(R.id.quality);
		text.setText("Works");
		return view;
	}
	
	@Override
	public void onActivityCreated (Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		// text = (TextView) getActivity().findViewById(R.id.quality);
		// text.setText("Awesome");
		//savedInstanceState = this.getArguments();
		//if(savedInstanceState != null){
		    //CdmaDbm = savedInstanceState.getInt("cdma", 0);
		//}
	}
	
	public void checkQuality (int CdmaDbm)
	{	
	     if (CdmaDbm >= -75)
	    	 text.setText("Excellent");
	     if (CdmaDbm >= -85 && CdmaDbm < -75)
	    	 text.setText("Good");
	     if (CdmaDbm >= -95 && CdmaDbm < -85)
	    	 text.setText("Okay");
	     if (CdmaDbm >= -110 && CdmaDbm < -95)
	    	 text.setText("Poor");
	     if (CdmaDbm < -110)
	    	 text.setText("No Signal");
	}
}

