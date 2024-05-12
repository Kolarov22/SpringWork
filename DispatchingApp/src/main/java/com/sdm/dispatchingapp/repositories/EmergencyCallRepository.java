package com.sdm.dispatchingapp.repositories;

import com.sdm.dispatchingapp.domain.EmergencyCall;
import org.springframework.data.repository.CrudRepository;

public interface EmergencyCallRepository extends CrudRepository<EmergencyCall, Long> {
}
