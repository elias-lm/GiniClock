package gini.apps.giniclock.data.firebase.database.report

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import gini.apps.giniclock.companyName
import gini.apps.giniclock.data.firebase.database.report.FirebaseReport.Companion.KEY_REPORT
import gini.apps.giniclock.data.firebase.database.user.FirebaseUser.Companion.KEY_USER
import gini.apps.giniclock.data.models.Report
import gini.apps.giniclock.data.models.User


class FirebaseReportImpl(
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
) : FirebaseReport {


    override fun getAllReportsIdByUserId(uId: String, onResult: (List<Long>?) -> Unit) {
        database.reference
            .child(companyName)
            .child(KEY_USER)
            .child(uId.replace(".", ""))
            .child(KEY_REPORT)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) = Unit

                override fun onDataChange(snapshot: DataSnapshot) {

                    val result = mutableListOf<Long>()
                    for (child in snapshot.children) {
                        val temp = child.getValue(Long::class.java)
                        temp?.let {
                            result.add(it)
                        }
                    }
                    onResult(result)
                }
            })
    }

    override fun getAllUsersByReportId(rId: String, onResult: (List<User>) -> Unit) {
    }

    override fun createReport(uIds: List<String>, report: Report) {
        for (uId in uIds) {
            getAllReportsIdByUserId(uId) { list ->
                val allReports = list?.toMutableList()
                allReports?.let { list ->
                    report.startDateTime?.let {
                        allReports?.add(it)
                    }

                    database
                        .reference
                        .child(companyName)
                        .child(KEY_USER)
                        .child(uId.replace(".", ""))
                        .child(KEY_REPORT)
                        .setValue(list)
                }
            }
        }

        val ref = database.reference.child(companyName).child(KEY_REPORT)
            .child(report.startDateTime.toString())
        ref.setValue(report)
        ref.child(KEY_USER).setValue(uIds)


    }
}