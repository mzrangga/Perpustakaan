package com.perpustakaan.Perpustakaan.repositories;

import com.perpustakaan.Perpustakaan.models.Peminjaman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeminjamanRepository extends JpaRepository<Peminjaman, Integer> {
    @Query(value = """
            SELECT * FROM Peminjaman WHERE id_Peminjaman = :id
            """, nativeQuery = true)
    List<Peminjaman> getIdPeminjaman(@Param("id") Integer id);
}