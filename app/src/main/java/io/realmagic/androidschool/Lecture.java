package io.realmagic.androidschool;

public class Lecture {
    private final int mNumber;
    private final String mData;
    private final String mTheme;
    private final String mLector;


    public Lecture(int mNumber, String mData, String mTheme, String mLector) {
        this.mData = mData;
        this.mTheme = mTheme;
        this.mLector = mLector;
        this.mNumber = mNumber;
    }

    public String getmData() {
        return mData;
    }

    public String getmTheme() {
        return mTheme;
    }

    public String getmLector() {
        return mLector;
    }

    public int getmNumber() {
        return mNumber;
    }
}
