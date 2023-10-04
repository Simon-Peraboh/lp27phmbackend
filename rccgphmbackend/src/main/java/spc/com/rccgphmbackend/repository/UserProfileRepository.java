package spc.com.rccgphmbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spc.com.rccgphmbackend.model.UserProfile;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
}
