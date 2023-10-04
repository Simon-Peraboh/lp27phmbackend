package spc.com.rccgphmbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import spc.com.rccgphmbackend.model.Region;
import spc.com.rccgphmbackend.repository.RegionRepository;

import java.util.Optional;

public interface RegionsService {

//    @Autowired
//    private RegionRepository regionRepository;
//
//    String selectedRegionName = userProfile.getRegion();
//    Optional<Region> selectedRegions = regionRepository.findByName(selectedRegionName);
//
//        if (selectedRegions.isPresent()) {
//        Region region = selectedRegions.get();
//        region.getUserProfileIds().add(userProfile.getId());
//        region.getUserProfiles().add(userProfile); // Make sure to set up the bidirectional relationship
//        regionRepository.save(region);
//    } else {
//        // Handle the case where the selected region doesn't exist
//        throw new IllegalArgumentException("Selected Region Does Not Exist.");
//    }


}
