package com.sign.in.app;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends Activity {

	SharedPreferences sp;
	SharedPreferences.Editor spe;

	String preferencename = "DataPreference";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		sp = this.getSharedPreferences(preferencename, 0);
		spe = sp.edit();
		String u = sp.getString("username", "");
		String p = sp.getString("password", "");

		TextView msg = (TextView) findViewById(R.id.message);
		msg.setText("Hi " + u + ", your password is " + p + "\n"
				+ "Enjoy your coding.");

		Button bsignout = (Button) findViewById(R.id.bsignout);
		bsignout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				spe.clear();
				spe.commit();
				finish();
			}
		});

	}
}
