package com.example.paginationusingpaging3.network

import android.app.Activity
import android.widget.Toast

/*
 * Created by : Himasnhu patel
 * Support :himanshu.patel@unorg.in
 * Last modified 3/25/23, 10:16 PM
 * Copyright (c) Unorg 2023.
 * All rights reserved.
 */
fun Activity.showToast(value:String){
    Toast.makeText(applicationContext,value,Toast.LENGTH_LONG).show()
}