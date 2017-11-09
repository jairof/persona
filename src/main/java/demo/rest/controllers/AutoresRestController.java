package demo.rest.controllers;

import demo.dto.mapper.IAutoresMapper;

import demo.modelo.*;

import demo.modelo.dto.AutoresDTO;

import demo.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/autores")
public class AutoresRestController {
    private static final Logger log = LoggerFactory.getLogger(AutoresRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IAutoresMapper autoresMapper;

    @PostMapping(value = "/saveAutores")
    public void saveAutores(@RequestBody
    AutoresDTO autoresDTO) throws Exception {
        try {
            Autores autores = autoresMapper.autoresDTOToAutores(autoresDTO);

            businessDelegatorView.saveAutores(autores);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteAutores/{idautor}")
    public void deleteAutores(@PathVariable("idautor")
    Integer idautor) throws Exception {
        try {
            Autores autores = businessDelegatorView.getAutores(idautor);

            businessDelegatorView.deleteAutores(autores);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateAutores/")
    public void updateAutores(@RequestBody
    AutoresDTO autoresDTO) throws Exception {
        try {
            Autores autores = autoresMapper.autoresDTOToAutores(autoresDTO);

            businessDelegatorView.updateAutores(autores);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataAutores")
    public List<AutoresDTO> getDataAutores() throws Exception {
        try {
            return businessDelegatorView.getDataAutores();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getAutores/{idautor}")
    public AutoresDTO getAutores(@PathVariable("idautor")
    Integer idautor) throws Exception {
        try {
            Autores autores = businessDelegatorView.getAutores(idautor);

            return autoresMapper.autoresToAutoresDTO(autores);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
