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
