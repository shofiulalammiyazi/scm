package com.project.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.scm.model.HospitalNameModel;

@Repository
public interface HospitalNameRepository extends JpaRepository<HospitalNameModel, Long> {

}
