/*
 * Copyright 2012 Google Inc.
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

package org.ozonecity.android.apps.mytracks.io.fusiontables;

import com.google.common.annotations.VisibleForTesting;

import android.content.Intent;

import org.ozonecity.android.apps.mytracks.io.sendtogoogle.AbstractSendActivity;
import org.ozonecity.android.apps.mytracks.io.sendtogoogle.AbstractSendAsyncTask;
import org.ozonecity.android.apps.mytracks.io.sendtogoogle.SendRequest;
import org.ozonecity.android.apps.mytracks.io.sendtogoogle.UploadResultActivity;
import org.ozonecity.android.apps.mytracks.io.spreadsheets.SendSpreadsheetsActivity;
import org.ozonecity.android.apps.mytracks.util.IntentUtils;
import org.ozonecity.android.maps.mytracks.R;

/**
 * An activity to send a track to Google Fusion Tables.
 * 
 * @author Jimmy Shih
 */
public class SendFusionTablesActivity extends AbstractSendActivity {

  @Override
  protected AbstractSendAsyncTask createAsyncTask() {
    return new SendFusionTablesAsyncTask(this, sendRequest.getTrackId(), sendRequest.getAccount());
  }

  @Override
  protected String getServiceName() {
    return getString(R.string.export_google_fusion_tables);
  }

  @Override
  protected void startNextActivity(boolean success, boolean isCancel) {
    sendRequest.setFusionTablesSuccess(success);
    Class<?> next = getNextClass(sendRequest, isCancel);
    Intent intent = IntentUtils.newIntent(this, next)
        .putExtra(SendRequest.SEND_REQUEST_KEY, sendRequest);
    startActivity(intent);
    finish();
  }

  @VisibleForTesting
  Class<?> getNextClass(SendRequest request, boolean isCancel) {
    if (isCancel) {
      return UploadResultActivity.class;
    } else {
      if (request.isSendSpreadsheets()) {
        return SendSpreadsheetsActivity.class;
      } else {
        return UploadResultActivity.class;
      }
    }
  }
}
