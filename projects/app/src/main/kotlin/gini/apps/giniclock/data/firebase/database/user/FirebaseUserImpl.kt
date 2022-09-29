package gini.apps.giniclock.data.firebase.database.user

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import gini.apps.giniclock.companyName
import gini.apps.giniclock.data.firebase.database.user.FirebaseUser.Companion.KEY_USER
import gini.apps.giniclock.data.models.User
import gini.apps.giniclock.data.models.UserResponse

class FirebaseUserImpl(
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
) : FirebaseUser {
    override fun createUser(name: String, email: String) {
        database
            .reference
            .child(companyName)
            .child(KEY_USER)
            .child(email.replace(".", ""))
            .setValue(User( name, email))
    }

    override fun getProfile(id: String, onResult: (User) -> Unit) {
        database.reference
            .child(companyName)
            .child(KEY_USER)
            .child(id.replace(".", ""))
            //Replaced addValueEventListener with:
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) = Unit

                override fun onDataChange(snapshot: DataSnapshot) {
                    val user = snapshot.getValue(UserResponse::class.java)
                    user?.run { onResult(User(username, email)) }
                }
            })
    }
}