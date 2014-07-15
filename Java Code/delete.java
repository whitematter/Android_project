package com.example.qnotes;




import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class delete extends Activity {
	LoginMainActivity olg=new LoginMainActivity();
	String tt=olg.u.toString();
	String t;
	Button obtnclose;
	Button obtndelete1;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete); 

        final Spinner osp1=(Spinner)findViewById(R.id.spinner2);
        database oabc=new database(getApplicationContext(),"database1",null,1);
     final EditText otv1=(EditText)findViewById(R.id.textView22);
     final Button obtndelete=(Button)findViewById(R.id.butndelete);
        
        final ArrayAdapter a=new ArrayAdapter(delete.this, android.R.layout.simple_spinner_item);
        final SQLiteDatabase db=oabc.getWritableDatabase();
        final SQLiteDatabase db1=oabc.getWritableDatabase();
        Cursor c=db.rawQuery("select title from notes where user_name='"+tt+"'", null);
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
 osp1.setAdapter(a);
 osp1.setOnItemSelectedListener(new OnItemSelectedListener() {

	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		otv1.setText("");
	 t=a.getItem(osp1.getSelectedItemPosition()).toString();
		
		Cursor c=db.rawQuery("select detail from notes where title='"+t+"'", null);
		if(c.moveToNext())
		{
			otv1.setText(c.getString(0));
		}
	}

	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
});
 obtndelete.setOnClickListener(new OnClickListener() {	
		public void onClick(View v) {
			// TODO Auto-generated method stub
	        initiatePopupWindow();
			
		
/*		 	db.execSQL("delete from notes where title='"+t+"'");
		 	db.acquireReference();
		 	Toast.makeText(getApplicationContext(), "note deleted", 5000).show();
		 	Intent in=new Intent(getApplicationContext(),ChoiceMainActivity.class);
			startActivity(in);
	*/		
			
		}
		private PopupWindow pwindo;
		private void initiatePopupWindow() {
			// TODO Auto-generated method stub
			try {
		 		// We need to get the instance of the LayoutInflater
		 		LayoutInflater inflater = (LayoutInflater) delete.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		 		View layout = inflater.inflate(R.layout.popup,(ViewGroup) findViewById(R.id.popup_element));
		 		pwindo = new PopupWindow(layout, 400, 300, true);
		 		pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
		 		obtnclose = (Button) layout.findViewById(R.id.close1);
		 		obtndelete1=(Button) layout.findViewById(R.id.btndelete1);
		 		
		 		obtnclose.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						pwindo.dismiss();
					}
				});
		 		
		 		obtndelete1.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						db.execSQL("delete from notes where title='"+t+"'");
					 	db.acquireReference();
					 	Toast.makeText(getApplicationContext(), "note deleted", 5000).show();
					 	Intent in=new Intent(getApplicationContext(),ChoiceMainActivity.class);
						startActivity(in);
						finish();
					}
				});
		 		} catch (Exception e) {
		 			e.printStackTrace();
		 			}
		}
	});
 

// private void initiatePopupWindow()
// 	{
// 	
// 		}
//
// private OnClickListener cancel_button_click_listener = new OnClickListener() {
// public void onClick(View v) {
// pwindo.dismiss();
//
// }
// };
 
 
// osp.setOnItemClickListener(new OnItemClickListener() {
//
//	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//			long arg3) {
//		// TODO Auto-generated method stub
//		String t=a.getItem(0).toString();
//		
//		Cursor c=db.rawQuery("select detail from notes where user_name='"+tt+"'", null);
//		if(c.moveToNext())
//		{
//			otv.setText(c.getString(0));
//		}
//	}
//});	 
	
	
	}
}

