package com.andyn.repository;

import com.andyn.model.MaintenanceType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceTypeRepository extends CrudRepository<MaintenanceType, Integer> {
}
