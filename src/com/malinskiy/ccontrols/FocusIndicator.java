package com.malinskiy.ccontrols;

public interface FocusIndicator {
    public void showStart();
    public void showSuccess(boolean timeout);
    public void showFail(boolean timeout);
    public void clear();
}
