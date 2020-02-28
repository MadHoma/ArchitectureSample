package com.sample.data.model.user

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name") val name: Name,
    @SerializedName("picture") val picture: Picture,
    @SerializedName("dob") val dob: Dob,
    @SerializedName("location") val location: Location,
    @SerializedName("phone") val phone: String,
    @SerializedName("email") val email: String,
    @SerializedName("gender") val gender: String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Name::class.java.classLoader),
        parcel.readParcelable(Picture::class.java.classLoader),
        parcel.readParcelable(Dob::class.java.classLoader),
        parcel.readParcelable(Location::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(name, flags)
        parcel.writeParcelable(picture, flags)
        parcel.writeParcelable(dob, flags)
        parcel.writeParcelable(location, flags)
        parcel.writeString(phone)
        parcel.writeString(email)
        parcel.writeString(gender)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

}