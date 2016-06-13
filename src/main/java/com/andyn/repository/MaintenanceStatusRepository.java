package com.andyn.repository;

import com.andyn.model.MaintenanceStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceStatusRepository extends CrudRepository<MaintenanceStatus, Integer> {
}
