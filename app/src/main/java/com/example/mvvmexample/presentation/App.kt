package com.example.mvvmexample.presentation

import android.app.Application
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp //Annotacja oznaczająca klase, w której komponenty Daggera mają być generowane
class App : Application()
