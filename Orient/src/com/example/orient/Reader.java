package com.example.orient;

import android.os.Bundle;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.telephony.TelephonyManager;
import android.telephony.PhoneStateListener;

public class Reader extends Activity {
	
	SignalStrengthListener signalStrengthListener;
	 TextView cdmadbm;
	 TextView cdmaecio;
	 TextView evdodbm;
	 TextView evdoecio;
	 TextView evdosnr;
	 TextView gsmerror;
	 TextView gsm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Show the Up button in the action bar.
		setupActionBar();
		
		this.setContentView(R.layout.activity_reader);
		   cdmadbm = (TextView)findViewById(R.id.cdmadbm);
		   cdmaecio = (TextView)findViewById(R.id.cdmaecio);
		   evdodbm = (TextView)findViewById(R.id.evdodbm);
		   evdoecio = (TextView)findViewById(R.id.evdoecio);
		   evdosnr = (TextView)findViewById(R.id.evdosnr);
		   gsmerror = (TextView)findViewById(R.id.gsmerror);
		   gsm = (TextView)findViewById(R.id.gsm);

		   //start the signal strength listener
		  signalStrengthListener = new SignalStrengthListener();	           
		   ((TelephonyManager)getSystemService(TELEPHONY_SERVICE)).listen(signalStrengthListener,SignalStrengthListener.LISTEN_SIGNAL_STRENGTHS);
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reader, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private class SignalStrengthListener extends PhoneStateListener
	 {
	  @Override
	  public void onSignalStrengthsChanged(android.telephony.SignalStrength signalStrength) {
	    
	     int CdmaDbm = signalStrength.getCdmaDbm();
	     int CdmaEcio = signalStrength.getCdmaEcio();
	     int EvdoDbm = signalStrength.getEvdoDbm();
	     int EvdoEcio = signalStrength.getEvdoEcio();
	     int EvdoSnr = signalStrength.getEvdoSnr();
	     int GsmError = signalStrength.getGsmBitErrorRate();
	     int Gsm = signalStrength.getGsmSignalStrength();
	    
	    //do something with it (in this case we update a text view)
	    cdmadbm.setText("CDMA dBm: "+ String.valueOf(CdmaDbm));
	    cdmaecio.setText("CDMA EC/IO: " + String.valueOf(CdmaEcio));
	    evdodbm.setText("Evdo dBm: " + String.valueOf(EvdoDbm));
	    evdoecio.setText("Evdo EC/IO: " + String.valueOf(EvdoEcio));
	    evdosnr.setText("Evdo snr: " + String.valueOf(EvdoSnr));
	    gsmerror.setText("GSM Bit Error Rate: " + String.valueOf(GsmError));
	    gsm.setText("GSM Signal Strength: " + String.valueOf(Gsm));
	    super.onSignalStrengthsChanged(signalStrength);
	  }
	}

}
