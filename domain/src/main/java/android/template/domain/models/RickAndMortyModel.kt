package android.template.domain.models

data class RickAndMortyModel(
    val name: Name,
    val status: Status,
    val species: Species,
    val gender: Gender,
    val planet: Planet,
    val imageUrl: Url
)

@JvmInline
value class Name(val value: String)

@JvmInline
value class Status(val value: String)

@JvmInline
value class Species(val value: String)

@JvmInline
value class Gender(val value: String)

@JvmInline
value class Planet(val value: String)
