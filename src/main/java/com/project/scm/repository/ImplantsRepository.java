package com.project.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.scm.model.ImplantsModel;

@Repository
public interface ImplantsRepository extends JpaRepository<ImplantsModel, Long> {

}
