package demo.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "epoca", schema = "${schema}")
public class Epoca implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idepoca;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String epoca;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String tiempocompren;
    private Set<Autores> autoreses = new HashSet<Autores>(0);
    private Set<Obras> obrases = new HashSet<Obras>(0);

    public Epoca() {
    }

    public Epoca(Integer idepoca, Set<Autores> autoreses, String epoca,
        Set<Obras> obrases, String tiempocompren) {
        this.idepoca = idepoca;
        this.epoca = epoca;
        this.tiempocompren = tiempocompren;
        this.autoreses = autoreses;
        this.obrases = obrases;
    }

    public Integer getIdepoca() {
        return this.idepoca;
    }

    public void setIdepoca(Integer idepoca) {
        this.idepoca = idepoca;
    }

    public String getEpoca() {
        return this.epoca;
    }

    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

    public String getTiempocompren() {
        return this.tiempocompren;
    }

    public void setTiempocompren(String tiempocompren) {
        this.tiempocompren = tiempocompren;
    }

    public Set<Autores> getAutoreses() {
        return this.autoreses;
    }

    public void setAutoreses(Set<Autores> autoreses) {
        this.autoreses = autoreses;
    }

    public Set<Obras> getObrases() {
        return this.obrases;
    }

    public void setObrases(Set<Obras> obrases) {
        this.obrases = obrases;
    }
}
