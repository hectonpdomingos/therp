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
            println()
            println(" Success! The customer was added!")
            println()
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



    fun searchCustomerByEmail(searchByEmail: String) {
        println("The result of your search...")
        println("")
        var findQuery = "SELECT * FROM customers WHERE email LIKE'%"+searchByEmail.trim()+"%'"
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
        var findQuery = "SELECT * FROM customers WHERE cpf LIKE'%"+searchBycpf.toString().trim().toInt()+"%'"
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

    fun updateCustomerStringField(updateCustomerField: String, updateCustomerInfo: String, idCustomer: Int) {

        var queryUpdateCustomerInfo: String = "UPDATE customers set" + updateCustomerField.trim() + "='" + updateCustomerInfo.trim() + "' WHERE id='" + idCustomer.toString().trim().toInt() + "'"
        Class.forName(theClassName.theClassName)
        var conn: Connection = DriverManager.getConnection(theClassName.strConnessione)
        var psUpdate: PreparedStatement = conn.prepareStatement(queryUpdateCustomerInfo)
        psUpdate.execute()
        println("Customer Updated!")


    }
    fun updateCustomerIntFields(updateCustomerField: String, updateCustomerInfo: Int, idCustomer: Int) {
        var queryUpdateCustomerInfo: String = "UPDATE customers set" + updateCustomerField.trim() + "='" + updateCustomerInfo.toString().trim().toInt() + "' WHERE id='" + idCustomer.toString().trim().toInt() + "'"
        Class.forName(theClassName.theClassName)
        var conn: Connection = DriverManager.getConnection(theClassName.strConnessione)
        var psUpdate: PreparedStatement = conn.prepareStatement(queryUpdateCustomerInfo)
        psUpdate.execute()

        println("Customer Updated!")

    }



    fun searchEngine(){
        var add = Customers()

        println("1 search || 2 list all")
        var whichCustomer = readLine()!!.toInt()
        if (whichCustomer == 1) {
            println()
            println("Search using: 1 name | 2 last name | 3 cpf | 4 social security | 5 phone | 6 email")
            var searchBy: Int = readLine()!!.toInt()
            if (searchBy == 1) {
                println("What is the customer's first name? ")
                var searchByName = readLine()!!.toString()
                add.searchCustomerByFirstName(searchByName)
                println()
            } else if (searchBy == 2) {
                println("What is the customer's Last Name? ")
                var searchByLName = readLine()!!.toString()
                add.searchCustomerByLastName(searchByLName)
                println()

            } else if (searchBy == 3) {
                println("What is the customer's cpf ")
                var searchBycpf = readLine()!!.toInt()
                add.searchCustomerBycpf(searchBycpf)
                println()
            } else if (searchBy == 4) {
                println("What is the customer's Social Security? ")
                var searchBySocialSecurity = readLine()!!.toString()
                add.searchCustomerBySocialSecurity(searchBySocialSecurity)
                println()

            } else if (searchBy == 5) {
                println("What is the customer's phone? ")
                var searchByphone = readLine()!!.toString().trim().toInt()
                add.searchCustomerByPhone(searchByphone)
                println()

            } else if (searchBy == 6) {
                println("What is the customer's email? ")
                var searchByEmail = readLine()!!.toString().trim()
                add.searchCustomerByEmail(searchByEmail)
                println()
            } else {
                println("Wrong option number! Start again!")
            }
        }else if(whichCustomer == 2){
            add.listCustomers()
        }

    }

}//End of the Customer Class









fun main(args: Array<String>) {

}