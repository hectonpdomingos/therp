import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

class DBConnection {
    var username = "root"
    var password = "12domlei"
    var host = "127.0.0.1"
    var db = "therp"
    var strConnessione: String = "jdbc:mysql://" + this.host + ":3306/" + this.db + "?user=" +
            this.username + "&password=" + this.password + "&noAccessToProcedureBodies=true"
    var theClassName = "com.mysql.cj.jdbc.Driver"


class Customers{

    fun addCustomer(firstName: String, lastName: String, cpf:Int, rg:String, socialSecurity:String, country:String,
                    city:String, address:String, zipcode:Int, phone:Int, email:String){





    }


    fun listCustomers(){

    }

    fun searchCustomer(){

    }
    fun updateCustomer(){

    }
    fun deleteCustomer(){

    }


}








    fun listAllTasks() {

        var listAllTasks = "SELECT * FROM customers"
        Class.forName(theClassName)
        var conn: Connection = DriverManager.getConnection(strConnessione)
        var ps: PreparedStatement = conn.prepareStatement(listAllTasks)
        var rs: ResultSet = ps.executeQuery()
        while (rs.next()) {

            println(" -> (ID): " + rs.getString("id") + " (First Name): " + rs.getString("firstName") +
                    " (Last Name): " + rs.getString("lastName") + " (CPF): " + rs.getString("cpf") +
                    " (Registro Geral (BR)): " + rs.getString("registroGeral") +
                    " (Social Security (USA)): " + rs.getString("socialSecurity") + "\n" +
                    " (Country): " + rs.getString("country") + " (City) : " + rs.getString("city") +
                    " (Address): " + rs.getString("address") + " (Zipcode): " + rs.getString("zipcode")+
                    " (Phone): " + rs.getString("phone") + " (Email): " + rs.getString("email") +
                    " (Added in): " + rs.getString("created")
             )

        }
        println("")
        println("Press any key to back to menu")

        readLine()

    }
}




fun main(args: Array<String>) {

    var db = DBConnection()
    db.listAllTasks()

}