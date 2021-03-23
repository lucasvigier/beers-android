package vigier.android.mini_projet_adnroid;

import android.os.Parcel;
import android.os.Parcelable;

public class Beer implements Parcelable {
    private String title;
    private int id;
    private String imgURL;
    private String date;
    private String color;
    private String desc;

    public Beer(int id) {
        this.id = id;
    }

    protected Beer(Parcel in) {
        title = in.readString();
        id = in.readInt();
        imgURL = in.readString();
        date = in.readString();
        color = in.readString();
        desc = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(id);
        dest.writeString(imgURL);
        dest.writeString(date);
        dest.writeString(color);
        dest.writeString(desc);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Beer> CREATOR = new Creator<Beer>() {
        @Override
        public Beer createFromParcel(Parcel in) {
            return new Beer(in);
        }

        @Override
        public Beer[] newArray(int size) {
            return new Beer[size];
        }
    };
}
