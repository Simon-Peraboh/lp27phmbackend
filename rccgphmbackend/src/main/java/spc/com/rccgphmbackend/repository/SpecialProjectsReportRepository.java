package spc.com.rccgphmbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spc.com.rccgphmbackend.model.SpecialProjectsReport;

public interface SpecialProjectsReportRepository extends MongoRepository<SpecialProjectsReport, String> {
}
