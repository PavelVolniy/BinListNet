package com.chetv.binlistnet.data.api

import com.chetv.binlistnet.data.model.jsonfromserver.JsonFromBinListNet
import retrofit2.http.GET

interface BinListApi {

  @GET("45717360")
  suspend fun getDataFromServer(/*@StringRes res: Map<String, String>*/): JsonFromBinListNet
}