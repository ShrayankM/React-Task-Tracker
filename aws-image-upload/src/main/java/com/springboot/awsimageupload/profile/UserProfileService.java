package com.springboot.awsimageupload.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileDao userProfileDao;

    List<UserProfile> getUserProfileList() {
        return userProfileDao.getUserProfileList();
    }

    void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {

    }
}
