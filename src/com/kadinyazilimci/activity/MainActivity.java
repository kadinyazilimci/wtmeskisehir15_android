package com.kadinyazilimci.activity;

import java.util.Random;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {

	int my_random;
	int user_random;
	Resources res;

	Button ifeellucky;
	Button tryagain;
	EditText user_guess;
	ImageView situation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ifeellucky = (Button) findViewById(R.id.button_ifeellucky);
		tryagain = (Button) findViewById(R.id.button_tryagain);
		user_guess = (EditText) findViewById(R.id.user_guess);
		situation = (ImageView) findViewById(R.id.situation);

		res = getResources();

		my_random = randInt(1, 10);

		ifeellucky.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				String user_string = user_guess.getText().toString();
				
				if(user_string.equals("")){
					
				}
				else{
					
					user_random = Integer.parseInt(user_string);
				if (my_random > user_random) {
					/**
					 * user inputs a smaller number
					 * 
					 * put a higher number
					 * 
					 * */

					situation.setImageDrawable(res.getDrawable(R.drawable.up));
					user_guess.setText("");

				}

				else if (my_random < user_random) {

					/**
					 * user inputs a higher number
					 * 
					 * put a smaller number
					 * 
					 * */
					situation.setImageDrawable(res.getDrawable(R.drawable.down));
					user_guess.setText("");

				}

				else if (my_random == user_random) {

					/**
					 * user inputs equal number
					 * 
					 * congrats!
					 * 
					 * */

					situation.setImageDrawable(res
							.getDrawable(R.drawable.check));
					user_guess.setText("");

				} 
				else if (user_guess == null) {
					
					user_guess.setText("WTF?!");
					
				}
				else {
					/**
					 * sth went wrong.. meh..
					 * */
				}
				}

			}
		});

		tryagain.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				my_random = randInt(1, 10);

			}
		});

	}

	public static int randInt(int min, int max) {

		// NOTE: Usually this should be a field rather than a method
		// variable so that it is not re-seeded every call.
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

}
