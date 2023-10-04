package spc.com.rccgphmbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import spc.com.rccgphmbackend.model.QuarterlyReport;
@Repository
public interface QuarterlyReportRepository extends MongoRepository<QuarterlyReport, String> {
}
