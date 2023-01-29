package com.springboot.awsimageupload.profile;

import com.springboot.awsimageupload.data.UserProfileData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserProfileDao {

    @Autowired
    public final UserProfileData userProfileData;

    public UserProfileDao(UserProfileData userProfileData) {
        this.userProfileData = userProfileData;
    }

    List<UserProfile> getUserProfileList() {
        return userProfileData.getUserProfileList();
    }
}
