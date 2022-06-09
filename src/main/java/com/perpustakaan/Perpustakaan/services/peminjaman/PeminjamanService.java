package com.perpustakaan.Perpustakaan.services.peminjaman;

import com.perpustakaan.Perpustakaan.dtos.peminjaman.PeminjamanDto;
import com.perpustakaan.Perpustakaan.dtos.peminjaman.PeminjamanGridDto;
import com.perpustakaan.Perpustakaan.dtos.peminjaman.PeminjamanInsertDto;
import com.perpustakaan.Perpustakaan.models.Peminjaman;
import com.perpustakaan.Perpustakaan.repositories.PeminjamanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeminjamanService {

    @Autowired
    private PeminjamanRepository peminjamanRepository;

    public List<PeminjamanDto> findAllPeminjaman() {
        return PeminjamanDto.toList(peminjamanRepository.findAll());
    }

    public List<PeminjamanGridDto> savePeminjaman(PeminjamanInsertDto
                                                      newPeminjaman) {
        Peminjaman peminjaman = newPeminjaman.convert();
        peminjamanRepository.save(peminjaman);
        return PeminjamanGridDto.toList(peminjamanRepository.findAll());
    }
}
