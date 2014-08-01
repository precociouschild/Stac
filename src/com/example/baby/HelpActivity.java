package com.example.baby;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HelpActivity extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help_page);
	}
	public void BackBtn(View v){
		Intent BackBtn = new Intent(this,MainActivity.class);
		startActivity(BackBtn);
		finish();
	}
}
