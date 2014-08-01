package com.example.baby;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Result_Activity extends Activity {
	View mPage1,mPage2,mPage3;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result_page);
		mPage1 = findViewById(R.id.a1);
		mPage2 = findViewById(R.id.a2);
		mPage3 = findViewById(R.id.a3);

	
	}

		public void button1(View v){
			mPage1.setVisibility(View.VISIBLE);
			mPage2.setVisibility(View.INVISIBLE);
			mPage3.setVisibility(View.INVISIBLE);
			
		}
		public void button2(View v){
			mPage1.setVisibility(View.VISIBLE);
			mPage2.setVisibility(View.VISIBLE);
			mPage3.setVisibility(View.INVISIBLE);

		
		}public void button3(View v){
			mPage1.setVisibility(View.VISIBLE);
			mPage2.setVisibility(View.INVISIBLE);
			mPage3.setVisibility(View.VISIBLE);

		
		
		}
}
