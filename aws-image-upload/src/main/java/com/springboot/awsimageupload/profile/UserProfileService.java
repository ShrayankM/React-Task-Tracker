package com.springboot.awsimageupload.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileDao userProfileDao;

    List<UserProfile> getUserProfileList() {
        return userProfileDao.getUserProfileList();
    }
}
