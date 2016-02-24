package com.amaresh.examples.stg;

import java.util.List;

import com.amaresh.examples.person.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrderStgRepository extends PagingAndSortingRepository<OrderStg, String> {

    List<OrderStg> findByOrderNo(@Param("orderNo") String orderNo);

}