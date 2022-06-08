package com.perpustakaan.Perpustakaan.repositories;

import com.perpustakaan.Perpustakaan.models.Buku;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BukuRepository extends JpaRepository<Buku, Integer> {
}