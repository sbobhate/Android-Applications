package com.example.listfragment;

import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class Fragment1 extends ListFragment implements AdapterView.OnItemClickListener {
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment, container, false);
		
		return view;
	}
	
	@Override
	public void onActivityCreated (Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.heros, android.R.layout.simple_list_item_1);
		setListAdapter(adapter);
		getListView().setOnItemClickListener(this);
	}
	
	@Override
	public void onItemClick (AdapterView<?> adapterView, View view, int i, long l)
	{
		Toast.makeText(getActivity(), "item " + i, Toast.LENGTH_SHORT).show();
	}
	
}
