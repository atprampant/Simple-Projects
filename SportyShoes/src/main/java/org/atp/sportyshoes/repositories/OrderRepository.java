package org.atp.sportyshoes.repositories;

import org.atp.sportyshoes.entities.Orders;
import org.atp.sportyshoes.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    public Orders findByUser(Users user);

    public Orders findAllByLocalDate(LocalDate inputDate);
}
