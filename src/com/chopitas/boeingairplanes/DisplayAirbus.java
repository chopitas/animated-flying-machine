package com.chopitas.boeingairplanes;

import java.util.ArrayList;
import java.util.List;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.support.v4.app.NavUtils;

public class DisplayAirbus extends Activity implements OnItemClickListener {
	
	//string con los datos del custom view
	public static final String[] titles = new String []{
		"News",
		"Twitter",
		"A318",
		"A319",
		"A320",
		"A321",
		"A330",
		"A340",
		"A380",
		"A310",
		"A300"};
	
	public static final String[] descriptions = new String[] {
		"Up-to-date news about Airbus",
		"Airbus Official twitter",
		"100 seat regional narrowbody",
		"Medium range narrowbody",
		"Short to medium range narrowbody",
		"Short to medium range narrowbody",
		"medium to long range widebody",
		"Long range widebody",
		"High capacity, long range, twindeck, widebody",
		"Medium to long range widebody",
		"Medium range widebody"};
	
	public static final Integer[] images = {
		R.drawable.rss,
		R.drawable.twitter,
		R.drawable.plane,
		R.drawable.plane,
		R.drawable.plane,
		R.drawable.plane,
		R.drawable.plane,
		R.drawable.plane,
		R.drawable.plane,
		R.drawable.plane,
		R.drawable.plane};
	
	//declara listview
		ListView listView;
	    List<RowItem> rowItems;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_airbus);
		// Show the Up button in the action bar.
		int versionNumber = Integer.valueOf(android.os.Build.VERSION.SDK_INT);
		if (versionNumber >= 11) {
		getActionBar().setDisplayHomeAsUpEnabled(true);
		}
		
		
		//crea el custom view
				rowItems = new ArrayList<RowItem>();
		        for (int i = 0; i < titles.length; i++) {
		            RowItem item = new RowItem(images[i], titles[i], descriptions[i]);
		            rowItems.add(item);
		        }
		        
		        listView = (ListView) findViewById(R.id.airbusList);
		        CustomListViewAdapter adapter = new CustomListViewAdapter(this, R.layout.list_item, rowItems);
		        listView.setAdapter(adapter);
		        listView.setOnItemClickListener(this);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_display_airbus, menu);
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
	
	
	
	// arranca la actividad siguiente
		@Override
	    public void onItemClick(AdapterView<?> parent, View view, int position,
	            long id) {
	        
	    	switch(position){
	    	//rss
		  	case 0:
		  		Intent intent0 = new Intent(DisplayAirbus.this, DisplayAirbusNews.class);
				startActivity(intent0);
				break;
				
			//twitter	
		  	case 1:
		  		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/Airbus")));
		  		break;
				
			//A318
		  	case 2:
		  		Intent intent2 = new Intent(DisplayAirbus.this, A318.class);
		  		startActivity(intent2);
		  		break;
		  		
		  	//A319
		  	case 3:
		  		Intent intent3 = new Intent(DisplayAirbus.this, A319.class);
		  		startActivity(intent3);
		  		break;
		  		
		  	//A320	
		  	case 4:
		  		Intent intent4 = new Intent(DisplayAirbus.this, A320.class);
		  		startActivity(intent4);
		  		break;
		  		
		  	//A321
		  	case 5:
		  		Intent intent5 = new Intent(DisplayAirbus.this, A321.class);
		  		startActivity(intent5);
		  		break;
		  		
		  	//A330
		  	case 6:
		  		Intent intent6 = new Intent(DisplayAirbus.this, A330.class);
		  		startActivity(intent6);
		  		break;
		  		
		  	//A340
		  	case 7:
		  		Intent intent7 = new Intent(DisplayAirbus.this, A340.class);
		  		startActivity(intent7);
		  		break;
		  		
		  	//A380
		  	case 8:
		  		Intent intent8 = new Intent(DisplayAirbus.this, A380.class);
		  		startActivity(intent8);
		  		break;
		  		
		  	//A310
		  	case 9:
		  		Intent intent9 = new Intent(DisplayAirbus.this, A310.class);
		  		startActivity(intent9);
		  		break;
		  		
		  	//A300
		  	case 10:
		  		Intent intent10 = new Intent(DisplayAirbus.this, A300.class);
		  		startActivity(intent10);
		  		break;
		  	
	    	}
	
		}
	
	

}
