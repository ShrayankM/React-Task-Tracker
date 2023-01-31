package com.springboot.awsimageupload.bucket;

import org.springframework.context.annotation.Bean;

public enum BucketName {

    PROFILE_IMAGE("aws-image-upload-app");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return this.bucketName;
    }
}
