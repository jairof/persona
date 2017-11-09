package demo.modelo.control;

import demo.modelo.Genero;

import demo.modelo.dto.GeneroDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IGeneroLogic {
    public List<Genero> getGenero() throws Exception;

    /**
         * Save an new Genero entity
         */
    public void saveGenero(Genero entity) throws Exception;

    /**
         * Delete an existing Genero entity
         *
         */
    public void deleteGenero(Genero entity) throws Exception;

    /**
        * Update an existing Genero entity
        *
        */
    public void updateGenero(Genero entity) throws Exception;

    /**
         * Load an existing Genero entity
         *
         */
    public Genero getGenero(Integer idgenero) throws Exception;

    public List<Genero> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Genero> findPageGenero(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberGenero() throws Exception;

    public List<GeneroDTO> getDataGenero() throws Exception;

    public void validateGenero(Genero genero) throws Exception;
}
