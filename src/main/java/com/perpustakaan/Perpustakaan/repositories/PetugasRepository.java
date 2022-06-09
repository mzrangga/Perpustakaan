package com.perpustakaan.Perpustakaan.repositories;

import com.perpustakaan.Perpustakaan.models.Petugas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetugasRepository extends JpaRepository<Petugas, Integer> {
    @Query(value = """
            SELECT * FROM Petugas WHERE id_Petugas = :id
            """, nativeQuery = true)
    List<Petugas> getIdPetugas(@Param("id") Integer id);
}