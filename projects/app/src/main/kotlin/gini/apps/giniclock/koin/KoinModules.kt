package gini.apps.giniclock.koin

import gini.apps.giniclock.data.firebase.database.FirebaseDatabaseManager
import gini.apps.giniclock.data.firebase.database.company.FirebaseCompany
import gini.apps.giniclock.data.firebase.database.company.FirebaseCompanyImpl
import gini.apps.giniclock.data.firebase.database.report.FirebaseReport
import gini.apps.giniclock.data.firebase.database.report.FirebaseReportImpl
import gini.apps.giniclock.data.firebase.database.user.FirebaseUser
import gini.apps.giniclock.data.firebase.database.user.FirebaseUserImpl
import gini.apps.giniclock.ui.Navigator
import gini.apps.giniclock.ui.screens.MainViewModel
import gini.apps.giniclock.ui.screens.ReportsRepository
import gini.apps.giniclock.ui.screens.RootScreenViewModel
import gini.apps.giniclock.ui.screens.TestViewViewModel
import gini.apps.giniclock.ui.views.ReportViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel { params -> RootScreenViewModel(params.get(), get()) }
    viewModel { MainViewModel(get(), get(), get()) }
    viewModelOf(::ReportViewModel)
    viewModelOf(::TestViewViewModel)

}

val services = module {
    singleOf(::Navigator)
}

val reposModule = module {

    singleOf(::ReportsRepository)

}

val firebaseModule = module {

    singleOf(::FirebaseDatabaseManager)
    single<FirebaseUser> { FirebaseUserImpl() }
    single<FirebaseReport> { FirebaseReportImpl() }
    single<FirebaseCompany> { FirebaseCompanyImpl() }

}