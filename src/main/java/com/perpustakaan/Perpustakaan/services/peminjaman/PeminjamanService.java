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
import java.util.List;
import java.util.stream.Collectors;

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
        return peminjamanRepository.findAll()
                .stream().map(PeminjamanGridDto::set)
                .collect(Collectors.toList());
    }

    public List<PeminjamanGridDto> insertNewPeminjaman(PeminjamanInsertDto newPeminjaman) {
        Buku buku = bukuRepository.findById(newPeminjaman.getIdBuku()).get();
        Anggota anggota = anggotaRepository.findById(newPeminjaman.getIdAnggota()).get();
        Petugas petugas = petugasRepository.findById(newPeminjaman.getIdPetugas()).get();

        Peminjaman peminjaman = newPeminjaman.convert(buku, anggota, petugas);
        peminjamanRepository.save(peminjaman);
        return PeminjamanGridDto.toList(peminjamanRepository.findAll());
    }

    public List<PeminjamanDto> updatePeminjaman
            (PeminjamanUpdateDto updatePeminjaman, Integer idPeminjaman) {
        Peminjaman peminjaman = peminjamanRepository.findById(idPeminjaman)
                .orElseThrow(() -> new CustomException
                        (HttpStatus.NOT_FOUND, "Peminjaman dengan id " + idPeminjaman + " tidak ditemukan"));

        peminjaman.setTanggalKembali(updatePeminjaman.getTanggalKembali()
        == null ? LocalDate.parse(peminjaman.getTanggalKembali()) : updatePeminjaman.getTanggalKembali());

        peminjamanRepository.save(peminjaman);
        return PeminjamanDto.toList(peminjamanRepository.findAll());
    }

    public PeminjamanDto deletePeminjaman(Integer idPeminjaman) {
        Peminjaman peminjaman = peminjamanRepository.findById(idPeminjaman)
                .orElseThrow(()
                        -> new CustomException(HttpStatus.NOT_FOUND, "Peminjaman dengan id " + idPeminjaman + " tidak ditemukan"));

        peminjamanRepository.delete(peminjaman);
        return PeminjamanDto.setData(peminjaman);
    }

    public List<PeminjamanDto> findPeminjamanById(Integer idPeminjaman) {
        return PeminjamanDto.makeList(peminjamanRepository.getIdPeminjaman(idPeminjaman));
    }
}
