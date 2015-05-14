/*
 * Copyright 2013 Google Inc.
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

package org.ozonecity.android.apps.mytracks.settings;


import android.content.Context;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.util.AttributeSet;

import org.ozonecity.android.apps.mytracks.util.DialogUtils;

/**
 * My Tracks edit text preference.
 * 
 * @author Jimmy Shih
 */
public class MyTracksEditTextPreference extends EditTextPreference {

  public MyTracksEditTextPreference(Context context) {
    super(context);
  }
  
  public MyTracksEditTextPreference(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  protected void showDialog(Bundle state) {
    super.showDialog(state);
    DialogUtils.setDialogTitleDivider(getContext(), getDialog());
  }
}
