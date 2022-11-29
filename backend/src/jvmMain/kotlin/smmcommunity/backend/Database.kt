package smmcommunity.backend

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.asJdbcDriver
import org.koin.dsl.module
import org.mariadb.jdbc.MariaDbDataSource

val dbModule = module {
    single {
        val driver: SqlDriver = MariaDbDataSource().apply {
            url = "jdbc:mariadb://db:3306/db"
            user = "root"
            setPassword("root")
        }.asJdbcDriver()
        Database(driver)
    }
}