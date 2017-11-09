package demo.dto.mapper;

import demo.modelo.Genero;

import demo.modelo.dto.GeneroDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IGeneroMapper {
    public GeneroDTO generoToGeneroDTO(Genero genero) throws Exception;

    public Genero generoDTOToGenero(GeneroDTO generoDTO)
        throws Exception;

    public List<GeneroDTO> listGeneroToListGeneroDTO(List<Genero> generos)
        throws Exception;

    public List<Genero> listGeneroDTOToListGenero(List<GeneroDTO> generoDTOs)
        throws Exception;
}
