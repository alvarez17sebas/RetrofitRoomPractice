package com.salvarez.retrofitandroompractice.model

import java.lang.Exception

class BaseResponse<T> {
    var data: T? = null
    var exception: Exception? = null
}