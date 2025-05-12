package com.vehicle.rto.service;

import java.util.List;

import com.vehicle.rto.entity.RTO;

public interface RTOService {
	RTO addVehicle(RTO vehicle);

	List<RTO> getAllVehicles();

	RTO getVehicleById(Long id);

	RTO updateVehicle(Long id, RTO vehicle);

	void deleteVehicle(Long id);

	List<RTO> searchByFuel(String fuel);

	List<RTO> searchByCity(String city);

	List<RTO> searchByState(String state);
}
