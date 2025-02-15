package com.example.technical_assessment.repository;

import com.example.technical_assessment.model.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanRepository extends JpaRepository<Karyawan, Integer> {
}