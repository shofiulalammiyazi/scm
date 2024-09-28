package com.project.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.scm.model.InstrumentsModel;

@Repository
public interface InstrumentsRepository extends JpaRepository<InstrumentsModel, Long> {

}
