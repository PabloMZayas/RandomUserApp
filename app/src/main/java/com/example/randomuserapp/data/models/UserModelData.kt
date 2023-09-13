package com.example.randomuserapp.data.models

import com.example.randomuserapp.ui.models.CoordinatesUi
import com.example.randomuserapp.ui.models.DobUi
import com.example.randomuserapp.ui.models.IdUi
import com.example.randomuserapp.ui.models.InfoUi
import com.example.randomuserapp.ui.models.LocationUi
import com.example.randomuserapp.ui.models.LoginUi
import com.example.randomuserapp.ui.models.NameUi
import com.example.randomuserapp.ui.models.PictureUi
import com.example.randomuserapp.ui.models.RegisteredUi
import com.example.randomuserapp.ui.models.ResultUi
import com.example.randomuserapp.ui.models.StreetUi
import com.example.randomuserapp.ui.models.TimezoneUi
import com.example.randomuserapp.ui.models.UserModelUi
import com.google.gson.annotations.SerializedName

data class UserModelData(
        @SerializedName("info") val info: Info,
        @SerializedName("results") val results: List<Result>)

data class Info(
        val page: Int,
        val results: Int,
        val seed: String,
        val version: String
)

data class Result(
        val cell: String,
        val dob: Dob,
        val email: String,
        val gender: String,
        val id: Id,
        val location: Location,
        val login: Login,
        val name: Name,
        val nat: String,
        val phone: String,
        val picture: Picture,
        val registered: Registered
)

data class Id(
        val name: String,
        val value: String
)

data class Dob(
        val age: Int,
        val date: String
)

data class Location(
        val city: String,
        val coordinates: Coordinates,
        val country: String,
        val postcode: String,
        val state: String,
        val street: Street,
        val timezone: Timezone
)

data class Login(
        val md5: String,
        val password: String,
        val salt: String,
        val sha1: String,
        val sha256: String,
        val username: String,
        val uuid: String
)

data class Name(
        val first: String,
        val last: String,
        val title: String
)

data class Picture(
        val large: String,
        val medium: String,
        val thumbnail: String
)

data class Registered(
        val age: Int,
        val date: String
)

data class Coordinates(
        val latitude: String,
        val longitude: String
)

data class Street(
        val name: String,
        val number: Int
)

data class Timezone(
        val description: String,
        val offset: String
)

fun UserModelData.toUserModelUI() = UserModelUi(
        info = info.toInfoUi(),
        results = getResultsUi(results)
)

fun getResultsUi(results: List<Result>): List<ResultUi> {
    return results.map { it.toResultUi() }
}

fun Info.toInfoUi() = InfoUi(
        page = page,
        results = results,
        seed = seed,
        version = version
)

fun Result.toResultUi() = ResultUi(
        cell = cell,
        email = email,
        gender = gender,
        id = id.toIdUi(),
        location = location.toLocationUi(),
        login = login.toLoginUi(),
        name = name.toNameUi(),
        nat = nat,
        phone = phone,
        picture = picture.toPictureUi(),
        registered = registered.toRegisteredUi(),
        dob = dob.toDobUi()
)

fun Id.toIdUi() = IdUi(
        name = name,
        value = value
)

fun Dob.toDobUi () = DobUi(
        age = age,
        date = date
)

fun Location.toLocationUi() = LocationUi(
        city = city,
        coordinates = coordinates.toCoordinatesUi(),
        country = country,
        postcode = postcode,
        state = state,
        street = street.toStreetUi(),
        timezone = timezone.toTimeZoneUi()
)

fun Login.toLoginUi() = LoginUi(
        md5 = md5,
        password = password,
        salt = salt,
        sha1 = sha1,
        sha256 = sha256,
        username = username,
        uuid = uuid
)

fun Name.toNameUi () = NameUi(
        first = first,
        last = last,
        title = title
)

fun Picture.toPictureUi() = PictureUi(
        large = large,
        medium = medium,
        thumbnail = thumbnail
)

fun Registered.toRegisteredUi() = RegisteredUi(
        age = age,
        date = date
)

fun Coordinates.toCoordinatesUi() = CoordinatesUi(
        latitude = latitude,
        longitude = longitude
)

fun Street.toStreetUi() = StreetUi(
        name = name,
        number = number
)

fun Timezone.toTimeZoneUi() = TimezoneUi(
        description = description,
        offset = offset
)
