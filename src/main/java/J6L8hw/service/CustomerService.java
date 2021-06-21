package J6L8hw.service;

import J6L8hw.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(int id);

}
