package com.project.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.scm.model.DoctorNameModel;
@Repository
public interface DoctorNameRepository extends JpaRepository<DoctorNameModel, Long> {

}
