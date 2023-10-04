/**
 * Created By SPC On
 * Date:08/09/2023
 * Time:15:12
 * Project Name:spc.com.rccgphmbackend.repository
 */

package spc.com.rccgphmbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import spc.com.rccgphmbackend.model.MonthlyReport;

@Repository
public interface ReportRepository extends MongoRepository<MonthlyReport, String> {
}
