package gini.apps.giniclock.data.models

data class UserResponse(
    val username: String = "",
    val email: String = "",
)

data class User(
    val username: String,
    val email: String
)