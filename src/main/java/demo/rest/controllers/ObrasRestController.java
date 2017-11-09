package demo.rest.controllers;

import demo.dto.mapper.IObrasMapper;

import demo.modelo.*;

import demo.modelo.dto.ObrasDTO;

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
@RequestMapping("/obras")
public class ObrasRestController {
    private static final Logger log = LoggerFactory.getLogger(ObrasRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IObrasMapper obrasMapper;

    @PostMapping(value = "/saveObras")
    public void saveObras(@RequestBody
    ObrasDTO obrasDTO) throws Exception {
        try {
            Obras obras = obrasMapper.obrasDTOToObras(obrasDTO);

            businessDelegatorView.saveObras(obras);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteObras/{idobra}")
    public void deleteObras(@PathVariable("idobra")
    Integer idobra) throws Exception {
        try {
            Obras obras = businessDelegatorView.getObras(idobra);

            businessDelegatorView.deleteObras(obras);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateObras/")
    public void updateObras(@RequestBody
    ObrasDTO obrasDTO) throws Exception {
        try {
            Obras obras = obrasMapper.obrasDTOToObras(obrasDTO);

            businessDelegatorView.updateObras(obras);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataObras")
    public List<ObrasDTO> getDataObras() throws Exception {
        try {
            return businessDelegatorView.getDataObras();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getObras/{idobra}")
    public ObrasDTO getObras(@PathVariable("idobra")
    Integer idobra) throws Exception {
        try {
            Obras obras = businessDelegatorView.getObras(idobra);

            return obrasMapper.obrasToObrasDTO(obras);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
