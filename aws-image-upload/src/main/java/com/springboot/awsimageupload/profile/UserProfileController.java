package com.springboot.awsimageupload.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @RequestMapping(value = "api/v1/user-profile", method = RequestMethod.GET)
    public List<UserProfile> getUserProfiles() {
        return userProfileService.getUserProfileList();
    }
}