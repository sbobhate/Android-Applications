package com.example.modularui;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Fragment1 extends Fragment implements AdapterView.OnItemClickListener {
	
	ListView list;
	Communicator communicator;
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.activity_fragment1, container, false);
	}
	
	@Override
	public void onActivityCreated (Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		communicator = (Communicator) getActivity();
		list = (ListView) getActivity().findViewById(R.id.listView);
		ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.titles, android.R.layout.simple_list_item_1);
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
	{
		communicator.respond(i);
	}
	
}
