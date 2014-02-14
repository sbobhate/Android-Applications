package com.example.modularui;

import android.os.Bundle;
import android.app.Fragment;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment {

	TextView text;
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.activity_fragment2, container, false);
	}
	
	public void onActivityCreated (Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		text = (TextView) getActivity().findViewById(R.id.textView);
	}
	
	public void changeData (int i)
	{	
		Resources res = getResources();
		String[] descriptions = res.getStringArray(R.array.descriptions);
		text.setText(descriptions[i]);
	}
	
}
