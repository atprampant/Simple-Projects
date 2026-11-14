package org.atp.sportyshoes.repositories;

import org.atp.sportyshoes.entities.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoeRepository extends JpaRepository<Shoes, Long> {

}
