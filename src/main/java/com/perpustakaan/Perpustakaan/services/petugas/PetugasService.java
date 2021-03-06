package com.perpustakaan.Perpustakaan.services.petugas;

import com.perpustakaan.Perpustakaan.dtos.petugas.PetugasDto;
import com.perpustakaan.Perpustakaan.dtos.petugas.PetugasUpdateDto;
import com.perpustakaan.Perpustakaan.exceptions.CustomException;
import com.perpustakaan.Perpustakaan.models.Petugas;
import com.perpustakaan.Perpustakaan.repositories.PetugasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetugasService {

    @Autowired
    private PetugasRepository petugasRepository;

    public List<PetugasDto> findAllPetugas() {
        return petugasRepository.findAll()
                .stream().map(PetugasDto::setData)
                .collect(Collectors.toList());
    }

    public PetugasDto insertPetugas(PetugasDto newPetugas) {
        Petugas petugas = newPetugas.convert();
        petugasRepository.save(petugas);
        return PetugasDto.setData(petugas);
    }

    public PetugasDto updatePetugas(
        PetugasUpdateDto updatePetugas,Integer idPetugas) {
    Petugas petugas = petugasRepository.findById(idPetugas)
            .orElseThrow(() -> new CustomException
                    (HttpStatus.NOT_FOUND, "Petugas dengan id " + idPetugas + " tidak ditemukan"));

    petugas.setNamaPetugas(updatePetugas.getNamaPetugas()
            == null ? petugas.getNamaPetugas() : updatePetugas.getNamaPetugas());

    petugas.setJabatanPetugas(updatePetugas.getJabatanPetugas()
            == null ? petugas.getJabatanPetugas() : updatePetugas.getJabatanPetugas());

    petugasRepository.save(petugas);
    return PetugasDto.setData(petugas);
}

    public PetugasDto delete (Integer idPetugas) {
        Petugas petugas = petugasRepository.findById(idPetugas)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Petugas dengan id " + idPetugas + " tidak ditemukan"));

        petugasRepository.deleteById(idPetugas);
        return PetugasDto.setData(petugas);
    }

    public List<PetugasDto> findAllPetugasById(Integer idPetugas){
        return PetugasDto.makeList(petugasRepository.getIdPetugas(idPetugas));
    }
}
