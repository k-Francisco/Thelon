package com.example.johncarter.thelon.home_tab;

import com.google.firebase.storage.StorageReference;

/**
 * Created by asus on 04/02/2017.
 */

public class PhotoReference {
    StorageReference storageReference;

    public PhotoReference(StorageReference storageReference) {
        this.storageReference = storageReference;
    }

    public StorageReference getStorageReference() {

        return storageReference;
    }

    public void setStorageReference(StorageReference storageReference) {
        this.storageReference = storageReference;
    }
}
