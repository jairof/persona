package demo.dto.mapper;

import demo.modelo.*;
import demo.modelo.Genero;

import demo.modelo.control.*;

import demo.modelo.dto.GeneroDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class GeneroMapper implements IGeneroMapper {
    private static final Logger log = LoggerFactory.getLogger(GeneroMapper.class);

    @Transactional(readOnly = true)
    public GeneroDTO generoToGeneroDTO(Genero genero) throws Exception {
        try {
            GeneroDTO generoDTO = new GeneroDTO();

            generoDTO.setIdgenero(genero.getIdgenero());
            generoDTO.setGenero((genero.getGenero() != null)
                ? genero.getGenero() : null);

            return generoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Genero generoDTOToGenero(GeneroDTO generoDTO)
        throws Exception {
        try {
            Genero genero = new Genero();

            genero.setIdgenero(generoDTO.getIdgenero());
            genero.setGenero((generoDTO.getGenero() != null)
                ? generoDTO.getGenero() : null);

            return genero;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GeneroDTO> listGeneroToListGeneroDTO(List<Genero> listGenero)
        throws Exception {
        try {
            List<GeneroDTO> generoDTOs = new ArrayList<GeneroDTO>();

            for (Genero genero : listGenero) {
                GeneroDTO generoDTO = generoToGeneroDTO(genero);

                generoDTOs.add(generoDTO);
            }

            return generoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Genero> listGeneroDTOToListGenero(List<GeneroDTO> listGeneroDTO)
        throws Exception {
        try {
            List<Genero> listGenero = new ArrayList<Genero>();

            for (GeneroDTO generoDTO : listGeneroDTO) {
                Genero genero = generoDTOToGenero(generoDTO);

                listGenero.add(genero);
            }

            return listGenero;
        } catch (Exception e) {
            throw e;
        }
    }
}
