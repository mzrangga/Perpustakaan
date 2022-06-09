package com.perpustakaan.Perpustakaan.repositories;

import com.perpustakaan.Perpustakaan.models.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BukuRepository extends JpaRepository<Buku, Integer> {
    @Query(value = """
            SELECT *
            FROM Buku
            WHERE id_Buku = :id
            """, nativeQuery = true)
    List<Buku> findById(@Param("id") int id);
}