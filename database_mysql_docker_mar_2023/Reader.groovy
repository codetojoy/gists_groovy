
@Grapes(
    @Grab(group='mysql', module='mysql-connector-java', version='6.0.6')
)
@GrabConfig(systemClassLoader=true)

import groovy.sql.*
import com.mysql.cj.jdbc.*

def sql = Sql.newInstance("jdbc:mysql://0.0.0.0:3306?useSSL=false", "root","swordfish", "com.mysql.cj.jdbc.Driver")

sql.execute("USE sandbox")

sql.eachRow("SELECT account_id, username, status FROM account") { row ->
    println "account_id: ${row.account_id} username: ${row.username} status: ${row.status}"
}

sql.close()

