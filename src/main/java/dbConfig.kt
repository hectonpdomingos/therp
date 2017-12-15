
class DBConnection {
    val username = "root"
    val password = "12domlei"
    val host = "127.0.0.1"
    val db = "therp"
    val pathConnection: String = "jdbc:mysql://" + this.host + ":3306/" + this.db + "?user=" +
            this.username + "&password=" + this.password + "&noAccessToProcedureBodies=true"
    val mysqlDriver = "com.mysql.cj.jdbc.Driver"

}