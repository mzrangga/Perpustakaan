package com.perpustakaan.Perpustakaan.repositories;

import com.perpustakaan.Perpustakaan.models.Anggota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnggotaRepository extends JpaRepository<Anggota, Integer> {
    @Query(value = """
            SELECT * FROM Anggota WHERE Id_Anggota = :id
            """, nativeQuery = true)
    List<Anggota> getIdAnggota(@Param("id") Integer id);
}