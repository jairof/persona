package demo.dto.mapper;

import demo.modelo.*;
import demo.modelo.Autores;

import demo.modelo.control.*;

import demo.modelo.dto.AutoresDTO;

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
public class AutoresMapper implements IAutoresMapper {
    private static final Logger log = LoggerFactory.getLogger(AutoresMapper.class);

    /**
    * Logic injected by Spring that manages Epoca entities
    *
    */
    @Autowired
    IEpocaLogic logicEpoca1;

    @Transactional(readOnly = true)
    public AutoresDTO autoresToAutoresDTO(Autores autores)
        throws Exception {
        try {
            AutoresDTO autoresDTO = new AutoresDTO();

            autoresDTO.setIdautor(autores.getIdautor());
            autoresDTO.setAnofallecimiento((autores.getAnofallecimiento() != null)
                ? autores.getAnofallecimiento() : null);
            autoresDTO.setAnonacimiento((autores.getAnonacimiento() != null)
                ? autores.getAnonacimiento() : null);
            autoresDTO.setAutor((autores.getAutor() != null)
                ? autores.getAutor() : null);
            autoresDTO.setEstilo((autores.getEstilo() != null)
                ? autores.getEstilo() : null);
            autoresDTO.setLugarnaci((autores.getLugarnaci() != null)
                ? autores.getLugarnaci() : null);
            autoresDTO.setVida((autores.getVida() != null) ? autores.getVida()
                                                           : null);
            autoresDTO.setIdepoca_Epoca((autores.getEpoca().getIdepoca() != null)
                ? autores.getEpoca().getIdepoca() : null);

            return autoresDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Autores autoresDTOToAutores(AutoresDTO autoresDTO)
        throws Exception {
        try {
            Autores autores = new Autores();

            autores.setIdautor(autoresDTO.getIdautor());
            autores.setAnofallecimiento((autoresDTO.getAnofallecimiento() != null)
                ? autoresDTO.getAnofallecimiento() : null);
            autores.setAnonacimiento((autoresDTO.getAnonacimiento() != null)
                ? autoresDTO.getAnonacimiento() : null);
            autores.setAutor((autoresDTO.getAutor() != null)
                ? autoresDTO.getAutor() : null);
            autores.setEstilo((autoresDTO.getEstilo() != null)
                ? autoresDTO.getEstilo() : null);
            autores.setLugarnaci((autoresDTO.getLugarnaci() != null)
                ? autoresDTO.getLugarnaci() : null);
            autores.setVida((autoresDTO.getVida() != null)
                ? autoresDTO.getVida() : null);

            Epoca epoca = new Epoca();

            if (autoresDTO.getIdepoca_Epoca() != null) {
                epoca = logicEpoca1.getEpoca(autoresDTO.getIdepoca_Epoca());
            }

            if (epoca != null) {
                autores.setEpoca(epoca);
            }

            return autores;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<AutoresDTO> listAutoresToListAutoresDTO(
        List<Autores> listAutores) throws Exception {
        try {
            List<AutoresDTO> autoresDTOs = new ArrayList<AutoresDTO>();

            for (Autores autores : listAutores) {
                AutoresDTO autoresDTO = autoresToAutoresDTO(autores);

                autoresDTOs.add(autoresDTO);
            }

            return autoresDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Autores> listAutoresDTOToListAutores(
        List<AutoresDTO> listAutoresDTO) throws Exception {
        try {
            List<Autores> listAutores = new ArrayList<Autores>();

            for (AutoresDTO autoresDTO : listAutoresDTO) {
                Autores autores = autoresDTOToAutores(autoresDTO);

                listAutores.add(autores);
            }

            return listAutores;
        } catch (Exception e) {
            throw e;
        }
    }
}
