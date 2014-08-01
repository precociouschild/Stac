package com.example.baby;

import java.io.File;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager.OnActivityResultListener;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PictureActivity extends Activity {
	static int REQUEST_PICTURE = 1;
	//아래 2개의 코드는 startactivityforResult의값에 들어가면 onActivityResult의 리퀘스트값으로 바로들어감 그래서 구분하면됨
	static int REQUEST_PHOTO_ALBUM1 = 21;
	static int REQUEST_PHOTO_ALBUM2 = 22;
	
	static String SAMPLEIMG = "photo.png";
	Context mContext = this;
	ImageView iv,iv2;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.picturepage);
		 iv = (ImageView) findViewById(R.id.imgView1);
		 iv2 = (ImageView) findViewById(R.id.imgView2);
		
}

    //button �대┃
    Dialog dialog;
    public void onClickImg(View v) {
    	switch(v.getId()) {
    	case R.id.getCustom:
    		AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
    		View customLayout = View.inflate(mContext, R.layout.custom_button, null);
    		builder.setView(customLayout);
    		dialog = builder.create();
    		dialog.show();
    		break;
    	case R.id.camera:
    		dialog.dismiss();
    		takePicture();
    		break;
    	case R.id.photoAlbum:
    		dialog.dismiss();
    		photoAlbum();               
    		break;
    	}
    }
    
    public void onClickImg2(View v) {
    	switch(v.getId()) {
    	case R.id.getCustom2:
    		AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
    		View customLayout = View.inflate(mContext, R.layout.custom_button, null);
    		builder.setView(customLayout);
    		dialog = builder.create();
    		dialog.show();
    		break;
    	case R.id.camera:
    		dialog.dismiss();
    		takePicture();
    		break;
    	case R.id.photoAlbum:
    		dialog.dismiss();
    		photoAlbum2();               
    		break;
    	}
    }
    
    
  
    //�ъ쭊 珥ъ쁺
  	void takePicture() {
  		//移대찓���몄텧 intent �앹꽦
  		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
  		File file = new File(Environment.getExternalStorageDirectory(), SAMPLEIMG);
  		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
  		startActivityForResult(intent, REQUEST_PICTURE);
  	}
  	
  	//�ъ쭊 遺덈윭�ㅺ린
  	void photoAlbum() {
  		//photo Album �몄텧 intent �앹꽦
  		Intent intent = new Intent(Intent.ACTION_PICK);
  		intent.setType(Images.Media.CONTENT_TYPE);
  		intent.setData(Images.Media.EXTERNAL_CONTENT_URI);
  		startActivityForResult(intent, REQUEST_PHOTO_ALBUM1);
  	}
  	void photoAlbum2() {
  		//photo Album �몄텧 intent �앹꽦
  		Intent intent = new Intent(Intent.ACTION_PICK);
  		intent.setType(Images.Media.CONTENT_TYPE);
  		intent.setData(Images.Media.EXTERNAL_CONTENT_URI);
  		startActivityForResult(intent, REQUEST_PHOTO_ALBUM2);
  	}


  	
  	//珥ъ쁺���ъ쭊���섏젙�섍린 �꾪빐��  	
  	Bitmap loadPicture() 
  	{
  		File file = new File(Environment.getExternalStorageDirectory(), SAMPLEIMG);
  		BitmapFactory.Options option = new BitmapFactory.Options();
  		option.inSampleSize = 4;
  		return BitmapFactory.decodeFile(file.getAbsolutePath(), option);
  	}
  	
  	@Override
  	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
  		// TODO Auto-generated method stub
  		super.onActivityResult(requestCode, resultCode, data);
  		
  		if(resultCode != RESULT_OK)
  			return;
  		//카메라로 찍은후 불러오는 코드 이거없으면 사진만찍히고 못불러온다
  		if(requestCode == REQUEST_PICTURE) {
  			iv.setImageBitmap(loadPicture());
  		}
  		//앨범에서 가져옴 
  		if(requestCode == REQUEST_PHOTO_ALBUM1) {
  			iv.setImageURI(data.getData());
  		}
  		if(requestCode == REQUEST_PHOTO_ALBUM2) {
  			iv2.setImageURI(data.getData());
  		}
  		
  		
  	}
	
	
	
	
	
	public void resultButton(View v){
		Intent intent = new Intent(this, Result_Activity.class);
		startActivity(intent);
		finish();
	}
}
