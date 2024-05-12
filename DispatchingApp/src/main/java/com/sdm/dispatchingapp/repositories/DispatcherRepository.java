package com.sdm.dispatchingapp.repositories;

import com.sdm.dispatchingapp.domain.Dispatcher;
import org.springframework.data.repository.CrudRepository;

public interface DispatcherRepository extends CrudRepository<Dispatcher, Long> {
}
