package com.andyn.repository;

import com.andyn.model.Maintenance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository  extends CrudRepository<Maintenance, Integer> {
}
