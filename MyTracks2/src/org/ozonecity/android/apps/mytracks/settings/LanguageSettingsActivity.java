package org.ozonecity.android.apps.mytracks.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.EditText;

import java.util.prefs.PreferenceChangeListener;

import org.ozonecity.android.maps.mytracks.R;

public class LanguageSettingsActivity extends PreferenceActivity {
  
  private EditTextPreference languagePreference;
  private EditText text;
  public String language;
  
  //Preference change listener
  private PreferenceChangeListener mPreferenceListener = null;
  
  @SuppressWarnings("deprecation")
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.xml.language_settings);
    
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    String languageKey = getString(R.string.language_default_key);
    String languagePref = prefs.getString(languageKey, "");

    //language = Locale.getDefault().getLanguage();
    language = getResources().getConfiguration().locale.getLanguage();    
    
    if (languagePref == null || languagePref.equals("")) {
      if (savedInstanceState == null) {
        if (language == null || language.equals("")) {
          language = "en";
        }
      }
  
      languagePreference = (EditTextPreference) findPreference(
          getString(R.string.language_default_key));
      languagePreference.setText(String.valueOf(language));
    
    }
    
  }

}
