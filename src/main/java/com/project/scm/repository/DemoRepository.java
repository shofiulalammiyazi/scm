package com.project.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.scm.model.DemoModel;

@Repository
public interface DemoRepository extends JpaRepository<DemoModel, Long> {

}
