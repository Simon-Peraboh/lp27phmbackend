/**
 * Created By SPC On
 * Date:12/09/2023
 * Time:09:05
 * Project Name:spc.com.rccgphmbackend.contoller
 */

package spc.com.rccgphmbackend.contoller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spc.com.rccgphmbackend.exception.UserAlreadyExist;
import spc.com.rccgphmbackend.model.UserProfile;
import spc.com.rccgphmbackend.model.UserProfileCreationResponse;
import spc.com.rccgphmbackend.service.UserProfileService;

import java.util.List;

@RestController
@RequestMapping("api/v1/userprofile")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000/")
public class UserProfileController {

    //Inject Service Layer
    private UserProfileService userProfileService;

    // Build Create UserProfile Members REST API
//    @PostMapping()
//    public ResponseEntity<UserProfile> saveUser(@RequestBody UserProfile userProfile) throws UserAlreadyExist {
//        return new ResponseEntity<>(userProfileService.createUser(userProfile), HttpStatus.CREATED);
//    }
    @PostMapping()
    public ResponseEntity<UserProfileCreationResponse> saveUser(@RequestBody UserProfile userProfile) throws UserAlreadyExist {
        UserProfile createdUserProfile = userProfileService.createUser(userProfile);

        UserProfileCreationResponse response = new UserProfileCreationResponse();
        response.setMessage("UserProfile created successfully");
        response.setUserProfile(createdUserProfile);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }



    // Get All Members REST API
    @GetMapping()
    public List<UserProfile> getAll(){
        return userProfileService.getAllUsers();
    }

    //Get Member By Id REST API
    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getById(@PathVariable String id){
        return new ResponseEntity<>(userProfileService.getUserById(id), HttpStatus.OK);
    }

    //Update Member By Id API
    @PutMapping("/{id}")
    public ResponseEntity<UserProfile> updateUser(@RequestBody UserProfile userProfile, @PathVariable("id") String id){
        return new ResponseEntity<>(userProfileService.updateUser(userProfile, id), HttpStatus.OK);
    }

    //Delete Member By Id API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id){
        userProfileService.deleteUserById(id);
        return new ResponseEntity<>("User Deleted Successful " + id, HttpStatus.OK);
    }

}
