/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Modified by anton@malinskiy.com
 */

package com.malinskiy.ccontrols;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.util.Log;

//import com.android.camera.CameraPreference.OnPreferenceChangedListener;
//import com.android.camera.drawable.TextDrawable;
//import com.android.camera.ui.PieItem;
//import com.android.camera.ui.PieItem.OnClickListener;
//import com.android.camera.ui.PieRenderer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PieController {

    protected Activity mActivity;
    protected PieRenderer mRenderer;

    public PieController(Activity activity, PieRenderer pie) {
        mActivity = activity;
        mRenderer = pie;
    }

    public PieItem makeItem(int resId) {
        // We need a mutable version as we change the alpha
        Drawable d = mActivity.getResources().getDrawable(resId).mutate();
        return new PieItem(d, 0);
    }
}
