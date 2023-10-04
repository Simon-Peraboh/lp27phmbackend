package spc.com.rccgphmbackend.service;

import spc.com.rccgphmbackend.exception.UserAlreadyExist;
import spc.com.rccgphmbackend.model.UserProfile;

import java.util.List;

public interface UserProfileService {

    //Create & save UserProfile into db
    UserProfile createUser(UserProfile userProfile) throws UserAlreadyExist;

    //Return All Users as List
    List<UserProfile> getAllUsers();

    //Return A Single User By Id
    UserProfile getUserById(String id);

    //Update User By Id
    UserProfile updateUser(UserProfile userProfile, String id);

    //Delete User By Id
    void deleteUserById(String id);
}
