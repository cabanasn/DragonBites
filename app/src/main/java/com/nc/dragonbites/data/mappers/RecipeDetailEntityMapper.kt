package com.nc.dragonbites.data.mappers

import com.nc.dragonbites.data.local.entity.RecipeDetailEntity
import com.nc.dragonbites.data.remote.response.RecipeDetail

class RecipeDetailEntityMapper : EntityMapper<RecipeDetail, RecipeDetailEntity> {
    override fun asEntity(domain: RecipeDetail): RecipeDetailEntity {
        return RecipeDetailEntity(
            id = domain.id,
            title = domain.title,
            image = domain.image,
            difficulty = domain.difficulty,
            ingredients = domain.ingredients,
            method = domain.method,
            portion = domain.portion,
            time = domain.time,
            description = domain.description
        )
    }

    override fun asDomain(entity: RecipeDetailEntity): RecipeDetail {
        return RecipeDetail(
            id = entity.id,
            title = entity.title,
            image = entity.image,
            difficulty = entity.difficulty,
            ingredients = entity.ingredients,
            method = entity.method,
            portion = entity.portion,
            time = entity.time,
            description = entity.description
        )
    }
}

fun RecipeDetail.asEntity(): RecipeDetailEntity {
    return RecipeDetailEntityMapper().asEntity(this)
}

fun RecipeDetailEntity.asDomain(): RecipeDetail {
    return RecipeDetailEntityMapper().asDomain(this)
}