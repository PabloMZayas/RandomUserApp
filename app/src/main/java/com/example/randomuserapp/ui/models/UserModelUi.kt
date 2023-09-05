package com.example.randomuserapp.ui.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class UserModelUi(
        val info: InfoUi,
        val results: List<ResultUi>)

data class InfoUi(
        val page: Int,
        val results: Int,
        val seed: String,
        val version: String
)

@Parcelize
data class ResultUi(
        val cell: String,
        val dob: DobUi,
        val email: String,
        val gender: String,
        val id: IdUi,
        val location: LocationUi,
        val login: LoginUi,
        val name: NameUi,
        val nat: String,
        val phone: String,
        val picture: PictureUi,
        val registered: RegisteredUi
): Parcelable

@Parcelize
data class IdUi(
        val name: String,
        val value: String
): Parcelable

@Parcelize
data class DobUi(
        val age: Int,
        val date: String
): Parcelable

@Parcelize
data class LocationUi(
        val city: String,
        val coordinates: CoordinatesUi,
        val country: String,
        val postcode: String,
        val state: String,
        val street: StreetUi,
        val timezone: TimezoneUi
): Parcelable

@Parcelize
data class LoginUi(
        val md5: String,
        val password: String,
        val salt: String,
        val sha1: String,
        val sha256: String,
        val username: String,
        val uuid: String
): Parcelable

@Parcelize
data class NameUi(
        val first: String,
        val last: String,
        val title: String
): Parcelable

@Parcelize
data class PictureUi(
        val large: String,
        val medium: String,
        val thumbnail: String
): Parcelable

@Parcelize
data class RegisteredUi(
        val age: Int,
        val date: String
): Parcelable

@Parcelize
data class CoordinatesUi(
        val latitude: String,
        val longitude: String
): Parcelable

@Parcelize
data class StreetUi(
        val name: String,
        val number: Int
): Parcelable

@Parcelize
data class TimezoneUi(
        val description: String,
        val offset: String
): Parcelable
