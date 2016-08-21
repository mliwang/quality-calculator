package cn.itcast.calculator;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		TextView tv_name = (TextView) findViewById(R.id.tv_name);
		TextView tv_sex = (TextView) findViewById(R.id.tv_sex);
		TextView tv_result = (TextView) findViewById(R.id.tv_result);
		Intent intent =getIntent();
		String name = intent.getStringExtra("name");
		int sex=intent.getIntExtra("sex", 1);
		tv_name.setText(name);
		byte[] byte1=null;
		int total=0;
		try {
			switch (sex) {
			case 1:
				tv_sex.setText("��");
				byte1=name.getBytes("utf-8");
				
				break;

			case 2:
				tv_sex.setText("Ů");
				byte1=name.getBytes("gbk");
				
				break;
			case 3:
				tv_sex.setText("����");
				byte1=name.getBytes("iso-8859-1");
				break;
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��ȡ������
		for (byte b:byte1) {
			int number =b&0xff;
			total+=number;
			
		}
		int score =Math.abs(total)%100;
		if(score>=98){tv_result.setText("�������ð�����ˣ�����Ʒ��ֱ�ˣ���ȥ���Ʊ");}
		else if(score>=95){tv_result.setText("��Ʒ̫����,���ҵ���");}
		else if(score>=80){tv_result.setText("��Ʒ���պ�,�����ʺϲȵ�ɶ");}
		else if(score>=70){tv_result.setText("�����Ʒ�����Ƶ����ˣ�����");}
		else if(score>=60){tv_result.setText("�����Ʒ��ֱ����ֱ��");}
		else{tv_result.setText("�����Ʒ�������������ʺϻ�¯����");}
	}

}
