package com.example.instructionnavigation;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class Fragment1 extends Fragment {
	
	ImageView blueprint;
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.activity_fragment1, container, false);
		//blueprint = (ImageView) view.findViewById(R.id.title1);
		return view;
	}
	
	public void showBlueprint (View v)
	{
		Toast.makeText(getActivity(), "clicked", Toast.LENGTH_SHORT).show();
		//blueprint.setImageResource(R.drawable.blueprint);
	}
}
