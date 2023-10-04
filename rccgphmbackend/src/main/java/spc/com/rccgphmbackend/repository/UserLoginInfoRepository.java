package spc.com.rccgphmbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import spc.com.rccgphmbackend.model.UserLoginInfo;

import java.util.Optional;
@Repository
public interface UserLoginInfoRepository extends MongoRepository<UserLoginInfo, String> {
    Optional<UserLoginInfo> findByName(String username);
}
