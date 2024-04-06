package com.adso.norus.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RestController;
import com.adso.norus.models.Aprendiz;
import com.adso.norus.services.AprendizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/norus")
public class AprendizController {
    private final AprendizService AprendizService;

    public AprendizController(AprendizService AprendizService) {
        this.AprendizService = AprendizService;
    }

    @GetMapping(value = "/aprendices")
    public ResponseEntity<Object> get() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Aprendiz> list = AprendizService.findAll();
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/aprendices/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        try {
            Aprendiz data = AprendizService.findById(id);
            return new ResponseEntity<Object>(data, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/aprendices")
    public ResponseEntity<Object> create(@RequestBody Aprendiz aprendiz) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Aprendiz res = AprendizService.save(aprendiz);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/aprendices/{id}")
    public ResponseEntity<Object> update(@RequestBody Aprendiz aprendiz, @PathVariable Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Aprendiz existingAprendiz = AprendizService.findById(id);
            existingAprendiz.setEst(aprendiz.getEst());
            existingAprendiz.setNota(aprendiz.getNota());
            existingAprendiz.setestado(aprendiz.getEstado());
            Aprendiz res = AprendizService.save(aprendiz);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/aprendices/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Aprendiz existingaAprendiz = AprendizService.findById(id);
            AprendizService.delete(existingaAprendiz);
            map.put("deleted", true);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
