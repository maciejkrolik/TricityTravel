/*
 * Copyright © 2019 by Agnieszka Maciejewska, Maciej Królik, Krzysztof Mikołajczyk. TricityTravel
 * This application is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/.
 */

package com.aib.tricitytravel.data.service

import com.aib.tricitytravel.data.APIKeys
import com.aib.tricitytravel.data.dto.api.GeocoderResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface HereGeocoderService {

    @GET("6.2/geocode.json?app_id=${APIKeys.HERE_APP_ID}&app_code=${APIKeys.HERE_APP_CODE}")
    fun getGeoParametersAsync(
        @Query("searchtext") searchText: String
    ): Deferred<GeocoderResponse>
}