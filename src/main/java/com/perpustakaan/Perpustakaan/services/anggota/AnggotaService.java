package com.perpustakaan.Perpustakaan.services.anggota;

import com.perpustakaan.Perpustakaan.dtos.anggota.AnggotaDto;
import com.perpustakaan.Perpustakaan.dtos.anggota.AnggotaUpdateDto;
import com.perpustakaan.Perpustakaan.exceptions.CustomException;
import com.perpustakaan.Perpustakaan.models.Anggota;
import com.perpustakaan.Perpustakaan.repositories.AnggotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnggotaService {

    @Autowired
    private AnggotaRepository anggotaRepository;

    public List<AnggotaDto> findAllAnggota() {
        return anggotaRepository.findAll()
                .stream().map(AnggotaDto::setData)
                .collect(Collectors.toList());
    }

    public AnggotaDto insertAnggota(AnggotaDto newAnggota) {
        Anggota anggota = newAnggota.convert();
        anggotaRepository.save(anggota);
        return AnggotaDto.setData(anggota);
    }

    public AnggotaDto updateAnggota
            (AnggotaUpdateDto updateAnggota,Integer idAnggota) {
        Anggota anggota = anggotaRepository.findById(idAnggota)
                .orElseThrow(() -> new RuntimeException("Anggota tidak ditemukan"));

        anggota.setNamaAnggota(updateAnggota.getNamaAnggota()
        == null ? anggota.getNamaAnggota() : updateAnggota.getNamaAnggota());

        anggotaRepository.save(anggota);
        return AnggotaDto.setData(anggota);
    }

    public AnggotaDto deleteAnggotaById(Integer idAnggota) {
        Anggota anggota = anggotaRepository.findById(idAnggota)
                .orElseThrow(()
                        -> new CustomException(HttpStatus.NOT_FOUND, "Anggota Tidak Ditemukan"));

        anggotaRepository.delete(anggota);
        return AnggotaDto.setData(anggota);
    }

    public List<AnggotaDto> findAllAnggotaById(Integer idAnggota) {
        return AnggotaDto.makeList(anggotaRepository.getIdAnggota(idAnggota));
    }


}
