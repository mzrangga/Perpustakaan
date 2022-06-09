package com.perpustakaan.Perpustakaan.services.peminjaman;

import com.perpustakaan.Perpustakaan.dtos.peminjaman.PeminjamanDto;
import com.perpustakaan.Perpustakaan.dtos.peminjaman.PeminjamanGridDto;
import com.perpustakaan.Perpustakaan.dtos.peminjaman.PeminjamanInsertDto;
import com.perpustakaan.Perpustakaan.dtos.peminjaman.PeminjamanUpdateDto;
import com.perpustakaan.Perpustakaan.exceptions.CustomException;
import com.perpustakaan.Perpustakaan.models.Anggota;
import com.perpustakaan.Perpustakaan.models.Buku;
import com.perpustakaan.Perpustakaan.models.Peminjaman;
import com.perpustakaan.Perpustakaan.models.Petugas;
import com.perpustakaan.Perpustakaan.repositories.AnggotaRepository;
import com.perpustakaan.Perpustakaan.repositories.BukuRepository;
import com.perpustakaan.Perpustakaan.repositories.PeminjamanRepository;
import com.perpustakaan.Perpustakaan.repositories.PetugasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PeminjamanService {

    @Autowired
    private PeminjamanRepository peminjamanRepository;
    @Autowired
    private BukuRepository bukuRepository;
    @Autowired
    private AnggotaRepository anggotaRepository;
    @Autowired
    private PetugasRepository petugasRepository;

    public List<PeminjamanGridDto> findAllPeminjaman() {
        return PeminjamanGridDto.toList(peminjamanRepository.findAll());
    }

    public List<PeminjamanGridDto> insertNewPeminjaman(PeminjamanInsertDto newPeminjaman) {
        Buku buku = bukuRepository.findById(newPeminjaman.getIdBuku()).get();
        Anggota anggota = anggotaRepository.findById(newPeminjaman.getIdAnggota()).get();
        Petugas petugas = petugasRepository.findById(newPeminjaman.getIdPetugas()).get();

        Peminjaman peminjaman = newPeminjaman.convert(buku, anggota, petugas);
        peminjamanRepository.save(peminjaman);
        return PeminjamanGridDto.toList(peminjamanRepository.findAll());
    }

    public List<PeminjamanGridDto> updatePeminjaman(PeminjamanDto peminjaman) {
        Peminjaman peminjaman1 = peminjaman.convert();
        peminjamanRepository.save(peminjaman1);
        return PeminjamanGridDto.toList(peminjamanRepository.findAll());
    }

    public PeminjamanDto deletePeminjaman(Integer idPeminjaman) {
        Peminjaman peminjaman = peminjamanRepository.findById(idPeminjaman)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Peminjaman dengan id " + idPeminjaman + " tidak ditemukan"));
        peminjamanRepository.delete(peminjaman);
        return PeminjamanDto.setData(peminjaman);
    }
}
