package com.example.wetherappfull

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
//расширение проверяет есть ли уже имеющееся разрешение на использование местоположения? Срабатывает каждый раз при входе в приложение
fun Fragment.isPermissionGranted(p: String): Boolean {
    return ContextCompat.checkSelfPermission(activity as AppCompatActivity, p) == PackageManager.PERMISSION_GRANTED
}