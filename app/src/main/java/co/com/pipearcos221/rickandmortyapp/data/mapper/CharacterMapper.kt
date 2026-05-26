package co.com.pipearcos221.rickandmortyapp.data.mapper

import co.com.pipearcos221.rickandmortyapp.data.remote.dto.CharacterDto
import co.com.pipearcos221.rickandmortyapp.domain.model.Character

fun CharacterDto.toDomain(): Character {
    return Character(
        id = id,
        name = name,
        status = status,
        imageUrl = image
    )
}
