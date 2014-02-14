package com.example.modularui;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;

public class MainActivity extends Activity implements Communicator {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public void respond(int i) {
		FragmentManager manager = getFragmentManager();
		Fragment2 f2 = (Fragment2) manager.findFragmentById(R.id.fragment2);
		f2.changeData(i);
	}

}
