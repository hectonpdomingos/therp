
class DBConnection {
    var username = "root"
    var password = "12domlei"
    var host = "127.0.0.1"
    var db = "therp"
    var strConnessione: String = "jdbc:mysql://" + this.host + ":3306/" + this.db + "?user=" +
            this.username + "&password=" + this.password + "&noAccessToProcedureBodies=true"
    var theClassName = "com.mysql.cj.jdbc.Driver"

}