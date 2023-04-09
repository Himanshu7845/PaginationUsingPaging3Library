/*
 * Created by : Tanishq Chawda on 3/25/23, 9:26 PM
 * Support :itanishqdeveloper@gmail.com
 * Last modified 3/25/23, 9:26 PM
 * Copyright (cart) Unorg 2023.
 * All rights reserved.
 */

package com.user.unorg.network

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.regex.Matcher
import java.util.regex.Pattern

object Constants {
    const val PROD_URL = "https://jsonplaceholder.typicode.com/"
    const val DEV_URL = "https://jsonplaceholder.typicode.com/"
    const val TEMP_URL = "https://pokeapi.co/api/v2/"
    const val STAGING_URL = "http://3.111.51.99:5000/api/v1/unorg/userapp/"

    var token:String="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXlsb2FkIjp7InVzZXJfaWQiOiJkZDdjMmM1My0wOTIxLTQ5MTAtYTg0OC0yMWU1NjFhYjJmYmUiLCJ1c2VybmFtZSI6InNhbmdhbXRlc3QiLCJlbWFpbCI6InNhbmFtdGVzdEBnbWFpbC5jb20iLCJmaXJzdF9uYW1lIjoiU2FuZ2FtIiwibGFzdF9uYW1lIjoiTGFsIn0sImV4cCI6MTY4MDk0NzE0OH0.46yg7f3TiCsTPFbeUls0QgLOSNyO4KaRj-9bg57LseE"
    var userId:String="dd7c2c53-0921-4910-a848-21e561ab2fbe"


}