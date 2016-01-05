package com.vaiuu.androidcrashlogger;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * Activity - That appears when your application crashes.
 * 
 * @author Musafir Ali
 * 
 */
public class CrashActivity extends Activity {
	private Button btn_later;
	private Button btn_start;
	private Context context;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_login_alert);
		context = this;
		btn_later = (Button) findViewById(R.id.btn_later);
		btn_start = (Button) findViewById(R.id.btn_start);

		btn_later.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				CrashActivity.this.finish();
			}
		});
		btn_start.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(context, AppConstant.CRASH_MSG, Toast.LENGTH_LONG);
				toast.show();
				String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + AppConstant.LOG_DIR
						+ "crashlog.txt";
				Mail m = new Mail(AppConstant.EMAIL_ADDRESS, AppConstant.EMAILPASSWORD);
				String[] toArr =AppConstant.RECEIVER_EMAIL_ADDRESS;
				m.setTo(toArr);
				m.setFrom(AppConstant.EMAIL_ADDRESS);
				m.setSubject(AppConstant.EMAIL_SUBJECT);
				m.setBody(AppConstant.EMAIL_BODY);
				try {
					m.addAttachment(filePath);
					m.send();
				} catch (Exception e) {
					// Toast.makeText(MailApp.this,
					// "There was a problem sending the email.",
					// Toast.LENGTH_LONG).show();

					Log.e("MailApp", "Could not send email", e);
				}

				Process.killProcess(Process.myPid());
				System.exit(10);
				CrashActivity.this.finish();
			}
		});
	}

}
