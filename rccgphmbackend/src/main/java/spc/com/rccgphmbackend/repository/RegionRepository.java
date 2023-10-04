package spc.com.rccgphmbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import spc.com.rccgphmbackend.model.Region;

import java.util.Optional;

@Repository
public interface RegionRepository extends MongoRepository<Region, String> {
    Optional<Region> findByName(String name);
}
