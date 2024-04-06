package com.adso.norus.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.adso.norus.models.Aprendiz;

@Service
public interface AprendizService {
    public List<Aprendiz> findAll();

    public Aprendiz save(Aprendiz aprendiz);

    public Aprendiz findById(Long id);

    public void delete(Aprendiz aprendiz);
    public void deleteById(Long id);
}
