package com.adso.norus.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.adso.norus.models.Aprendiz;

@Repository
public interface AprendizRepository extends JpaRepository<Aprendiz, Long> {
}