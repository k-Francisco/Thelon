package com.example.johncarter.thelon.admin_side;

import com.google.firebase.storage.StorageReference;

/**
 * Created by asus on 16/03/2017.
 */

public class Image {
    private StorageReference storageReference;

    public StorageReference getStorageReference() {
        return storageReference;
    }

    public void setStorageReference(StorageReference storageReference) {
        this.storageReference = storageReference;
    }

    public Image(StorageReference storageReference) {

        this.storageReference = storageReference;
    }
}
