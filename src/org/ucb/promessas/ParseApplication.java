package org.ucb.promessas;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseCrashReporting;
import com.parse.ParseUser;

public class ParseApplication extends Application {

  private static final String YOUR_APPLICATION_ID = "uObRSM2Y5pXMLsyEMmTjouO9xZhXHEkMavSJDi60";
  private static final String YOUR_CLIENT_KEY = "EWwjKIxgwNLDuL8sAEnsyUDWb5T7nlfg6ttIOkad";

@Override
  public void onCreate() {
    super.onCreate();

    // Initialize Crash Reporting.
    ParseCrashReporting.enable(this);

    // Enable Local Datastore.
    Parse.enableLocalDatastore(this);

    // Add your initialization code here
    Parse.initialize(this, YOUR_APPLICATION_ID, YOUR_CLIENT_KEY);


    ParseUser.enableAutomaticUser();
    ParseUser.getCurrentUser().saveInBackground();
    
    ParseACL defaultACL = new ParseACL();
    // Optionally enable public read access.
    defaultACL.setPublicReadAccess(true);
    ParseACL.setDefaultACL(defaultACL, true);
  }
}
