package com.example.baby;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	

	}
	public void StartClick(View v){
		Intent startIntent = new Intent(this, PictureActivity.class);
		startActivity(startIntent);
	}
	public void HelpClick(View v){
		Intent HelpIntent = new Intent(this, HelpActivity.class);
		startActivity(HelpIntent);
		
	}



}
