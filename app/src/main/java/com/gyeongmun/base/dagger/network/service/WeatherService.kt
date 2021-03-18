package com.gyeongmun.base.dagger.network.service

import com.gyeongmun.base.dagger.network.response.CityResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

//    @POST("/api/v1/pets")
//    suspend fun addPet(@Body petProfileRequest: PetProfileRequest): PetsIdResponse
//
    @GET("/api/location/search/")
    suspend fun getCities(@Query("query") query: String): List<CityResponse>
//
//    @GET("/api/v1/pets/{id}")
//    suspend fun getPetId(@Path("id") id: String): PetsIdResponse
//
//    @DELETE("/api/v1/pets/{id}")
//    suspend fun deletePetId(@Path("id") id: String): String
//
//    @POST("/api/v1/pets/{petId}/inspections")
//    suspend fun postPetsPetIdInspections(
//        @Path("petId") petId: String,
//        @Body petsPetIdInspectionsRequest: PetsPetIdInspectionsRequest
//    ): PetsPetIdInspectionsResponse
//
//    @DELETE("/api/v1/pets/{petId}/inspections/{inspectionId}")
//    suspend fun deletePetsPetIdInspectionsInspectionId(
//        @Path("petId") petId: String,
//        @Path("inspectionId") inspectionId: String
//    ): DeleteInspectionRes
//
//    // 반려동물 검사결과 리스트 조회
//    @GET("/api/v2/pets/{petId}/inspections")
//    suspend fun getPetsInspectionsV2(
//        @Path("petId") petId: String,
//        @Query("lang_type") langType: String = getLanguageToServer()
//    ): InspectionsResultResponse
//
//    // 반려동물 검사결과 리스트 조회
//    @GET("/api/v2/pets/{petId}/inspections")
//    suspend fun getPetsInspectionsByItem(
//        @Path("petId") petId: String,
//        @Query("item_code") itemCode: String,
//        @Query("lang_type") langType: String = getLanguageToServer()
//    ): InspectionItemResponse
//
//    // 반려동물 검사결과 리스트 조회
//    @GET("/api/v2/disease/{disease_code}")
//    suspend fun getDisease(
//        @Path("disease_code") diseaseCode: String,
//        @Query("pet_type") petType: String,
//        @Query("lang_type") langType: String = getLanguageToServer()
//    ): DiseaseResponse
//
//    @GET("api/v2/pets_species")
//    suspend fun getPetsSpecies(): PetsSpeciesResponse
//
//    @PUT("/api/v1/photos")
//    fun putPhotos(@Body photoRequest: PhotoRequest): PhotoResponse
}
