package com.vehicle.rto.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicle.rto.entity.RTO;

public interface RTORepository extends JpaRepository<RTO, Long> {
	List<RTO> findByFuelType(String fuelType);

	List<RTO> findByCity(String city);

	List<RTO> findByState(String state);
}
