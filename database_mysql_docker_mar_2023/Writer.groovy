
@Grapes(
      @Grab(group='mysql', module='mysql-connector-java', version='6.0.6')
  )
@GrabConfig(systemClassLoader=true)

import groovy.sql.*
import com.mysql.cj.jdbc.*

def sql = Sql.newInstance("jdbc:mysql://0.0.0.0:3306?useSSL=false", "root","swordfish", "com.mysql.cj.jdbc.Driver")

sql.execute("CREATE DATABASE sandbox")
sql.execute("USE sandbox")

sql.execute("""
CREATE TABLE account( account_id bigint NOT NULL,
username VARCHAR(256) NOT NULL,
status VARCHAR(256)
);
""")

def insert = " INSERT INTO account (account_id, username, status) VALUES (?,?,?); "

sql.execute(insert, [100, 'James_Bond',     'active']);
sql.execute(insert, [120, 'Jason_Bourne',   'cancel'])
sql.execute insert, [130, 'Emily_Pollifax', 'cancel']
sql.execute insert, [170, 'Maxwell_Smart',  'block']
sql.execute insert, [190, 'Jaime_Sommers',  'active']
sql.execute insert, [200, 'Blanche_White',  'active']

sql.close()

