package com.amirhusseinsoori.domain.exception

data class CustomResult<T>(val status: Int, val data: T?, val message: String?=null) {
    fun isError() = status == STATUS_ERROR
    fun isLoading() = status == STATUS_LOADING
    fun isSuccess() = status == STATUS_SUCCESS

    companion object {
        private const val STATUS_LOADING = 0
        private const val STATUS_SUCCESS = 1
        private const val STATUS_ERROR = -1

        /**
         * Helper method to create fresh state result
         */
        fun <T> success(data: T): CustomResult<T> {
            return CustomResult(STATUS_SUCCESS, data)
        }

        /**
         * Helper method to create error state Result. Error state might also have the current data, if any
         */
        fun <T> error(item: T? = null,message:String?=null): CustomResult<T> {
            return CustomResult(STATUS_ERROR, item,message)
        }

        /**
         * Helper method to create loading state Result.
         */
        fun <T> loading(data: T? = null): CustomResult<T> {
            return CustomResult(STATUS_LOADING, data)
        }
    }
}