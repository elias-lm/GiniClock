package gini.apps.giniclock.data.firebase.database

import gini.apps.giniclock.data.firebase.database.company.FirebaseCompany
import gini.apps.giniclock.data.firebase.database.report.FirebaseReport
import gini.apps.giniclock.data.firebase.database.user.FirebaseUser
import gini.apps.giniclock.data.models.Report
import gini.apps.giniclock.data.models.User

class FirebaseDatabaseManager(
    private val firebaseUser: FirebaseUser,
    private val firebaseReport: FirebaseReport,
    private val firebaseCompany: FirebaseCompany
) {

    //user
    fun createUser( name: String, email: String) = firebaseUser.createUser(name, email)
    fun getProfile(id: String, onResult: (User) -> Unit) = firebaseUser.getProfile(id, onResult)

    //report
    fun getAllReportsByUserId(uId: String, onResult: (List<Long>?) -> Unit) = firebaseReport.getAllReportsIdByUserId(uId, onResult)
    fun getAllUsersByReportId(rId: String, onResult: (List<User>) -> Unit) = firebaseReport.getAllUsersByReportId(rId, onResult)
    fun createReport(uIds: List<String>, report: Report) = firebaseReport.createReport(uIds, report)

    //company
    fun getAllUsers(onResult: (List<User>) -> Unit) = firebaseCompany.getAllUsers(onResult)
    fun createCompany(id: String, name: String) = firebaseCompany.createCompany(id, name)
}