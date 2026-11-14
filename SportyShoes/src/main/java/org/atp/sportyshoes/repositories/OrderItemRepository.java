package org.atp.sportyshoes.repositories;

import org.atp.sportyshoes.entities.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItems, Integer> {
}
