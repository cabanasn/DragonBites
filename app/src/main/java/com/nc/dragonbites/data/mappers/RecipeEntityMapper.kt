package com.nc.dragonbites.data.mappers

import com.nc.dragonbites.data.local.entity.RecipeEntity
import com.nc.dragonbites.data.remote.response.Recipe

object RecipeEntityMapper : EntityMapper<List<Recipe>, List<RecipeEntity>> {
    override fun asEntity(domain: List<Recipe>): List<RecipeEntity> {
        return domain.map {
            RecipeEntity(
                id = it.id,
                difficulty = it.difficulty,
                image = it.image,
                title = it.title
            )
        }
    }

    override fun asDomain(entity: List<RecipeEntity>): List<Recipe> {
        return entity.map {
            Recipe(
                id = it.id,
                difficulty = it.difficulty,
                image = it.image,
                title = it.title
            )
        }
    }
}

fun List<Recipe>.asEntity(): List<RecipeEntity> {
    return RecipeEntityMapper.asEntity(this)
}

fun List<RecipeEntity>.asDomain(): List<Recipe> {
    return RecipeEntityMapper.asDomain(this)
}