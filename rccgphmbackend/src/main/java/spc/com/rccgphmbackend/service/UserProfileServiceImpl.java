/**
 * Created By SPC On
 * Date:12/09/2023
 * Time:01:45
 * Project Name:spc.com.rccgphmbackend.service
 */

package spc.com.rccgphmbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import spc.com.rccgphmbackend.exception.UserAlreadyExist;
import spc.com.rccgphmbackend.model.Region;
import spc.com.rccgphmbackend.model.Regions;
import spc.com.rccgphmbackend.model.UserProfile;
import spc.com.rccgphmbackend.repository.RegionRepository;
import spc.com.rccgphmbackend.repository.UserProfileRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserProfileServiceImpl implements UserProfileService{

    //Inject DB Relationship
    private UserProfileRepository userProfileRepository;
    private RegionRepository regionRepository;

    //Allow to create Criteria to config db
    private MongoTemplate mongoTemplate;

    private ApplicationContext applicationContext;

    @Override
    public UserProfile createUser(UserProfile userProfile) throws UserAlreadyExist {
        userProfile.setId(UUID.randomUUID().toString().split("-")[0]);

        // check if a user with the given first name already exists
        Criteria firstNameCriteria = Criteria.where("firstName").regex("^" + userProfile.getFirstName() + "$",  "i");
        Query query = new Query(firstNameCriteria);
        boolean userExist = mongoTemplate.exists(query, UserProfile.class);

        if (userExist){
            throw new UserAlreadyExist("A User With This First Name Already Exist, Pls Choose Another Name.");
        }

        // check if a user with the given email already exists
        boolean emailExist = mongoTemplate.exists( new Query(Criteria.where("email").is(userProfile.getEmail())), UserProfile.class);
        if (emailExist){
            throw new UserAlreadyExist("A user with this email address already exists.");
        }


        // Validate that the selected region exists in Regions
        Map<String, List<String>> regions = Regions.getRegions();
        String selectedRegion = userProfile.getRegion();
        if (!regions.containsKey(selectedRegion)) {
            throw new IllegalArgumentException("Selected Region Does Not Exist.");
        }

        // Validate that the selected province exists in the selected region
        List<String> provinces = regions.get(selectedRegion);
        String selectedProvince = userProfile.getProvince();
        if (!provinces.contains(selectedProvince)) {
            throw new IllegalArgumentException("Selected Province Does Not Exist in The Selected Region.");
        }

//        String selectedRegionName = userProfile.getRegion();
//        Optional<Region> selectedRegions = regionRepository.findByName(selectedRegionName);
//
//        if (selectedRegions.isPresent()) {
//            Region region = selectedRegions.get();
//            region.getUserProfileIds().add(userProfile.getId());
//            region.getUserProfiles().add(userProfile); // Make sure to set up the bidirectional relationship
//            regionRepository.save(region);
//        } else {
//            // Handle the case where the selected region doesn't exist
//            throw new IllegalArgumentException("Selected Region Does Not Exist.");
//        }

        // Set the selected province based on user input
        userProfile.setSelectedProvince(userProfile.getProvince());
        userProfile.setSelectedRegion(userProfile.getSelectedRegion());

        // Save the user profile to the UserProfile collection
        userProfile = userProfileRepository.save(userProfile);

        return userProfile;
    }

    @Override
    public List<UserProfile> getAllUsers() {
        return userProfileRepository.findAll();
    }

    @Override
    public UserProfile getUserById(String id) {
        //Check if Id exist with Optional method or lambda
        return userProfileRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User With ID" + id + " Doesn't Exit"));
    }

    @Override
    public UserProfile updateUser(UserProfile userProfile, String id) {
        //Check if Id exist with Optional method or lambda
        UserProfile userProfileExist = userProfileRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User With ID" + id + " Doesn't Exit"));
        userProfileExist.setTitle(userProfile.getTitle());
        userProfileExist.setFirstName(userProfile.getFirstName());
        userProfileExist.setLastName(userProfile.getLastName());
        userProfileExist.setEmail(userProfile.getEmail());
        userProfileExist.setPassword(userProfile.getPassword());
        userProfileExist.setState(userProfile.getState());
        userProfileExist.setRegion(userProfile.getRegion());
        userProfileExist.setProvince(userProfile.getProvince());
        userProfileExist.setZone(userProfile.getZone());
        userProfileExist.setArea(userProfile.getArea());
        userProfileExist.setParish(userProfile.getParish());
        userProfileExist.setLga(userProfile.getLga());
        userProfileExist.setPosition(userProfile.getPosition());
        userProfileExist.setJoinMinistry(userProfile.getJoinMinistry());
        userProfileExist.setOccupation(userProfile.getOccupation());
        userProfileExist.setDob(userProfile.getDob());
        userProfileExist.setPhoneNumber(userProfile.getPhoneNumber());
        userProfileExist.setSMHandle(userProfile.getSMHandle());
        userProfileExist.setHomeAddress(userProfile.getHomeAddress());
        userProfileExist.setOfficeAddress(userProfile.getOfficeAddress());
        userProfileExist.setNextOfKin(userProfile.getNextOfKin());
        userProfileExist.setNextOfKinPhone(userProfile.getNextOfKinPhone());
        userProfileExist.setImage(userProfile.getTitle());

        // Set the selected region and province based on user input
        //userProfile.setSelectedRegion(userProfile.getSelectedProvince());
        //userProfile.setSelectedProvince(userProfile.getSelectedProvince());

        // Validate that the selected region exists in Regions
        Map<String, List<String>> regions = Regions.getRegions();
        String selectedRegion = userProfile.getRegion();
        if (!regions.containsKey(selectedRegion)) {
            throw new IllegalArgumentException("Selected region does not exist.");
        }

        // Validate that the selected province exists in the selected region
        List<String> provinces = regions.get(selectedRegion);
        String selectedProvince = userProfile.getProvince();
        if (!provinces.contains(selectedProvince)) {
            throw new IllegalArgumentException("Selected Province Does Not Exist Tn The Selected Region.");
        }

        // Update region and province
        userProfileExist.setRegion(selectedRegion);
        userProfileExist.setProvince(selectedProvince);

        // Save update into db
        return userProfileRepository.save(userProfileExist);
    }

    @Override
    public void deleteUserById(String id) {
        //Check if Id exist with Optional method or lambda
        userProfileRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User With ID" + id + " Doesn't Exit"));
        userProfileRepository.deleteById(id);
    }
}
