package org.example.androidsdk.demo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		getActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String flowerName = intent.getStringExtra("flowerName");
        int imageResource = intent.getIntExtra("imageResource", 0);
        String instructions = intent.getStringExtra("instructions");

        TextView tv = (TextView)findViewById(R.id.textView1);
        tv.setText(flowerName);

        tv = (TextView)findViewById(R.id.textView2);
        tv.setText(instructions);

        ImageView image = (ImageView)findViewById(R.id.imageView1);
        image.setImageResource(imageResource);

		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem item = menu.add(R.string.external_url);
		item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				String webpage = "http://developer.android.com/index.html";
				
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webpage));
				startActivity(intent);
				return false;
			}
		});
		return super.onCreateOptionsMenu(menu);
	}
}
