# Android-Crash-Logger
#### How to use
Just add below line in your every activity.
```
 Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
```
Change below parameter as u have.Here LOG_DIR is where u want to save your log file on SD card.EMAIL_BODY is email contents,EMAIL_ADDRESS is the sender email address & EMAILPASSWORD is the password.RECEIVER_EMAIL_ADDRESS here you can set multiple email address for getting mail.
```
 public static final String LOG_DIR = "/www/CrashLog/logs/";
	public static String CRASH_MSG = "Message sent to Developer";
	public static String EMAIL_ADDRESS = " sender email address here";
	public static String EMAILPASSWORD = " sender email password here";
	public static String[]  RECEIVER_EMAIL_ADDRESS ={ "receiver email" };
	public static String EMAIL_SUBJECT = "Crah Log";
	public static String EMAIL_BODY = "This mail is come from user with crash log attached";
```


