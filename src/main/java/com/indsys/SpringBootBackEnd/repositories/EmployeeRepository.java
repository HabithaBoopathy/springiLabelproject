package com.indsys.SpringBootBackEnd.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import com.indsys.SpringBootBackEnd.models.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee> getByVerificationStatus(String verificationStatus);

    @Query(value = "{'emailId':?0}")
    Employee getByEmployeeEmail(String emailId);

    @Query(value = "{'customerreference':?0}")
    Employee getByCustomerReference(String customerreference);

    @Query(value = "{'customernum':?0}")
    Employee getByCustomerNumber(int customernum);

    @Query(value = "{'customerId':?0}")
    Employee getByCustomerId(int customerId);

    @Query(value = "{'executiveName':?0}")
    List<Employee> getByExecutiveName(String executiveName);

    @Query(value = "{$and:[{'executiveCode':?0},{'isDisabled':{ $ne: 1}}, {'verificationStatus': 'Verified'}]}")
    List<Employee> getByExecutiveCodeAndActive(String executiveCode);

    @Query(value = "{'executiveCode':?0}")
    List<Employee> getByExecutiveCode(String executiveCode);

    @Query(value = "{$and:[{'isDisabled':{ $ne: 1}}, {'verificationStatus': 'Verified'}]}")
    List<Employee> getAllActiveCustomers();

    @Query(value = "{'executiveName':?0}", fields = "{'id':1, 'customerreference':1, 'customername':1}")
    List<Employee> getCustomerReferenceAndNameByExecutiveCode(String executiveName);
}
