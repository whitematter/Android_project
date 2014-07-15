package com.example.qnotes;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Q_notes_MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_q_notes__main);

		
		Thread timer=new Thread(){
	public void run(){
		try {
			sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			Intent login=new Intent(getApplicationContext(), LoginMainActivity.class);
			startActivity(login);
			finish();
		}
	}
			
			
		};
		timer.start();
	}

    
}
