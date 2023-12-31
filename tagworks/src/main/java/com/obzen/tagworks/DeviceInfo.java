//	Copyright 2023 Obzen
//
//	Licensed under the Apache License, Version 2.0 (the "License");
//	you may not use this file except in compliance with the License.
//	You may obtain a copy of the License at
//
//	    http://www.apache.org/licenses/LICENSE-2.0
//
//	Unless required by applicable law or agreed to in writing, software
//	distributed under the License is distributed on an "AS IS" BASIS,
//	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//	See the License for the specific language governing permissions and
//	limitations under the License.

package com.obzen.tagworks;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Locale;

/**
 * The type Device info.
 */
public class DeviceInfo {

    private final Context context;
    private final String httpAgent;
    private final String jvmVersion;
    private final String language;
    private final int[] resolution;
    private final String release;
    private final String model;
    private final String buildId;

    /**
     * Instantiates a new Device info.
     *
     * @param context the context
     */
    public DeviceInfo(@NonNull Context context){
        this.context = context;
        this.httpAgent = System.getProperty("http.agent");
        this.jvmVersion = System.getProperty("java.vm.version");
        this.language = Locale.getDefault().getLanguage();
        this.resolution = getCurrentDeviceSize();
        this.release = Build.VERSION.RELEASE;
        this.model = Build.MODEL;
        this.buildId = Build.ID;
    }

    /**
     * Get http agent string.
     *
     * @return the string
     */
    @Nullable
    public String getHttpAgent(){
        return httpAgent;
    }

    /**
     * Get jvm version string.
     *
     * @return the string
     */
    @Nullable
    public String getJvmVersion(){
        return jvmVersion;
    }

    /**
     * Get language string.
     *
     * @return the string
     */
    @Nullable
    public String getLanguage(){
        return language;
    }

    /**
     * Get resolution int [ ].
     *
     * @return the int [ ]
     */
    @Nullable
    public int[] getResolution(){
        return resolution;
    }

    @Nullable
    private int[] getCurrentDeviceSize(){
        try{
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display display;
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            display = windowManager.getDefaultDisplay();
            display.getRealMetrics(displayMetrics);
            return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
        }catch (Exception e){
            return null;
        }
    }

    /**
     * Get release string.
     *
     * @return the string
     */
    @Nullable
    public String getRelease(){
        return release;
    }

    /**
     * Get model string.
     *
     * @return the string
     */
    @Nullable
    public String getModel(){
        return model;
    }

    /**
     * Get build id string.
     *
     * @return the string
     */
    @Nullable
    public String getBuildId(){
        return buildId;
    }

    /**
     * Get user agent string.
     *
     * @return the string
     */
    @NonNull
    public String getUserAgent(){
        String httpAgent = getHttpAgent();
        if (httpAgent == null || httpAgent.startsWith("Apache-HttpClient/UNAVAILABLE (java")) {
            String dalvik = getJvmVersion();
            if (dalvik == null) dalvik = "0.0.0";
            String android = getRelease();
            String model = getModel();
            String build = getBuildId();

            httpAgent = String.format(Locale.US,
                    "Dalvik/%s (Linux; U; Android %s; %s Build/%s)",
                    dalvik, android, model, build
            );
        }
        return httpAgent;
    }
}
