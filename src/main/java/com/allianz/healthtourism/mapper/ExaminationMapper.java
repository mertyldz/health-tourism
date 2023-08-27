package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.ExaminationEntity;
import com.allianz.healthtourism.model.requestDTO.ExaminationRequestDTO;
import com.allianz.healthtourism.model.responseDTO.ExaminationDTO;
import com.allianz.healthtourism.utils.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {PatientMapper.class})
public interface ExaminationMapper extends IBaseMapper<ExaminationEntity, ExaminationDTO, ExaminationRequestDTO> {

    @Override
    default ExaminationEntity requestDtoToExistEntity(ExaminationEntity entity, ExaminationRequestDTO requestDTO) {
        entity.setDiagnosis(requestDTO.getDiagnosis());
        entity.setTreatmentPrescription(requestDTO.getTreatmentPrescription());
        entity.setExaminationDate(requestDTO.getExaminationDate());
        if (requestDTO.getPatient() != null) {
            entity.setPatient(Mappers.getMapper(PatientMapper.class).requestDTOToEntity(requestDTO.getPatient()));
        }
        return entity;
    }
}
