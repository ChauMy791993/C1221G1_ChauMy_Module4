package com.codegym.repository;

import com.codegym.dto.ICustomerUseService;
import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerType_CustomerTypeId
            (String customerName, String customerAddress, Integer customerTypeId, Pageable pageable);

    Page<Customer> findAllByCustomerNameContainingAndCustomerAddressContaining
            (String customerName, String customerAddress, Pageable pageable);

    @Query(value ="select c.customer_name customerName,\n" +
            "       f.facility_name facilityName,\n" +
            "       c2.contract_start_date startDay,\n" +
            "       c2.contract_end_date endDay,\n" +
            "       GROUP_CONCAT(a.attach_service_name) attachService,\n" +
            "        SUM(coalesce(cd.quantity * a.attach_service_cost,0))+ f.facility_cost total\n" +
            "       from customer c\n" +
            "inner join contract c2 on c.customer_id = c2.customer_id\n" +
            "inner join facility f on c2.facility_id = f.facility_id\n" +
            "left join contract_detail cd on c2.contract_id = cd.contract_id\n" +
            "left join attach_service a on cd.attach_service_id = a.attach_service_id\n" +
            "group by c2.contract_id",
            countQuery = "select c.customer_name customerName,\n" +
                    "       f.facility_name facilityName,\n" +
                    "       c2.contract_start_date startDay,\n" +
                    "       c2.contract_end_date endDay,\n" +
                    "       GROUP_CONCAT(a.attach_service_name) attachService,\n" +
                    "        SUM(coalesce(cd.quantity * a.attach_service_cost,0))+ f.facility_cost total\n" +
                    "       from customer c\n" +
                    "inner join contract c2 on c.customer_id = c2.customer_id\n" +
                    "inner join facility f on c2.facility_id = f.facility_id\n" +
                    "left join contract_detail cd on c2.contract_id = cd.contract_id\n" +
                    "left join attach_service a on cd.attach_service_id = a.attach_service_id\n" +
                    "group by c2.contract_id",nativeQuery = true)
    Page<ICustomerUseService> findAllCustomerHaveBooking(Pageable pageable);
}
