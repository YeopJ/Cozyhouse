package com.baeksoo.shop.sales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalesRepository extends JpaRepository<Sales, Long> {

    //JPQL로 직접 조인
    @Query(value = "SELECT s FROM Sales s JOIN FETCH s.member")
    List<Sales> customFindAll();

}
