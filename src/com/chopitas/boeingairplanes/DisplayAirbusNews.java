package com.chopitas.boeingairplanes;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.chopitas.boeingairplanes.DisplayBoeingNews.loadRSSFeedItems;


 
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;



public class DisplayAirbusNews extends ListActivity {

	 // Progress Dialog
   private ProgressDialog pDialog;

   // Array list for list view
   ArrayList<HashMap<String, String>> rssItemList = new ArrayList<HashMap<String,String>>();

   RSSParser rssParser = new RSSParser();

   List<RSSItem> rssItems = new ArrayList<RSSItem>();

   RSSFeed rssFeed;

   private static String TAG_TITLE = "title";
   private static String TAG_LINK = "link";
   private static String TAG_DESRIPTION = "description";
   private static String TAG_PUB_DATE = "pubDate";
//   private static String TAG_GUID = "guid"; // not used

   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.rss_item_list);
    // Show the Up button in the action bar.
    		int versionNumber = Integer.valueOf(android.os.Build.VERSION.SDK_INT);
    		if (versionNumber >= 11) {
    		getActionBar().setDisplayHomeAsUpEnabled(true);
    		}

       // get intent data
       Intent i = getIntent();

       // SQLite Row id
//       Integer site_id = Integer.parseInt(i.getStringExtra("id"));

       // Getting Single website from SQLite
       
       /*
       RSSDatabaseHandler rssDB = new RSSDatabaseHandler(getApplicationContext());

       WebSite site = rssDB.getSite(site_id);
       */
       
       String rss_link = "http://www.airbus.com/newsevents/rss/all_airbus_families_news.xml";
       
//       String rss_link = "http://ep00.epimg.net/rss/elpais/portada.xml";

       /**
        * Calling a backgroung thread will loads recent articles of a website
        * @param rss url of website
        * */
       new loadRSSFeedItems().execute(rss_link);

       // selecting single ListView item
       ListView lv = getListView();

       // Launching new screen on Selecting Single ListItem
       lv.setOnItemClickListener(new OnItemClickListener() {

           public void onItemClick(AdapterView<?> parent, View view,
                   int position, long id) {
  
        	   // con el navegador externo
        	   String url = ((TextView) view.findViewById(R.id.page_url)).getText().toString();
         		Intent intent0 = new Intent(Intent.ACTION_VIEW);
         		intent0.setData(Uri.parse(url));
         		startActivity(intent0);
        	   
        	   
        	   //con webview
        	   /*
               Intent in = new Intent(getApplicationContext(), DisPlayWebPageActivity.class);
               
               // getting page url
               String page_url = ((TextView) view.findViewById(R.id.page_url)).getText().toString();
               Toast.makeText(getApplicationContext(), page_url, Toast.LENGTH_SHORT).show();
               in.putExtra("page_url", page_url);
               startActivity(in);
               
               */
           }
       });
   }
   
   
   
   
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.activity_display_airbus_news, menu);
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
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   

   /**
    * Background Async Task to get RSS Feed Items data from URL
    * */
   class loadRSSFeedItems extends AsyncTask<String, String, String> {

       /**
        * Before starting background thread Show Progress Dialog
        * */
       @Override
       protected void onPreExecute() {
           super.onPreExecute();
           pDialog = new ProgressDialog(
           		DisplayAirbusNews.this);
           pDialog.setMessage("Loading articles...");
           pDialog.setIndeterminate(false);
           pDialog.setCancelable(false);
           pDialog.show();
       }

       /**
        * getting all recent articles and showing them in listview
        * */
       @Override
       protected String doInBackground(String... args) {
           // rss link url
           String rss_url = args[0];

           // list of rss items
           rssItems = rssParser.getRSSFeedItems(rss_url);

           // looping through each item
           for(RSSItem item : rssItems){
               // creating new HashMap
               HashMap<String, String> map = new HashMap<String, String>();

               // adding each child node to HashMap key => value
               map.put(TAG_TITLE, item.getTitle());
               map.put(TAG_LINK, item.getLink());
               map.put(TAG_PUB_DATE, item.getPubdate());
               String description = item.getDescription();
               // taking only 200 chars from description
               if(description.length() > 100){
                   description = description.substring(0, 97) + "..";
               }
               map.put(TAG_DESRIPTION, description);

               // adding HashList to ArrayList
               rssItemList.add(map);
           }

           // updating UI from Background Thread
           runOnUiThread(new Runnable() {
               public void run() {
                   /**
                    * Updating parsed items into listview
                    * */
                   ListAdapter adapter = new SimpleAdapter(
                   		DisplayAirbusNews.this,
                           rssItemList, R.layout.rss_item_list_row,
                           new String[] { TAG_LINK, TAG_TITLE, TAG_PUB_DATE, TAG_DESRIPTION },
                           new int[] { R.id.page_url, R.id.title, R.id.pub_date, R.id.link });

                   // updating listview
                   setListAdapter(adapter);
               }
           });
           return null;
       }

       /**
        * After completing background task Dismiss the progress dialog
        * **/
       protected void onPostExecute(String args) {
           // dismiss the dialog after getting all products
           pDialog.dismiss();
       }
   }
}
	
	
	
