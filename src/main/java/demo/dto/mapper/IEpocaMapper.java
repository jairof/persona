package demo.dto.mapper;

import demo.modelo.Epoca;

import demo.modelo.dto.EpocaDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IEpocaMapper {
    public EpocaDTO epocaToEpocaDTO(Epoca epoca) throws Exception;

    public Epoca epocaDTOToEpoca(EpocaDTO epocaDTO) throws Exception;

    public List<EpocaDTO> listEpocaToListEpocaDTO(List<Epoca> epocas)
        throws Exception;

    public List<Epoca> listEpocaDTOToListEpoca(List<EpocaDTO> epocaDTOs)
        throws Exception;
}
