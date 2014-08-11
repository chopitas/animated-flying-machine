package com.chopitas.boeingairplanes;

import java.util.ArrayList;
import java.util.List;

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

public class Display747 extends Activity implements OnItemClickListener {
	
	
	
	//string con los datos del custom view
			public static final String[] titles = new String []{
				"RSS News",
				"747-100/200",
				"747-300",
				"747SP",
				"747-400/400ER",
				"747-8"};
			
			public static final String[] descriptions = new String[] {
				"Up to date news about Boeing 747",
				"",
				"",
				"",
				"",
				""};
			
			public static final Integer[] images = {
				R.drawable.rss,
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
		setContentView(R.layout.activity_display747);
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
        
        listView = (ListView) findViewById(R.id.b747List);
        CustomListViewAdapter adapter = new CustomListViewAdapter(this, R.layout.list_item, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
		
		
		
		}
		
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_display747, menu);
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
		  	case 0:
		  		Intent intent0 = new Intent(Display747.this, Display747News.class);
				startActivity(intent0);
				break;
		  	case 1:
		  //		Intent intent2 = new Intent(DisplayBoeing.this, Display737.class);
		  //		startActivity(intent2);
		  		break;
		  	
	    	}
	
	
	
	
	
		}

	
	
	
	
	
	
	
	
	
	

}
