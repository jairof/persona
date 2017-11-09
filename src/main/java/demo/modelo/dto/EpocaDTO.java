package demo.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class EpocaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(EpocaDTO.class);
    private String epoca;
    private Integer idepoca;
    private String tiempocompren;

    public String getEpoca() {
        return epoca;
    }

    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

    public Integer getIdepoca() {
        return idepoca;
    }

    public void setIdepoca(Integer idepoca) {
        this.idepoca = idepoca;
    }

    public String getTiempocompren() {
        return tiempocompren;
    }

    public void setTiempocompren(String tiempocompren) {
        this.tiempocompren = tiempocompren;
    }
}
