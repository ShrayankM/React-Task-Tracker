package com.springboot.awsimageupload.data;

import com.springboot.awsimageupload.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UserProfileData {

    public static final List<UserProfile> userProfileList = new ArrayList<>();

    static {
        userProfileList.add(new UserProfile(UUID.randomUUID(), "Sam", null));
        userProfileList.add(new UserProfile(UUID.randomUUID(), "Jack", null));
        userProfileList.add(new UserProfile(UUID.randomUUID(), "Tom", null));
    }

    public List<UserProfile> getUserProfileList() {
        return userProfileList;
    }
}
