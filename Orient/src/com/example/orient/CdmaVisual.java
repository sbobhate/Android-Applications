package com.example.orient;


import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.NavUtils;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class CdmaVisual extends Fragment {
	
	Fragment2 f2;
	FragmentManager manager;
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.activity_cdma_visual, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		
		manager = getFragmentManager();
		
	}
	
	public void fuck (int CdmaDbm)
	{
		f2 = (Fragment2) manager.findFragmentById(R.id.quality);
		f2.checkQuality(CdmaDbm);
	}

}
