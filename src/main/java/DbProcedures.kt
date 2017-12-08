import com.mysql.cj.api.exceptions.ExceptionInterceptor
import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

class Customers {
    var theClassName = DBConnection()

    fun addCustomer(firstName: String, lastName: String, cpf: Int, rg: String, socialSecurity: String, country: String,
                    city: String, address: String, zipcode: Int, phone: Int, email: String) {


        try {
            var addNewCustomer: String = "INSERT INTO `therp`.`customers` (`firstName`, `lastName`, `cpf`, `registroGeral`, " +
                    " `socialSecurity`, `country`, `city`, `address`, `zipcode`, `phone`, `email`) VALUES ('" + firstName.trim() + "'," +
                    "'" + lastName.trim() + "', '" + cpf.toString().trim().toInt() + "', '" + rg.trim() + "', '" + socialSecurity.trim() + "', '" + country.trim() + "', '" + city.trim() + "', '" + address.trim() + "', '" + zipcode + "', " +
                    "'" + phone.toString().trim().toInt() + "','" + email.trim() + "');\n"

            Class.forName(theClassName.theClassName)
            var conn: Connection = DriverManager.getConnection(theClassName.strConnessione)
            var ps: PreparedStatement = conn.prepareStatement(addNewCustomer)
            ps.execute()

        }catch (e: Exception){
            println("Error: " + e.message)
        }




    }


    fun listCustomers() {
        var listAllTasks = "SELECT * FROM customers"
        Class.forName(theClassName.theClassName)
        var conn: Connection = DriverManager.getConnection(theClassName.strConnessione)
        var ps: PreparedStatement = conn.prepareStatement(listAllTasks)
        var rs: ResultSet = ps.executeQuery()
        while (rs.next()) {

            println(" -> (ID): " + rs.getString("id") + " (First Name): " + rs.getString("firstName") +
                    " (Last Name): " + rs.getString("lastName") + " (CPF): " + rs.getString("cpf") +
                    " (Registro Geral (BR)): " + rs.getString("registroGeral") +
                    " (Social Security (USA)): " + rs.getString("socialSecurity") + "\n" +
                    " (Country): " + rs.getString("country") + " (City) : " + rs.getString("city") +
                    " (Address): " + rs.getString("address") + " (Zipcode): " + rs.getString("zipcode") +
                    " (Phone): " + rs.getString("phone") + " (Email): " + rs.getString("email") +
                    " (Added in): " + rs.getString("created")
            )
            println()

        }
        println("")
        println("Press any key to back to menu")

        readLine()

    }


    fun searchCustomerByFirstName(searchByFirstName: String) {

        println("The result of your search...")
        println("")
        var findQuery = "SELECT * FROM customers WHERE firstName LIKE'%"+searchByFirstName.trim()+"%'"
        Class.forName(theClassName.theClassName)
        var conn: Connection = DriverManager.getConnection(theClassName.strConnessione)
        var ps: PreparedStatement = conn.prepareStatement(findQuery)
        var rs: ResultSet = ps.executeQuery()
        while (rs.next()) {

            println(" -> (ID): " + rs.getString("id") + " (First Name): " + rs.getString("firstName") +
                    " (Last Name): " + rs.getString("lastName") + " (CPF): " + rs.getString("cpf") +
                    " (Registro Geral (BR)): " + rs.getString("registroGeral") +
                    " (Social Security (USA)): " + rs.getString("socialSecurity") + "\n" +
                    " (Country): " + rs.getString("country") + " (City) : " + rs.getString("city") +
                    " (Address): " + rs.getString("address") + " (Zipcode): " + rs.getString("zipcode") +
                    " (Phone): " + rs.getString("phone") + " (Email): " + rs.getString("email") +
                    " (Added in): " + rs.getString("created")
            )
            println()
        }
        println("")
        println("Press any key to back to menu")
        println("")
        readLine()


    }

    fun searchCustomerByLastName(searchByLastName: String) {
        println("The result of your search...")
        println("")
        var findQuery = "SELECT * FROM customers WHERE lastName LIKE'%"+searchByLastName.trim()+"%'"
        Class.forName(theClassName.theClassName)
        var conn: Connection = DriverManager.getConnection(theClassName.strConnessione)
        var ps: PreparedStatement = conn.prepareStatement(findQuery)
        var rs: ResultSet = ps.executeQuery()
        while (rs.next()) {

            println(" -> (ID): " + rs.getString("id") + " (First Name): " + rs.getString("firstName") +
                    " (Last Name): " + rs.getString("lastName") + " (CPF): " + rs.getString("cpf") +
                    " (Registro Geral (BR)): " + rs.getString("registroGeral") +
                    " (Social Security (USA)): " + rs.getString("socialSecurity") + "\n" +
                    " (Country): " + rs.getString("country") + " (City) : " + rs.getString("city") +
                    " (Address): " + rs.getString("address") + " (Zipcode): " + rs.getString("zipcode") +
                    " (Phone): " + rs.getString("phone") + " (Email): " + rs.getString("email") +
                    " (Added in): " + rs.getString("created")
            )
            println()
        }
        println("")
        println("Press any key to back to menu")
        println("")
        readLine()



    }

