package spc.com.rccgphmbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import spc.com.rccgphmbackend.model.NationalReport;
@Repository
public interface NationalReportRepository extends MongoRepository<NationalReport, String> {
}
