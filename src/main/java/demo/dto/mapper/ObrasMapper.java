package demo.dto.mapper;

import demo.modelo.*;
import demo.modelo.Obras;

import demo.modelo.control.*;

import demo.modelo.dto.ObrasDTO;

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
public class ObrasMapper implements IObrasMapper {
    private static final Logger log = LoggerFactory.getLogger(ObrasMapper.class);

    /**
    * Logic injected by Spring that manages Autores entities
    *
    */
    @Autowired
    IAutoresLogic logicAutores1;

    /**
    * Logic injected by Spring that manages Epoca entities
    *
    */
    @Autowired
    IEpocaLogic logicEpoca2;

    /**
    * Logic injected by Spring that manages Genero entities
    *
    */
    @Autowired
    IGeneroLogic logicGenero3;

    @Transactional(readOnly = true)
    public ObrasDTO obrasToObrasDTO(Obras obras) throws Exception {
        try {
            ObrasDTO obrasDTO = new ObrasDTO();

            obrasDTO.setIdobra(obras.getIdobra());
            obrasDTO.setAno((obras.getAno() != null) ? obras.getAno() : null);
            obrasDTO.setArgumento((obras.getArgumento() != null)
                ? obras.getArgumento() : null);
            obrasDTO.setCritica((obras.getCritica() != null)
                ? obras.getCritica() : null);
            obrasDTO.setTitulo((obras.getTitulo() != null) ? obras.getTitulo()
                                                           : null);
            obrasDTO.setIdautor_Autores((obras.getAutores().getIdautor() != null)
                ? obras.getAutores().getIdautor() : null);
            obrasDTO.setIdepoca_Epoca((obras.getEpoca().getIdepoca() != null)
                ? obras.getEpoca().getIdepoca() : null);
            obrasDTO.setIdgenero_Genero((obras.getGenero().getIdgenero() != null)
                ? obras.getGenero().getIdgenero() : null);

            return obrasDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Obras obrasDTOToObras(ObrasDTO obrasDTO) throws Exception {
        try {
            Obras obras = new Obras();

            obras.setIdobra(obrasDTO.getIdobra());
            obras.setAno((obrasDTO.getAno() != null) ? obrasDTO.getAno() : null);
            obras.setArgumento((obrasDTO.getArgumento() != null)
                ? obrasDTO.getArgumento() : null);
            obras.setCritica((obrasDTO.getCritica() != null)
                ? obrasDTO.getCritica() : null);
            obras.setTitulo((obrasDTO.getTitulo() != null)
                ? obrasDTO.getTitulo() : null);

            Autores autores = new Autores();

            if (obrasDTO.getIdautor_Autores() != null) {
                autores = logicAutores1.getAutores(obrasDTO.getIdautor_Autores());
            }

            if (autores != null) {
                obras.setAutores(autores);
            }

            Epoca epoca = new Epoca();

            if (obrasDTO.getIdepoca_Epoca() != null) {
                epoca = logicEpoca2.getEpoca(obrasDTO.getIdepoca_Epoca());
            }

            if (epoca != null) {
                obras.setEpoca(epoca);
            }

            Genero genero = new Genero();

            if (obrasDTO.getIdgenero_Genero() != null) {
                genero = logicGenero3.getGenero(obrasDTO.getIdgenero_Genero());
            }

            if (genero != null) {
                obras.setGenero(genero);
            }

            return obras;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ObrasDTO> listObrasToListObrasDTO(List<Obras> listObras)
        throws Exception {
        try {
            List<ObrasDTO> obrasDTOs = new ArrayList<ObrasDTO>();

            for (Obras obras : listObras) {
                ObrasDTO obrasDTO = obrasToObrasDTO(obras);

                obrasDTOs.add(obrasDTO);
            }

            return obrasDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Obras> listObrasDTOToListObras(List<ObrasDTO> listObrasDTO)
        throws Exception {
        try {
            List<Obras> listObras = new ArrayList<Obras>();

            for (ObrasDTO obrasDTO : listObrasDTO) {
                Obras obras = obrasDTOToObras(obrasDTO);

                listObras.add(obras);
            }

            return listObras;
        } catch (Exception e) {
            throw e;
        }
    }
}
