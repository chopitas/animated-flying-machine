package com.chopitas.boeingairplanes;




import java.util.ArrayList;
import java.util.List;

import com.chopitas.boeingairplanes.DisplayNews;
import com.chopitas.boeingairplanes.Display787;
import com.chopitas.boeingairplanes.MainActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;




public class MainActivity extends Activity implements OnItemClickListener {

	/*
	public static final String[] titles = new String[] { "Boeing News", "Boeing 787","Boeing 777","Boeing 767","Boeing 747-8","Boeing 737NG","Other Boeing Jets", "Airbus News", "Airbus A380","Airbus A340","Airbus A330","Airbus A320", "Other Airbus Jets", "McDonnell Douglas","Lockheed"};
		
	public static final String[] descriptions = new String[] {
            "Up-to-date Boeing news", "Long range widebody", "Long and ultra long range high capacity widebody","Medium to long range widebody",
            "Long range high capacity widebody", "Short to medium range narrowbody","Out of production Boeing jets", "Up-to-date Airbus News", "High capacity long range twindeck widebody", "Long range widebody","Large capacity medium to long range","Short to medium range narrowbody", "Out of production Airbus jets",
            "McDonnell Douglas jets","Lockheed jets"};
	public static final Integer[] images = { R.drawable.rss,R.drawable.b787icon, R.drawable.b777icon,R.drawable.b767icon,R.drawable.b747icon,R.drawable.b737icon,R.drawable.plane,R.drawable.rss,R.drawable.plane,R.drawable.plane,R.drawable.plane,R.drawable.plane,R.drawable.plane,R.drawable.plane,R.drawable.plane};
	*/
	
	public static final String[] titles = new String []{
		"Boeing",
		"Airbus",
		"McDonnell Douglas",
		"Bombardier",
		"Embraer",
		"ATR",
		"Lockheed",
		"Tupolev",
		"Sukhoi",
		"Ilyushin"};
	
	public static final String[] descriptions = new String[] {
		"737, 747, 757, 767, 777, 787, etc",
		"A320, A330, A340, A380, etc",
		"DC9/MD80, MD11, etc",
		"CRJ and CSeries",
		"ERJ and E-Jet",
		"ATR 42 and ATR 72",
		"L1011",
		"Tu-154, Tu-204, etc",
		"Superjet 100",
		"Il-62, Il-76, Il-86"};
	
	public static final Integer[] images = {
		R.drawable.plane,
		R.drawable.plane,
		R.drawable.plane,
		R.drawable.plane,
		R.drawable.plane,
		R.drawable.plane,
		R.drawable.plane,
		R.drawable.plane,
		R.drawable.plane,
		R.drawable.plane};
	
	
	ListView listView;
    List<RowItem> rowItems;
		

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < titles.length; i++) {
            RowItem item = new RowItem(images[i], titles[i], descriptions[i]);
            rowItems.add(item);
        }
        
        listView = (ListView) findViewById(R.id.mainList);
        CustomListViewAdapter adapter = new CustomListViewAdapter(this,
                R.layout.list_item, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
	}
    
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                long id) {
            
        	switch(position){
		  	case 0:
		  		Intent intent0 = new Intent(MainActivity.this, DisplayBoeing.class);
				startActivity(intent0);
				break;
		  	case 1:
		  		Intent intent1 = new Intent(MainActivity.this, DisplayAirbus.class);
				startActivity(intent1);
				break;
		  	case 3:
		  		Intent intent2 = new Intent(MainActivity.this, DisplayBombardier.class);
		  		startActivity(intent2);
		  		break;
		  	case 4:
		  		Intent intent3 = new Intent(MainActivity.this, DisplayEmbraer.class);
		  		startActivity(intent3);
		  		break;
		  	case 5:
		  		Intent intent4 = new Intent(MainActivity.this, DisplayATR.class);
		  		startActivity(intent4);
		  		break;
		  	case 2:
		  		Intent intent5 = new Intent(MainActivity.this, DisplayMD.class);
		  		startActivity(intent5);
		  		break;
		  	case 6:
		  		Intent intent6 = new Intent(MainActivity.this, DisplayLockheed.class);
		  		startActivity(intent6);
		  		break;
		  	case 7:
		  		Intent intent7 = new Intent(MainActivity.this, DisplayTupolev.class);
		  		startActivity(intent7);
		  		break;
		  	case 8:
		  		Intent intent8 = new Intent(MainActivity.this, DisplaySukhoi.class);
		  		startActivity(intent8);
		  		break;
		  	case 9:
		  		Intent intent9 = new Intent(MainActivity.this, DisplayIlyushin.class);
		  		startActivity(intent9);
		  		break;
        	}
        	
        }
    
			
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
		
			
	}

}
