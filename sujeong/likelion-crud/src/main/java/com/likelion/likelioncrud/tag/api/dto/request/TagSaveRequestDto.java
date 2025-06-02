package com.likelion.likelioncrud.tag.api.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TagSaveRequestDto(
        String name
) {
}
