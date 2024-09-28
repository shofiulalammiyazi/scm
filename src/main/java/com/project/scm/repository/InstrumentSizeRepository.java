package com.project.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.scm.model.InstrumentSizeModel;

@Repository
public interface InstrumentSizeRepository extends JpaRepository<InstrumentSizeModel, Long>  {

}
