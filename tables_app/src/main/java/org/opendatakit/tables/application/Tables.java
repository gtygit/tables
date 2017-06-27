/*
 * Copyright (C) 2014 University of Washington
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.opendatakit.tables.application;

import org.opendatakit.application.CommonApplication;
import org.opendatakit.tables.R;

import java.lang.ref.WeakReference;

/**
 * The application, holds a reference to itself and a very helpful getDatabase method
 */
public class Tables extends CommonApplication {

  /**
   * Used for logging
   */
  @SuppressWarnings("unused")
  private static final String TAG = Tables.class.getSimpleName();

  private static WeakReference<Tables> singleton = new WeakReference<>(null);

  public static Tables getInstance() {
    return singleton.get();
  }

  @Override
  public void onCreate() {
    super.onCreate();
    if (singleton.get() == null) {
      singleton = new WeakReference<>(this);
    }
  }

  @Override
  public int getApkDisplayNameResourceId() {
    return R.string.app_name;
  }

  @Override
  public int getConfigZipResourceId() {
    return R.raw.configzip;
  }

  @Override
  public int getSystemZipResourceId() {
    return R.raw.systemzip;
  }

  @Override
  public int getWebKitResourceId() {
    return -1; // R.id.webkit;
  }

  public String getVersionedToolName() {
    String versionDetail = this.getVersionDetail();
    return getString(R.string.app_name) + versionDetail;
  }
}
