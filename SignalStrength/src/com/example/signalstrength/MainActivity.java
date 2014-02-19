// Reference: http://www.stevenmarkford.com/android-get-signal-strength/
// Reference: http://stackoverflow.com/questions/9464671/range-for-signalstrength-in-dbm-for-cdma-devices
// Reference: http://evdotips.blogspot.com/2009/06/pointing-directional-antennas-what-to.html
// Reference: http://stackoverflow.com/questions/18399364/get-signal-strength-of-wifi-and-mobile-data
// Reference: http://www.telecomhall.com/what-is-ecio-and-ebno.aspx\
// Reference: http://developer.android.com/reference/android/telephony/SignalStrength.html

package com.example.signalstrength;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class MainActivity  extends Activity {
	
	 SignalStrengthListener signalStrengthListener;
	 TextView cdmadbm;
	 TextView cdmaecio;
	 TextView evdodbm;
	 TextView evdoecio;
	 TextView evdosnr;
	 TextView gsmerror;
	 TextView gsm;

	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
		    
	   //setup content stuff
	   this.setContentView(R.layout.activity_main);
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