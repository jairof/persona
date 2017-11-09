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
@Table(name = "genero", schema = "${schema}")
public class Genero implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idgenero;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String genero;
    private Set<Obras> obrases = new HashSet<Obras>(0);

    public Genero() {
    }

    public Genero(Integer idgenero, String genero, Set<Obras> obrases) {
        this.idgenero = idgenero;
        this.genero = genero;
        this.obrases = obrases;
    }

    public Integer getIdgenero() {
        return this.idgenero;
    }

    public void setIdgenero(Integer idgenero) {
        this.idgenero = idgenero;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Set<Obras> getObrases() {
        return this.obrases;
    }

    public void setObrases(Set<Obras> obrases) {
        this.obrases = obrases;
    }
}
