package com.example.johncarter.thelon.admin_side;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.storage.StorageReference;

/**
 * Created by Acer on 16/03/2017.
 */

public class QrCode implements Parcelable {
    StorageReference storageReference;

    public QrCode(StorageReference storageReference) {
        this.storageReference = storageReference;
    }

    public StorageReference getStorageReference() {
        return storageReference;
    }

    protected QrCode(Parcel in) {
        in.readString();
    }

    public static final Creator<QrCode> CREATOR = new Creator<QrCode>() {
        @Override
        public QrCode createFromParcel(Parcel in) {
            return new QrCode(in);
        }

        @Override
        public QrCode[] newArray(int size) {
            return new QrCode[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
