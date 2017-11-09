package demo.modelo.control;

import demo.modelo.Autores;

import demo.modelo.dto.AutoresDTO;

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
public interface IAutoresLogic {
    public List<Autores> getAutores() throws Exception;

    /**
         * Save an new Autores entity
         */
    public void saveAutores(Autores entity) throws Exception;

    /**
         * Delete an existing Autores entity
         *
         */
    public void deleteAutores(Autores entity) throws Exception;

    /**
        * Update an existing Autores entity
        *
        */
    public void updateAutores(Autores entity) throws Exception;

    /**
         * Load an existing Autores entity
         *
         */
    public Autores getAutores(Integer idautor) throws Exception;

    public List<Autores> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Autores> findPageAutores(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberAutores() throws Exception;

    public List<AutoresDTO> getDataAutores() throws Exception;

    public void validateAutores(Autores autores) throws Exception;
}
