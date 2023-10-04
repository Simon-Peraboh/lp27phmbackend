/**
 * Created By SPC On
 * Date:22/09/2023
 * Time:19:19
 * Project Name:spc.com.rccgphmbackend.service
 */

package spc.com.rccgphmbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spc.com.rccgphmbackend.model.MonthlyDuePayment;
import spc.com.rccgphmbackend.repository.MonthlyDuePaymentRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MonthlyDuePaymentServiceImpl implements MonthlyDuePaymentService{

    //Inject Repository for db connection and saving
    private MonthlyDuePaymentRepository duePaymentRepository;


    @Override
    public MonthlyDuePayment saveReport(MonthlyDuePayment duePayment) {
        //Convert String Id generated to random number
        duePayment.setId(UUID.randomUUID().toString().split("-")[0]);
        return duePaymentRepository.save(duePayment);
    }

    @Override
    public List<MonthlyDuePayment> getAll() {
        return duePaymentRepository.findAll();
    }

    @Override
    public MonthlyDuePayment getReportById(String id) {
        //Check if Id exist before attempting with lambda expression
      return duePaymentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User With Id " + id + " Doesn't Exist"));
    }

    @Override
    public MonthlyDuePayment updateReport(MonthlyDuePayment duePayment, String id) {
        //Check if Id exist before attempting update with lambda expression
        MonthlyDuePayment paymentExist = duePaymentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User With Id " + id + " Doesn't Exist"));
        paymentExist.setAmount(duePayment.getAmount());
        paymentExist.setPaymentDate(duePayment.getPaymentDate());
        paymentExist.setProvince(duePayment.getProvince());
        paymentExist.setCreatedDate(duePayment.getCreatedDate());
        paymentExist.setProvinceCoordinator(duePayment.getProvinceCoordinator());
        paymentExist.setRefMonth(duePayment.getRefMonth());
        paymentExist.setWhoPaid(duePayment.getWhoPaid());
        paymentExist.setRemark(duePayment.getRemark());

        //Save update to db
        return duePaymentRepository.save(paymentExist);
    }

    @Override
    public void deleteReport(String id) {
        //Check if Id exist before attempting delete with lambda expression
        duePaymentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User With Id " + id + " Doesn't Exist"));
        duePaymentRepository.deleteById(id);

    }
}
