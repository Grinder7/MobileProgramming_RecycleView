package com.example.recycleview1;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Hero implements Parcelable {
    private String name;
    private String description;
    private int image;

    public Hero(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    protected Hero(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.image = in.readInt();
    }

    public static final Creator<Hero> CREATOR = new Creator<Hero>() {
        @Override
        public Hero createFromParcel(Parcel in) {
            return new Hero(in);
        }

        @Override
        public Hero[] newArray(int size) {
            return new Hero[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeInt(image);
    }
}
