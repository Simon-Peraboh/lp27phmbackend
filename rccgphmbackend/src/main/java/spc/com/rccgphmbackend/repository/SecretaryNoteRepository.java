package spc.com.rccgphmbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spc.com.rccgphmbackend.model.SecretaryNote;

public interface SecretaryNoteRepository extends MongoRepository<SecretaryNote, String> {
}
