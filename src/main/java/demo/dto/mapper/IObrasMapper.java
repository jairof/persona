package demo.dto.mapper;

import demo.modelo.Obras;

import demo.modelo.dto.ObrasDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IObrasMapper {
    public ObrasDTO obrasToObrasDTO(Obras obras) throws Exception;

    public Obras obrasDTOToObras(ObrasDTO obrasDTO) throws Exception;

    public List<ObrasDTO> listObrasToListObrasDTO(List<Obras> obrass)
        throws Exception;

    public List<Obras> listObrasDTOToListObras(List<ObrasDTO> obrasDTOs)
        throws Exception;
}
