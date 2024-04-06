package com.adso.norus.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adso.norus.models.Aprendiz;
import com.adso.norus.interfaces.AprendizRepository;

@Service
public class AprendizServiceImplement implements AprendizService {
    @Autowired
    private final AprendizRepository AprendicesRepository;

    public AprendizServiceImplement(AprendizRepository AprendicesRepository) {
        this.AprendicesRepository = AprendicesRepository;
    }

    public List<Aprendiz> findAll() {
        return (List<Aprendiz>) AprendicesRepository.findAll();
    }

    public Aprendiz save(Aprendiz aprendiz) {
        return AprendicesRepository.save(aprendiz);
    }

    public Aprendiz findById(Long id) {
        return AprendicesRepository.findById(id).orElse(null);
    }

    public void delete(Aprendiz aprendiz) {
        AprendicesRepository.delete(aprendiz);
    }

    public void deleteById(Long id) {
        AprendicesRepository.deleteById(id);
    }
}
