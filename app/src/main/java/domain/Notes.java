package domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;

public class Notes implements Parcelable {

    private final String name;
    private final String date;
    private final @DrawableRes int icon;


    public Notes(String name, String date, int icon) {
        this.name = name;
        this.date = date;
        this.icon = icon;
    }

    protected Notes(Parcel in) {
        name = in.readString();
        date = in.readString();
        icon = in.readInt();
    }

    public static final Creator<Notes> CREATOR = new Creator<Notes>() {
        @Override
        public Notes createFromParcel(Parcel in) {
            return new Notes(in);
        }

        @Override
        public Notes[] newArray(int size) {
            return new Notes[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }

    public String getDate() {
        return date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(date);
        parcel.writeInt(icon);
    }

}
