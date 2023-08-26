package com.allianz.healthtourism.utils;

import com.allianz.healthtourism.model.requestDTO.PageDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IBaseMapper<
        Entity extends BaseEntity,
        DTO extends BaseDTO,
        RequestDTO extends BaseRequestDTO> {

    DTO entityToDTO(Entity entity);

    Entity dtoToEntity(DTO dto);

    List<DTO> entityListToDTOList(List<Entity> entityList);

    List<Entity> dtoListTOEntityList(List<DTO> dtoList);

    Entity requestDTOToEntity(RequestDTO dto);

    List<Entity> requestDtoListTOEntityList(List<RequestDTO> dtoList);

    Entity requestDtoToExistEntity(Entity entity, RequestDTO requestDTO);

    PageDTO<DTO> pageEntityToPageDTO(Page<Entity> entityPage);
}
