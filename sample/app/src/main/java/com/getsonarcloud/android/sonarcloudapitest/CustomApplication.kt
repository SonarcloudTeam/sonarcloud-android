package com.getsonarcloud.android.sonarcloudapitest

import android.app.Application
import com.getsonarcloud.android.sdk.Sonarcloud
import com.getsonarcloud.android.sdk.models.Organization
import com.getsonarcloud.android.sdk.models.User

const val identifier = ""
const val secret = ""

class CustomApplication : Application() {
    /**
     * We are created!
     */
    override fun onCreate() {
        super.onCreate()

        val user = User().apply {
            externalID = "test-user"
            name = "Chaz A. Leonetti"
            email = "chaz@theleonetti.com"
        }
        val organization = Organization().apply {
            externalID = "test-organization"
            name = "My Test Organization"
        }

        // Set the credentials
        Sonarcloud.initialize(
            this,
            identifier,
            secret
        ).setUser(user).setOrganization(organization)
    }
}