    fun searchCustomerBycpf(searchBycpf: Int) {
        println("The result of your search...")
        println("")
        var findQuery = "SELECT * FROM customers WHERE cpf LIKE'%"+searchBycpf.toString().trim()+"%'"
        Class.forName(theClassName.theClassName)
        var conn: Connection = DriverManager.getConnection(theClassName.strConnessione)
        var ps: PreparedStatement = conn.prepareStatement(findQuery)
        var rs: ResultSet = ps.executeQuery()
        while (rs.next()) {

            println(" -> (ID): " + rs.getString("id") + " (First Name): " + rs.getString("firstName") +
                    " (Last Name): " + rs.getString("lastName") + " (CPF): " + rs.getString("cpf") +
                    " (Registro Geral (BR)): " + rs.getString("registroGeral") +
                    " (Social Security (USA)): " + rs.getString("socialSecurity") + "\n" +
                    " (Country): " + rs.getString("country") + " (City) : " + rs.getString("city") +
                    " (Address): " + rs.getString("address") + " (Zipcode): " + rs.getString("zipcode") +
                    " (Phone): " + rs.getString("phone") + " (Email): " + rs.getString("email") +
                    " (Added in): " + rs.getString("created")
            )
            println()
        }
        println("")
        println("Press any key to back to menu")
        println("")
        readLine()




    }

    fun searchCustomerBySocialSecurity(searchBySocialSecurity: String) {
        println("The result of your search...")
        println("")
        var findQuery = "SELECT * FROM customers WHERE socialSecurity LIKE'%"+searchBySocialSecurity.trim()+"%'"
        Class.forName(theClassName.theClassName)
        var conn: Connection = DriverManager.getConnection(theClassName.strConnessione)
        var ps: PreparedStatement = conn.prepareStatement(findQuery)
        var rs: ResultSet = ps.executeQuery()
        while (rs.next()) {

            println(" -> (ID): " + rs.getString("id") + " (First Name): " + rs.getString("firstName") +
                    " (Last Name): " + rs.getString("lastName") + " (CPF): " + rs.getString("cpf") +
                    " (Registro Geral (BR)): " + rs.getString("registroGeral") +
                    " (Social Security (USA)): " + rs.getString("socialSecurity") + "\n" +
                    " (Country): " + rs.getString("country") + " (City) : " + rs.getString("city") +
                    " (Address): " + rs.getString("address") + " (Zipcode): " + rs.getString("zipcode") +
                    " (Phone): " + rs.getString("phone") + " (Email): " + rs.getString("email") +
                    " (Added in): " + rs.getString("created")
            )
            println()
        }
        println("")
        println("Press any key to back to menu")
        println("")
        readLine()




    }

    fun searchCustomerByPhone(searchByPhone: Int) {
        println("The result of your search...")
        println("")
        var findQuery = "SELECT * FROM customers WHERE socialSecurity LIKE'%"+searchByPhone.toString().trim()+"%'"
        Class.forName(theClassName.theClassName)
        var conn: Connection = DriverManager.getConnection(theClassName.strConnessione)
        var ps: PreparedStatement = conn.prepareStatement(findQuery)
        var rs: ResultSet = ps.executeQuery()
        while (rs.next()) {

            println(" -> (ID): " + rs.getString("id") + " (First Name): " + rs.getString("firstName") +
                    " (Last Name): " + rs.getString("lastName") + " (CPF): " + rs.getString("cpf") +
                    " (Registro Geral (BR)): " + rs.getString("registroGeral") +
                    " (Social Security (USA)): " + rs.getString("socialSecurity") + "\n" +
                    " (Country): " + rs.getString("country") + " (City) : " + rs.getString("city") +
                    " (Address): " + rs.getString("address") + " (Zipcode): " + rs.getString("zipcode") +
                    " (Phone): " + rs.getString("phone") + " (Email): " + rs.getString("email") +
                    " (Added in): " + rs.getString("created")
            )
            println()
        }
        println("")
        println("Press any key to back to menu")
        println("")
        readLine()

    }

    fun updateCustomer(updateCustomerField: String, updateCustomerInfo: String, idCustomer: Int) {
        var queryUpdateCustomerInfo: String = "UPDATE customers set" + updateCustomerField.trim() + "='" + updateCustomerInfo.trim() + "' WHERE id='" + idCustomer.toString().trim() + "'"
        Class.forName(theClassName.theClassName)
        var conn: Connection = DriverManager.getConnection(theClassName.strConnessione)
        var psDelete: PreparedStatement = conn.prepareStatement(queryUpdateCustomerInfo)
        psDelete.execute()

    }


}//End of the Customer Class







fun main(args: Array<String>) {

}