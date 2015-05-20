package org.ozonecity.android.apps.mytracks.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.EditText;

import java.util.prefs.PreferenceChangeListener;

import org.ozonecity.android.maps.mytracks.R;

public class OtherSettingsActivity extends PreferenceActivity {
  
  private EditTextPreference languagePreference;
  private EditTextPreference autotimestopPreference;
  private EditTextPreference linkPreference;
  private EditText text;
  public String language;
  
  //Preference change listener
  private PreferenceChangeListener mPreferenceListener = null;
  
  @SuppressWarnings("deprecation")
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.xml.other_settings);
    
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

    String languageKey = getString(R.string.other_language_default_key);
    //language = Locale.getDefault().getLanguage();
    language = getResources().getConfiguration().locale.getLanguage();    
    
    String languagePref = prefs.getString(languageKey, "");
    if (languagePref == null || languagePref.equals("")) {
      if (savedInstanceState == null) {
        if (language == null || language.equals("")) {
          language = "en";
        }
      }
  
      // Set default for language
      languagePreference = (EditTextPreference) findPreference(
          getString(R.string.other_language_default_key));
      languagePreference.setText(String.valueOf(language));
    
    }
    
    //PreferenceManager.setDefaultValues(this, R.xml.other_settings, false);    
    
/*
    String autotimestopKey = getString(R.string.autotimestop_default_key);
    String autotimestopPref = prefs.getString(autotimestopKey, "");
    if (autotimestopPref == null || autotimestopPref.equals("")) {
      if (savedInstanceState == null) {

        autotimestopPreference = (EditTextPreference) findPreference(
            getString(R.string.autotimestop_default_key));
        autotimestopPreference.setText("0");
      
      }
    
    }
    
    String linkKey = getString(R.string.link_default_key);
    String linkPref = prefs.getString(linkKey, "");
    if (linkPref == null || linkPref.equals("")) {
      if (savedInstanceState == null) {

        linkPreference = (EditTextPreference) findPreference(
            getString(R.string.link_default_key));
        linkPreference.setText("-");
      
      }

    }    
*/
  }

}
