package demo.dto.mapper;

import demo.modelo.*;
import demo.modelo.Epoca;

import demo.modelo.control.*;

import demo.modelo.dto.EpocaDTO;

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
public class EpocaMapper implements IEpocaMapper {
    private static final Logger log = LoggerFactory.getLogger(EpocaMapper.class);

    @Transactional(readOnly = true)
    public EpocaDTO epocaToEpocaDTO(Epoca epoca) throws Exception {
        try {
            EpocaDTO epocaDTO = new EpocaDTO();

            epocaDTO.setIdepoca(epoca.getIdepoca());
            epocaDTO.setEpoca((epoca.getEpoca() != null) ? epoca.getEpoca() : null);
            epocaDTO.setTiempocompren((epoca.getTiempocompren() != null)
                ? epoca.getTiempocompren() : null);

            return epocaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Epoca epocaDTOToEpoca(EpocaDTO epocaDTO) throws Exception {
        try {
            Epoca epoca = new Epoca();

            epoca.setIdepoca(epocaDTO.getIdepoca());
            epoca.setEpoca((epocaDTO.getEpoca() != null) ? epocaDTO.getEpoca()
                                                         : null);
            epoca.setTiempocompren((epocaDTO.getTiempocompren() != null)
                ? epocaDTO.getTiempocompren() : null);

            return epoca;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<EpocaDTO> listEpocaToListEpocaDTO(List<Epoca> listEpoca)
        throws Exception {
        try {
            List<EpocaDTO> epocaDTOs = new ArrayList<EpocaDTO>();

            for (Epoca epoca : listEpoca) {
                EpocaDTO epocaDTO = epocaToEpocaDTO(epoca);

                epocaDTOs.add(epocaDTO);
            }

            return epocaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Epoca> listEpocaDTOToListEpoca(List<EpocaDTO> listEpocaDTO)
        throws Exception {
        try {
            List<Epoca> listEpoca = new ArrayList<Epoca>();

            for (EpocaDTO epocaDTO : listEpocaDTO) {
                Epoca epoca = epocaDTOToEpoca(epocaDTO);

                listEpoca.add(epoca);
            }

            return listEpoca;
        } catch (Exception e) {
            throw e;
        }
    }
}
