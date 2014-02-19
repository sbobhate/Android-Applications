package com.example.fragmenttransition;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	FragmentManager manager;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        manager = getFragmentManager();
    }

    public void addA (View v)
    {
    	Fragment1 f1 = new Fragment1();
    	FragmentTransaction transaction = manager.beginTransaction();
    	transaction.add(R.id.group, f1, "1");
    	transaction.commit();
    }
    
    public void addB (View v)
    {
    	Fragment2 f2 = new Fragment2();
    	FragmentTransaction transaction = manager.beginTransaction();
    	transaction.add(R.id.group, f2, "2");
    	transaction.commit();
    }
    
    public void removeA (View v)
    {	
    	Fragment1 f1 = (Fragment1) manager.findFragmentByTag("1");
    	FragmentTransaction transaction = manager.beginTransaction();
    	if (f1 != null) 
    	{
    		transaction.remove(f1);
    		transaction.commit();
    	}
    	else
    	{
    		Toast.makeText(this, "The Fragment was not added before",Toast.LENGTH_SHORT).show();
    	}
    }
    
    public void removeB (View v)
    {	
    	Fragment2 f2 = (Fragment2) manager.findFragmentByTag("2");
    	FragmentTransaction transaction = manager.beginTransaction();
    	if (f2 != null) 
    	{
    		transaction.remove(f2);
    		transaction.commit();
    	}
    	else
    	{
    		Toast.makeText(this, "The Fragment was not added before",Toast.LENGTH_SHORT).show();
    	}
    }
    
    public void replaceAwithB (View v)
    {
    	Fragment2 f2 = new Fragment2();
    	FragmentTransaction transaction = manager.beginTransaction();
    	transaction.replace(R.id.group, f2, "2");
    	transaction.commit();
    }
    
    public void replaceBwithA (View v)
    {
    	Fragment1 f1 = new Fragment1();
    	FragmentTransaction transaction = manager.beginTransaction();
    	transaction.replace(R.id.group, f1, "1");
    	transaction.commit();
    }
    
    public void attachA (View v)
    {
    	Fragment1 f1 = (Fragment1) manager.findFragmentByTag("1");
    	FragmentTransaction transaction = manager.beginTransaction();
    	if (f1 != null)
    	{
    		transaction.attach(f1);
    		transaction.commit();
    	}
    }
    
    public void detachA (View v)
    {
    	Fragment1 f1 = (Fragment1) manager.findFragmentByTag("1");
    	FragmentTransaction transaction = manager.beginTransaction();
    	if (f1 != null)
    	{
    		transaction.detach(f1);
    		transaction.commit();
    	}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
