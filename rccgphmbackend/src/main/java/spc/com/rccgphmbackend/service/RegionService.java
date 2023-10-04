package spc.com.rccgphmbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spc.com.rccgphmbackend.model.Region;
import spc.com.rccgphmbackend.model.UserProfile;
import spc.com.rccgphmbackend.repository.RegionRepository;

import java.util.Optional;

@Service
public class RegionService {

    private final RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public void saveUserProfileInRegion(UserProfile userProfile, String selectedRegion) {
        Optional<Region> selectedRegionEntity = regionRepository.findByName(selectedRegion);

        if (selectedRegionEntity.isPresent()) {
            Region region = selectedRegionEntity.get();

            // Add the user's ID to the list of user profile IDs in the region
            region.getUserProfileIds().add(userProfile.getId());

            // Add the user profile to the list of user profiles in the region
            region.getUserProfiles().add(userProfile);

            // Save the updated region
            regionRepository.save(region);
        } else {
            // Handle the case where the selected region doesn't exist
            throw new IllegalArgumentException("Selected Region Does Not Exist.");
        }
    }
}
