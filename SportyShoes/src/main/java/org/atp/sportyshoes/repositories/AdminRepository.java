package org.atp.sportyshoes.repositories;

import org.atp.sportyshoes.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {

    public Admin findByUsername(String username);
}
