package com.entjava.furryfriends.repository;

import com.entjava.furryfriends.model.Ferret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FerretRepository extends JpaRepository<Ferret, Long>
{

}
