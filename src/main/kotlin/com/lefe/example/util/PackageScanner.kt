package com.lefe.example.util

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component


@Component
class PackageScanner {
    @Autowired
    private val applicationContext: ApplicationContext? = null
    fun logScannedPackages() {
        val scannedPackages = applicationContext!!.beanDefinitionNames
        println("Scanned packages in the application context:")
        for (packageName in scannedPackages) {
            println("- $packageName")
        }
    }
}

