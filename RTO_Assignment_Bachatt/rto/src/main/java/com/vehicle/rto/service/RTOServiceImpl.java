package com.vehicle.rto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.rto.entity.RTO;
import com.vehicle.rto.exception.VehicleNotFoundException;
import com.vehicle.rto.repository.RTORepository;

@Service
public class RTOServiceImpl implements RTOService {

	@Autowired
	private RTORepository vehicleRepository;

	@Override
	public RTO addVehicle(RTO vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public List<RTO> getAllVehicles() {
		return vehicleRepository.findAll();
	}

	@Override
	public RTO getVehicleById(Long id) {
		return vehicleRepository.findById(id)
				.orElseThrow(() -> new VehicleNotFoundException("Vehicle not found with id: " + id));
	}

	@Override
	public RTO updateVehicle(Long id, RTO vehicle) {
		RTO existing = getVehicleById(id);

		if (vehicle.getName() != null) {
			existing.setName(vehicle.getName());
		}
		if (vehicle.getFuelType() != null) {
			existing.setFuelType(vehicle.getFuelType());
		}
		if (vehicle.getRegistrationNo() != null) {
			existing.setRegistrationNo(vehicle.getRegistrationNo());
		}
		if (vehicle.getOwnerName() != null) {
			existing.setOwnerName(vehicle.getOwnerName());
		}
		if (vehicle.getOwnerAddress() != null) {
			existing.setOwnerAddress(vehicle.getOwnerAddress());
		}
		if (vehicle.getCity() != null) {
			existing.setCity(vehicle.getCity());
		}
		if (vehicle.getState() != null) {
			existing.setState(vehicle.getState());
		}

		return vehicleRepository.save(existing);
	}

	@Override
	public void deleteVehicle(Long id) {
		RTO vehicle = getVehicleById(id);
		vehicleRepository.delete(vehicle);
	}

	@Override
	public List<RTO> searchByFuel(String fuel) {
		return vehicleRepository.findByFuelType(fuel);
	}

	@Override
	public List<RTO> searchByCity(String city) {
		return vehicleRepository.findByCity(city);
	}

	@Override
	public List<RTO> searchByState(String state) {
		return vehicleRepository.findByState(state);
	}
}
