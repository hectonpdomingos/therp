
class DBConnection {
    var username = "root"
    var password = "12domlei"
    var host = "127.0.0.1"
    var db = "therp"
    var pathConnection: String = "jdbc:mysql://" + this.host + ":3306/" + this.db + "?user=" +
            this.username + "&password=" + this.password + "&noAccessToProcedureBodies=true"
    var mysqlDriver = "com.mysql.cj.jdbc.Driver"

}