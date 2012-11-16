package com.malinskiy.qcontrols;

import android.app.Activity;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for Quick Controls pie menu
 */
public class PieControl {

    protected Activity mActivity;
    protected PieMenu mPie;
    protected int mItemSize;

    public PieControl(Activity activity) {
        mActivity = activity;
        mItemSize = (int) activity.getResources().getDimension(R.dimen.qc_item_size);
    }

    protected void attachToContainer(ViewGroup container) {
        if (mPie == null) {
            mPie = new PieMenu(mActivity);
            LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT);
            mPie.setLayoutParams(lp);
            populateMenu();
        }
        container.addView(mPie);
    }

    protected void removeFromContainer(ViewGroup container) {
        container.removeView(mPie);
    }

    protected void forceToTop(ViewGroup container) {
        if (mPie.getParent() != null) {
            container.removeView(mPie);
            container.addView(mPie);
        }
    }

    protected void setClickListener(OnClickListener listener, PieItem... items) {
        for (PieItem item : items) {
            item.getView().setOnClickListener(listener);
        }
    }

    protected void populateMenu() {
    }

    protected PieItem makeItem(int image, int l) {
        ImageView view = new ImageView(mActivity);
        view.setImageResource(image);
        view.setMinimumWidth(mItemSize);
        view.setMinimumHeight(mItemSize);
        view.setScaleType(ScaleType.CENTER);
        LayoutParams lp = new LayoutParams(mItemSize, mItemSize);
        view.setLayoutParams(lp);
        return new PieItem(view, l);
    }

    protected PieItem makeFiller() {
        return new PieItem(null, 1);
    }
}