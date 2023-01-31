package com.springboot.awsimageupload.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @RequestMapping(path = "api/v1/user-profile", method = RequestMethod.GET)
    public List<UserProfile> getUserProfiles() {
        return userProfileService.getUserProfileList();
    }

    @RequestMapping(path = "api/v1/user-profile/{userProfileId}/image/upload", method = RequestMethod.POST,
                    consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void uploadUserProfileImage(@PathVariable UUID userProfileId, @RequestBody MultipartFile file) {
        userProfileService.uploadUserProfileImage(userProfileId, file);
    }
}
