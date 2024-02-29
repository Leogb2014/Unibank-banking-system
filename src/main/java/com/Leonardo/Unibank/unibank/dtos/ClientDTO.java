package com.Leonardo.Unibank.unibank.dtos;

import java.time.Instant;

public record ClientDTO(Long id, String name, Instant birthDate) {
}
