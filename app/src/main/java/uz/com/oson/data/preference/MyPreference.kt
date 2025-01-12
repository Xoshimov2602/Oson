package uz.com.oson.data.preference

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyPreference @Inject constructor(@ApplicationContext context: Context) :
    SharedPreference(context) {
    var accessToken: String by strings()
    var refreshToken: String by strings()
    var isRegistered: Boolean by booleans()
    var chosenLanguage: String by strings()
    var tempToken: String by strings()
    var code: String by strings()
}