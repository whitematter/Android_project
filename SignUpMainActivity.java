package com.example.qnotes;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpMainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_main);
       // final TextView otv=(TextView)findViewById(R.id.tvuser);
        //final TextView otv1=(TextView)findViewById(R.id.tvusername1);
        //final TextView otv2=(TextView)findViewById(R.id.tvpass1);
        //final TextView otv3=(TextView)findViewById(R.id.tvcnfrm);
        //final TextView otv4=(TextView)findViewById(R.id.tvconpass);
        final EditText oetname=(EditText)findViewById(R.id.etname);
        final EditText oetuname=(EditText)findViewById(R.id.etusername);
        final EditText oetpass=(EditText)findViewById(R.id.etpassword);
        final EditText oetcpass=(EditText)findViewById(R.id.etcon_pass);
        final Button obtn=(Button)findViewById(R.id.btn);
        database oabc=new database(getApplicationContext(),"database1",null,1);
        final SQLiteDatabase db=oabc.getWritableDatabase();

        obtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String n=oetname.getText().toString();
				String u_n=oetuname.getText().toString();
				String p=oetpass.getText().toString();
				String cp=oetcpass.getText().toString();
				Cursor c=db.rawQuery("select * from user where user_name='"+u_n+"'", null);
				if(c.moveToNext())
				{
					Toast.makeText(getApplicationContext(), "userName already existing",3000).show();
					oetname.setText("");
					oetuname.setText("");
					oetpass.setText("");
					oetcpass.setText("");
				}
				else
				{
				if(cp.equals(p.toString())){
				db.execSQL("insert into user values('"+n+"','"+u_n+"','"+p+"')");
				Toast.makeText(getApplicationContext(), "Registration Successful", 5000).show();
				oetname.setText("");
				oetuname.setText("");
				oetpass.setText("");
				oetcpass.setText("");
				Intent back=new Intent(getApplicationContext(), LoginMainActivity.class);
				startActivity(back);
				}
				else{
					Toast.makeText(getApplicationContext(), "password not match", 5000).show();
					oetname.setText("");
					oetuname.setText("");
					oetpass.setText("");
					oetcpass.setText("");
					
				}
				}
				
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_sign_up_main, menu);
        return true;
    }
}
