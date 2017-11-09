package demo.dto.mapper;

import demo.modelo.Autores;

import demo.modelo.dto.AutoresDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IAutoresMapper {
    public AutoresDTO autoresToAutoresDTO(Autores autores)
        throws Exception;

    public Autores autoresDTOToAutores(AutoresDTO autoresDTO)
        throws Exception;

    public List<AutoresDTO> listAutoresToListAutoresDTO(List<Autores> autoress)
        throws Exception;

    public List<Autores> listAutoresDTOToListAutores(
        List<AutoresDTO> autoresDTOs) throws Exception;
}
