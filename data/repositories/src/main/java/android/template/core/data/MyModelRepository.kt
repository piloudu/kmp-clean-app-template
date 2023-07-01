/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.template.core.data

import android.template.core.data.mappers.toDomainModel
import android.template.core.database.MyModel
import android.template.core.database.MyModelDao
import android.template.datasources.ProductDataSource
import android.template.datasources.apimodels.ProductApiModel
import android.template.domain.models.ProductModel
import android.template.domain.repositories.MyModelRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class DefaultMyModelRepository(
    // TODO: Manage taking data from either datasource or database
    private val myModelDao: MyModelDao,
    private val productDataSource: ProductDataSource,
) : MyModelRepository {

    override fun getMyModels(): Flow<ProductModel> {
        return productDataSource.getData().map(ProductApiModel::toDomainModel)
    }

    override suspend fun add(name: String) {
        myModelDao.insertMyModel(MyModel(name = name))
    }
}
