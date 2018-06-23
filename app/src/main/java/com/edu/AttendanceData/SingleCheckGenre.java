package com.edu.AttendanceData;

import android.os.Parcel;

import com.thoughtbot.expandablecheckrecyclerview.models.SingleCheckExpandableGroup;

import java.util.List;

public class SingleCheckGenre extends SingleCheckExpandableGroup {

    private int iconResId;

    public SingleCheckGenre(String title, List items) {
        super(title, items);
    }

    protected SingleCheckGenre(Parcel in) {
        super(in);
    }

    public int getIconResId() {
        return iconResId;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SingleCheckGenre> CREATOR = new Creator<SingleCheckGenre>() {
        @Override
        public SingleCheckGenre createFromParcel(Parcel in) {
            return new SingleCheckGenre(in);
        }

        @Override
        public SingleCheckGenre[] newArray(int size) {
            return new SingleCheckGenre[size];
        }
    };
}


