package com.springboot.awsimageupload.profile;

import com.springboot.awsimageupload.bucket.BucketName;
import com.springboot.awsimageupload.filestore.FileStore;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileDao userProfileDao;

    @Autowired
    private FileStore fileStore;

    List<UserProfile> getUserProfileList() {
        return userProfileDao.getUserProfileList();
    }

    void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {
        //* TODO to check if the file is empty or not
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload an empty file");
        }

        //* TODO to check if file is an image or not
        List<String> imageTypes = Arrays.asList(ContentType.IMAGE_JPEG.toString(), ContentType.IMAGE_PNG.toString());
        if (!imageTypes.contains(file.getContentType())) {
            throw new IllegalStateException("Profile Image has to be a JPEG or PNG");
        }

        //* TODO to check if user is actually present in DB
        List<UserProfile> userProfileList = userProfileDao.getUserProfileList();
        List<UUID> userProfileIds = userProfileList.stream().map(UserProfile::getUserProfileId).collect(Collectors.toList());
        if (!userProfileIds.contains(userProfileId)) {
            throw new IllegalStateException(String.format("User with id = %s not found in the database", userProfileId));
        }

        //* ! Alternate way using only stream
//        userProfileDao.getUserProfileList()
//                .stream()
//                .filter(userProfile -> userProfile.getUserProfileId().equals(userProfileId))
//                .findFirst()
//                .orElseThrow(() -> new IllegalStateException(String.format("User with id = %s not found in the database", userProfileId)));

        //* TODO get metadata from the image file
        Map<String, String> metaData = new HashMap<>();
        metaData.put("Content-Type", file.getContentType());
        metaData.put("Content-Length", String.valueOf(file.getSize()));

        //* TODO Store the file in the AWS S3 bucket in different folder per User
        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), userProfileId);
        String fileName = String.format("%s-%s", file.getName(), UUID.randomUUID());
        try {
            fileStore.saveFile(path, fileName, Optional.of(metaData), file.getInputStream());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
