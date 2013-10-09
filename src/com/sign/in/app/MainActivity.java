package com.sign.in.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button bsignin;
	EditText inuser, inpass;

	String username = "namaku";
	String password = "namaku123";
	String preferencename = "DataPreference";

	SharedPreferences sp;
	SharedPreferences.Editor spe;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		sp = this.getSharedPreferences(preferencename, 0);
		spe = sp.edit();

		bsignin = (Button) findViewById(R.id.bsignin);
		inuser = (EditText) findViewById(R.id.inusername);
		inpass = (EditText) findViewById(R.id.inpassword);

		bsignin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String u = inuser.getText().toString();
				String p = inpass.getText().toString();

				if (!u.equals("") && !p.equals("")) {
					matching(u, p);
				} else {
					ShowToast("fill the field. please..");
				}
			}
		});

		if (sp.contains("username") && sp.contains("password")) {
			GoestoNextActivity();
		}

	}

	protected void matching(String u, String p) {
		// TODO Auto-generated method stub
		if (u.equals(username) && p.equals(password)) {
			// pindah activity
			spe.putString("username", u);
			spe.putString("password", p);
			spe.commit();
			GoestoNextActivity();
		} else {
			ShowToast("wrong username or password");
			spe.clear();
		}
	}

	protected void ShowToast(String pesan) {
		// TODO Auto-generated method stub

		Toast.makeText(getApplicationContext(), pesan, Toast.LENGTH_SHORT)
				.show();
	}

	private void GoestoNextActivity() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(MainActivity.this, HomeActivity.class);
		startActivity(intent);
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
