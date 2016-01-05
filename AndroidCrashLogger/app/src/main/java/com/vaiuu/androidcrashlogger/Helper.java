package com.vaiuu.androidcrashlogger;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Utils class - Utility methods which are being used in the applications
 * 
 * @author Musafir Ali
 * 
 */
public class Helper {

	private static String TAG = "Crash Analytics";
	
	/**
	 * Save the error content in file at vm directory of the SD card
	 * 
	 * @param ErrorContent
	 * @param context
	 */
	void saveAsFile(String ErrorContent, Context context) {
		try {
			String filePath = Environment.getExternalStorageDirectory()
					.getAbsolutePath() + AppConstant.LOG_DIR;
			File dir = new File(filePath);
			// if vm directory doesn't exist then create it.
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File file = new File(filePath, "crashlog.txt");
			// if file exist then delete it & create it
			if (file.exists())
				file.delete();
			file.createNewFile();

			// write the error log in file
			FileOutputStream trace = new FileOutputStream(file);
			PrintStream printStream;
			printStream = new PrintStream(trace);
			printStream.println(ErrorContent);
			printStream.close();
			trace.close();
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
		}
	}

}
