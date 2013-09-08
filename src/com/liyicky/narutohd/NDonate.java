package com.liyicky.narutohd;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NDonate extends Activity {
	private ImageButton donater;
	private Button adLoader;
	private Button emailer;
	private String eAddress[] = {"liyicky@gmail.com"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.n_donate);
		StartAni();

		donater = (ImageButton) findViewById(R.id.btn_donate);
		donater.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ProgressDialog ppDialog = new ProgressDialog(NDonate.this);
				ppDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
				ppDialog.setMessage("Loading PayPal...");
				ppDialog.show();
				Intent i = new Intent(NDonate.this, DonateView.class);
				startActivity(i);
				finish();
			}
		});

		adLoader = (Button) findViewById(R.id.btn_ad);
		adLoader.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent a = new Intent(NDonate.this, NAdView.class);
				startActivity(a);
				finish();

			}
		});
		
		emailer = (Button) findViewById(R.id.btn_email);
		emailer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent e = new Intent(android.content.Intent.ACTION_SEND);
				e.putExtra(android.content.Intent.EXTRA_EMAIL, eAddress);
				e.putExtra(android.content.Intent.EXTRA_SUBJECT, "Naruto HDTV App Email");
				e.setType("plain/text");
				startActivity(e);
				finish();

			}
		});


	}

	private void StartAni() {

		Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha_two);
		anim.reset();
		LinearLayout l = (LinearLayout) findViewById(R.id.dbz_donate);
		l.clearAnimation();
		l.startAnimation(anim);

		anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
		anim.reset();
		ImageView i = (ImageView) findViewById(R.id.iv_tomoe_3);
		i.clearAnimation();
		i.startAnimation(anim);
		
		Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.alpha_two);
		anim.reset();
		TextView tv = (TextView) findViewById(R.id.tv_donate);
		tv.clearAnimation();
		tv.startAnimation(anim2);
	}
	
	@Override
	public void onBackPressed() {

	    finish();
	   
	}

}
