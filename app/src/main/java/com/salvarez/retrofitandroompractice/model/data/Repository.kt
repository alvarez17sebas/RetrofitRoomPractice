package com.salvarez.retrofitandroompractice.model.data

interface Repository<T> {
    suspend fun save(data: T)
    suspend fun saveAll(dataList: MutableList<T>)
    suspend fun update(data: T)
    suspend fun getAll(): MutableList<T>
    suspend fun getById(id: String): List<T>
}