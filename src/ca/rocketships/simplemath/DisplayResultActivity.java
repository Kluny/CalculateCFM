package ca.rocketships.simplemath;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import ca.rocketships.simplemath.MainActivity;

public class DisplayResultActivity extends Activity{
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Get the message from the intent
		Intent intent = getIntent();
		//String result = intent.getStringExtra(MainActivity.RESULT);
		
		//Create the text view
		TextView textView = new TextView(this);
		textView.setTextSize(40);
		//textView.setText(result);
				
		//Set the text view as the activity layout
		
		setContentView(textView);
		
		
		
		
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

}
