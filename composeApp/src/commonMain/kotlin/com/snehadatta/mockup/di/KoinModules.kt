package com.snehadatta.mockup.di

import com.snehadatta.mockup.home.data.repository.HomeRepositoryImpl
import com.snehadatta.mockup.home.domain.HomeRepository
import com.snehadatta.mockup.home.presentation.HomeViewModel
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module

val sharedModule = module {
    single<HomeRepository> { HomeRepositoryImpl() }
    viewModel { HomeViewModel(get()) }
}