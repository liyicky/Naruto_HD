package com.liyicky.narutohd;

import com.flurry.android.FlurryAgent;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Splash extends Activity {

	private Thread timer;
	private MediaPlayer intro;
	private SharedPreferences getPrefs;
	private SharedPreferences getPrefs2;
	final Splash splash = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		FlurryAgent.logEvent("App Opened");
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash);

		StartAni();
		timer = new Thread() {
			public void run() {
				try {

					synchronized (this) {
						sleep(2000);

					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {

					overridePendingTransition(R.anim.appear, R.anim.disappear);
					Intent intent = new Intent();
					intent.setClass(splash, WebViewPager.class);
					startActivity(intent);

				}
			}
		};

		getPrefs = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		boolean skipSplash = getPrefs.getBoolean("splash_checkbox", true);
		if (skipSplash == false) {
			Intent intent = new Intent();
			intent.setClass(splash, WebViewPager.class);
			startActivity(intent);
		} else {
			timer.start();
		}

		intro = MediaPlayer.create(Splash.this, R.raw.sharingan_sound);
		getPrefs2 = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		boolean music = getPrefs2.getBoolean("sound_checkbox", false);
		if (music == true && skipSplash == true) {
			intro.start();
		}

	}

	private void StartAni() {

		Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
		anim.reset();
		RelativeLayout l = (RelativeLayout) findViewById(R.id.splash);
		l.clearAnimation();
		l.startAnimation(anim);

		anim.reset();
		final ImageView i = (ImageView) findViewById(R.id.sharingan);
		i.clearAnimation();
		i.startAnimation(anim);

		Animation animR = AnimationUtils.loadAnimation(this, R.anim.rotate);
		animR.reset();
		l.clearAnimation();
		l.startAnimation(animR);

		Handler h = new Handler();
		h.postDelayed(new Runnable() {
			@Override
			public void run() {
				i.setImageResource(R.drawable.tomoe_256_2);

			}
		}, 1000);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		intro.release();
		finish();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
