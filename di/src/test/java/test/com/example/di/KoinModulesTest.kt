package test.com.example.di

import com.example.di.koinModules
import org.junit.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.verify.verifyAll

@OptIn(KoinExperimentalAPI::class)
class KoinModulesTest {

    @Ignore
    @Test
    fun checkKoinModules() {
        koinModules.verifyAll()
    }
}
