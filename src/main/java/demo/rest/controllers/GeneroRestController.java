package demo.rest.controllers;

import demo.dto.mapper.IGeneroMapper;

import demo.modelo.*;

import demo.modelo.dto.GeneroDTO;

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
@RequestMapping("/genero")
public class GeneroRestController {
    private static final Logger log = LoggerFactory.getLogger(GeneroRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IGeneroMapper generoMapper;

    @PostMapping(value = "/saveGenero")
    public void saveGenero(@RequestBody
    GeneroDTO generoDTO) throws Exception {
        try {
            Genero genero = generoMapper.generoDTOToGenero(generoDTO);

            businessDelegatorView.saveGenero(genero);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteGenero/{idgenero}")
    public void deleteGenero(@PathVariable("idgenero")
    Integer idgenero) throws Exception {
        try {
            Genero genero = businessDelegatorView.getGenero(idgenero);

            businessDelegatorView.deleteGenero(genero);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateGenero/")
    public void updateGenero(@RequestBody
    GeneroDTO generoDTO) throws Exception {
        try {
            Genero genero = generoMapper.generoDTOToGenero(generoDTO);

            businessDelegatorView.updateGenero(genero);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataGenero")
    public List<GeneroDTO> getDataGenero() throws Exception {
        try {
            return businessDelegatorView.getDataGenero();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getGenero/{idgenero}")
    public GeneroDTO getGenero(@PathVariable("idgenero")
    Integer idgenero) throws Exception {
        try {
            Genero genero = businessDelegatorView.getGenero(idgenero);

            return generoMapper.generoToGeneroDTO(genero);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
