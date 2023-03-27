
@Grapes(
      @Grab(group='mysql', module='mysql-connector-java', version='6.0.6')
  )
@GrabConfig(systemClassLoader=true)

import groovy.sql.*
import com.mysql.cj.jdbc.*

def sql = Sql.newInstance("jdbc:mysql://0.0.0.0:3306?useSSL=false", "root","swordfish", "com.mysql.cj.jdbc.Driver")

sql.execute("DROP DATABASE sandbox")

sql.close()

