package com.solucionexpress.microservicios.commons.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.solucionexpress.microservicios.commons.services.CommonService;

import java.util.Optional;


public class CommonController<E,S extends CommonService<E>> {
    @Autowired
    protected S service;

    @GetMapping()
    public ResponseEntity<?> index (){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver (@PathVariable Long id){
        Optional<E> alumno = service.findById(id);

        if( alumno.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok( alumno.get());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody E entity){
        E entityDb = service.save( entity );

        return ResponseEntity.status(HttpStatus.CREATED).body( entityDb );
    }



    @DeleteMapping("/{id}")
    public ResponseEntity <?> eliminar(@PathVariable Long id ){
         service.deleteById(id);
         return ResponseEntity.noContent().build();
    }
}
