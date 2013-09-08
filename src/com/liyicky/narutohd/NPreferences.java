package com.liyicky.narutohd;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class NPreferences extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.n_prefs);

	}
}