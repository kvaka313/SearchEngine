package com.galkin.search_engine.mapper;

import com.galkin.search_engine.dto.ResultItemInternalDto;
import com.galkin.search_engine.dto.ResultSearchItemDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SearchMapper {
    public ResultSearchItemDto convertInternalDtoToResponseDto(ResultItemInternalDto resultItemInternalDto) {
        ResultSearchItemDto responseDto = new ResultSearchItemDto();
        responseDto.setDescription(resultItemInternalDto.getDescription());
        responseDto.setLink(resultItemInternalDto.getLink());
        return responseDto;
    }

    public List<ResultSearchItemDto> convertInternalListDtoToResponseListDto(List<ResultItemInternalDto> resultItemInternalDtos) {
        return resultItemInternalDtos.stream().map(this::convertInternalDtoToResponseDto).collect(Collectors.toUnmodifiableList());
    }
}
