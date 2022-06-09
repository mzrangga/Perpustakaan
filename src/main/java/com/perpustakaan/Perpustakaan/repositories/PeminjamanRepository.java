package com.perpustakaan.Perpustakaan.repositories;

import com.perpustakaan.Perpustakaan.models.Peminjaman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeminjamanRepository extends JpaRepository<Peminjaman, Integer> {
}