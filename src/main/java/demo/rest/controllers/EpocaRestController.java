package demo.rest.controllers;

import demo.dto.mapper.IEpocaMapper;

import demo.modelo.*;

import demo.modelo.dto.EpocaDTO;

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
@RequestMapping("/epoca")
public class EpocaRestController {
    private static final Logger log = LoggerFactory.getLogger(EpocaRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IEpocaMapper epocaMapper;

    @PostMapping(value = "/saveEpoca")
    public void saveEpoca(@RequestBody
    EpocaDTO epocaDTO) throws Exception {
        try {
            Epoca epoca = epocaMapper.epocaDTOToEpoca(epocaDTO);

            businessDelegatorView.saveEpoca(epoca);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteEpoca/{idepoca}")
    public void deleteEpoca(@PathVariable("idepoca")
    Integer idepoca) throws Exception {
        try {
            Epoca epoca = businessDelegatorView.getEpoca(idepoca);

            businessDelegatorView.deleteEpoca(epoca);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateEpoca/")
    public void updateEpoca(@RequestBody
    EpocaDTO epocaDTO) throws Exception {
        try {
            Epoca epoca = epocaMapper.epocaDTOToEpoca(epocaDTO);

            businessDelegatorView.updateEpoca(epoca);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataEpoca")
    public List<EpocaDTO> getDataEpoca() throws Exception {
        try {
            return businessDelegatorView.getDataEpoca();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getEpoca/{idepoca}")
    public EpocaDTO getEpoca(@PathVariable("idepoca")
    Integer idepoca) throws Exception {
        try {
            Epoca epoca = businessDelegatorView.getEpoca(idepoca);

            return epocaMapper.epocaToEpocaDTO(epoca);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
