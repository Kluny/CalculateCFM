package ca.rocketships.simplemath;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		final String LOG_TAG = "MainScreen";
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		//get values from text entry boxes
		final EditText engineSizeEditText = (EditText) findViewById(R.id.engine_size_text);
		final EditText maxRPMEditText = (EditText) findViewById(R.id.maximum_rpm_text);
		
        final TextView result80 = (TextView) findViewById(R.id.text80);
		final TextView result90 = (TextView) findViewById(R.id.text90);
		final TextView result100 = (TextView) findViewById(R.id.text100);

		
		Button calculateButton = (Button) findViewById(R.id.button1);
		
        calculateButton.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {
                try {
                    
                	int engineSizeInt = Integer.parseInt(engineSizeEditText.getText().toString());
                    int maxRPMInt = Integer.parseInt(maxRPMEditText.getText().toString());

                	
            		Integer cfm80 = (Integer) calculate(engineSizeInt, maxRPMInt, 0.8);
            		Integer cfm90 = (Integer) calculate(engineSizeInt, maxRPMInt, 0.9);
            		Integer cfm100 = (Integer) calculate(engineSizeInt, maxRPMInt, 1.0);
            		
            		
            		
                    result80.setText(cfm80.toString());
                    result90.setText(cfm90.toString());
                    result100.setText(cfm100.toString());
                    
                } catch (Exception e) {
                    Log.e(LOG_TAG, "Failed to calculate", e);
                }
            }
        });


		
		//debugging
		//System.out.println("engine size: " + engineSizeInt);
		//System.out.println("rpm: " + maxRPMInt);
		
		//debugging
		//System.out.println(maxCFM);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	private int calculate(int engineSizeInt, int maxRPMInt, double VE) {
		//How To Calculate CFM: 
		//Engine size (CID) x maximum RPM / 3456 = CFM 
		//CFM @ 100% volumetric efficiency 
		
		return (int) (((engineSizeInt * maxRPMInt) / 3456) * VE);
	}


}
