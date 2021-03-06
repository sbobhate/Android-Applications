package com.example.orient;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setupActionBar();
    }

    private void setupActionBar() {
		getActionBar().setDisplayHomeAsUpEnabled(false);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		//return super.onCreateOptionsMenu(menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
            return true;
        case R.id.instructions:
        	go_to_instructions();
        	return true;
        case R.id.reader:
        	go_to_reader();
        	return true;
		  default:
		    	return super .onOptionsItemSelected(item);
		}
	}
	
	public void go_to_instructions() {
		Intent newActivity = new Intent(this, Instructions.class);
		startActivity(newActivity);
	}
	
	public void go_to_reader() {
		Intent newActivity = new Intent(this, Reader.class);
		startActivity(newActivity);
	}
	
	public void go_to_aboutUs (View v)
	{
		Intent intent = new Intent(this, AboutUs.class);
		startActivity(intent);
	}
    
}
