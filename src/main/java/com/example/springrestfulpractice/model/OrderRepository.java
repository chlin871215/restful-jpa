package com.example.springrestfulpractice.model;

import com.example.springrestfulpractice.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findBySeq(int seq);
    @Modifying
    @Query(value = "DELETE FROM orders WHERE seq = :seq", nativeQuery = true)
    @Transactional
    void deleteOrderBySeq(@Param("seq") int seq);

    @Modifying
    @Query(value = "DELETE FROM order_meal WHERE order_seq = :seq", nativeQuery = true)
    @Transactional
    void deleteOrderMealBySeq(@Param("seq") int seq);

}
