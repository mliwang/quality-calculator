package cn.itcast.calculator;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

    private EditText et_name;
	private RadioGroup radiogroup;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = (EditText) findViewById(R.id.et_name);
        radiogroup = (RadioGroup) findViewById(R.id.RG);
           }
	public void click(View v){
		String name = et_name.getText().toString().trim();
		int sex=0;
		switch (radiogroup.getCheckedRadioButtonId()) {
		case R.id.male:
			sex=1;
			
			break;
		case R.id.female:
			sex=2;
			
			break;
		case R.id.other:
			sex=3;
			
			break;


		}
		if(sex==0){Toast.makeText(getApplicationContext(), "ÇëÑ¡ÔñÐÔ±ð", 1).show();}
		Intent intent =new Intent(this,ResultActivity.class);
		intent.putExtra("name", name);
		intent.putExtra("sex", sex);
		startActivity(intent);
		
	}

}
