package spc.com.rccgphmbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spc.com.rccgphmbackend.model.MonthlyDuePayment;

public interface MonthlyDuePaymentRepository extends MongoRepository<MonthlyDuePayment, String> {
}
