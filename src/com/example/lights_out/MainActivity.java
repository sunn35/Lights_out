package com.example.lights_out;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.content.Intent;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void start(View view){
		Intent intent = new Intent(MainActivity.this,Game.class);
		MainActivity.this.startActivity(intent);
	}
	
	public void Options(View view){
		Intent intent = new Intent(this,Options.class);
		MainActivity.this.startActivity(intent);
	}
	
}
