package com.springboot.awsimageupload.bucket;

public enum BucketName {

    PROFILE_IMAGE("aws-image-upload-app");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    String getBucketName() {
        return this.bucketName;
    }
}
