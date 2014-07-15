package com.example.qnotes;

import android.R.string;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class view_main extends Activity{
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.view_main);

	        final Spinner osp=(Spinner)findViewById(R.id.spinner1);
	        database oabc=new database(getApplicationContext(),"database1",null,1);
	     final EditText otv=(EditText)findViewById(R.id.textView2);
	        
	        final ArrayAdapter a=new ArrayAdapter(view_main.this, android.R.layout.simple_spinner_item);
	        final SQLiteDatabase db=oabc.getWritableDatabase();
	        Cursor c=db.rawQuery("select title from notes", null);
	       if(c.moveToNext())
	       {
	    	 do
	    	 {
	    		 a.add(c.getString(0));
	    	 }while(c.moveToNext());
	       }
	       else
	       {
	    	   Toast.makeText(getApplicationContext(),"title not found", 5000).show();
	       }
	 osp.setAdapter(a);
	 osp.setOnItemSelectedListener(new OnItemSelectedListener() {

		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			otv.setText("");
			String t=a.getItem(osp.getSelectedItemPosition()).toString();
			
			Cursor c=db.rawQuery("select detail from notes where title='"+t+"'", null);
			if(c.moveToNext())
			{
				otv.setText(c.getString(0));
			}
		}

		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	});
	 
//	 osp.setOnItemClickListener(new OnItemClickListener() {
//
//		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//				long arg3) {
//			// TODO Auto-generated method stub
//			String t=a.getItem(0).toString();
//			
//			Cursor c=db.rawQuery("select detail from notes where title='"+t+"'", null);
//			if(c.moveToNext())
//			{
//				otv.setText(c.getString(0));
//			}
//		}
//	});	 
}
	 
	 
}

