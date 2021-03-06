/*
 * Copyright 2008 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.ozonecity.android.apps.mytracks.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Utilities for EULA.
 * 
 * @author Jimmy Shih
 */
public class EulaUtils {

  private static final String EULA_PREFERENCE_FILE = "eula";

  // Accepting Google mobile terms of service
  private static final String ACCEPTED_EULA_PREFERENCE_KEY = "eula.google_mobile_tos_accepted";
  private static final String SHOW_ENABLE_SYNC_PREFERENCE_KEY = "showEnableSync";

  private EulaUtils() {}

  /**
   * Returns true if has accepted eula.
   * 
   * @param context the context
   */
  public static boolean hasAcceptedEula(Context context) {
    return getValue(context, ACCEPTED_EULA_PREFERENCE_KEY, false);
  }

  /**
   * Sets to true accepted eula.
   * 
   * @param context the context
   */
  public static void setAcceptedEula(Context context) {
    setValue(context, ACCEPTED_EULA_PREFERENCE_KEY, true);
  }

  /**
   * Returns true if should show enable sync.
   * 
   * @param context the context
   */
  public static boolean showEnableSync(Context context) {
    return getValue(context, SHOW_ENABLE_SYNC_PREFERENCE_KEY, true);
  }

  /**
   * Sets to false show enable sync.
   * 
   * @param context the context
   */
  public static void setShowEnableSync(Context context) {
    setValue(context, SHOW_ENABLE_SYNC_PREFERENCE_KEY, false);
  }

  private static boolean getValue(Context context, String key, boolean defaultValue) {
    SharedPreferences sharedPreferences = context.getSharedPreferences(
        EULA_PREFERENCE_FILE, Context.MODE_PRIVATE);
    return sharedPreferences.getBoolean(key, defaultValue);
  }

  @SuppressLint("CommitPrefEdits")
  private static void setValue(Context context, String key, boolean value) {
    SharedPreferences sharedPreferences = context.getSharedPreferences(
        EULA_PREFERENCE_FILE, Context.MODE_PRIVATE);
    Editor editor = sharedPreferences.edit();
    editor.putBoolean(key, value);
    ApiAdapterFactory.getApiAdapter().applyPreferenceChanges(editor);
  }
}
