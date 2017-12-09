/*
Author: Hecton P.Domingos
Description: The Hecton's Enterprise Resource Planning (a.k.a Therp) is a personal project in Kotlin
created by the Author to apply what he learned in the Kotlin programming language. JUST IT.

 */




fun main(args: Array<String>) {

    var exitProgram = false

    //start a while loop to show the program menu
    do{

        println("################ The Hecton's Enterprise Resource Planning Menu ################ ")
        println()
        println("___Main Menu -> Choose one of the options bellow_____")
        println()
        println("1 - Customers")
        println("2 - Products")
        println("3 - Stock")
        println("4 - Sell")
        println("0 - Exit")
        println()
        println("##################################################################################")
        var op = readLine()!!.toInt()

        when(op){

            //Option 1
            1 ->{

                var exitOp1 = false
                do {
                    println("################ The Hecton's Enterprise Resource Planning Menu ################ ")
                    println()
                    println("___Menu -> Customers _____")
                    println()
                    println("1 - Search - Find a specific costumer")
                    println("2 - Add - Add a new client on the database")
                    println("3 - Modify - Modify the client already in the database")
                    println("4 - List all users from database ")
                    println("0 - Exit")
                    println()
                    println("##################################################################################")
                    var op1 = readLine()!!.toInt()
                    var add = Customers()
                    when(op1){


                        1 ->{

                        }

                        2 ->{
                            println("################ The Hecton's Enterprise Resource Planning Menu ################ ")
                            println()
                            println("___Menu -> Customers - > Add New Customer_____")
                            println()

                            println()
                            println("Customer's first name: ")
                            var insertFirstName = readLine()!!.toString().trim()
                            println("Customer's last name: ")
                            var insertLastName: String = readLine()!!.toString().trim()
                            println("Which nacionality is the customer?")
                            println("1: Brasilian  | 2: American")
                            var insertNacionality = readLine()!!.toInt()

                            var insertCpf = 0
                            var insertRegistroGeral = "0"
                            var insertCountry = ""
                            var insertSocialSecurity = ""
                            if (insertNacionality == 1){
                                println("Customer's CPF: ")
                                 insertCpf = readLine()!!.toInt()
                                println("Customer's Registro Geral:")
                                insertRegistroGeral = readLine()!!.toString().trim()
                                insertCountry = "Brasil"
                            }else{
                                insertCountry = "EUA"
                                insertCpf = 0
                                println("Insert Social Security number:")
                                insertSocialSecurity = readLine().toString().trim()
                            }
                            println("Customer's current city: ")
                            var insertCity = readLine()!!.toString().trim()
                            println("Customer's Full Address:")
                            var insertAddress = readLine()!!.toString().trim()
                            println("Customer's Zipcode: ")
                            var insertZipcode = readLine()!!.toInt()
                            println("Customer's phone nunmber: ")
                            var insertPhone = readLine()!!.toInt()
                            println("Customer's Email: ")
                            var insertEmail = readLine()!!.toString().trim()

                            add.addCustomer(insertFirstName, insertLastName, insertCpf, insertRegistroGeral,insertSocialSecurity , insertCountry,insertCity, insertAddress, insertZipcode, insertPhone, insertEmail)

                            //addCustomers(insertFirstName, insertLastName, insertCpf, insertRegistroGeral,insertSocialSecurity , insertCountry,insertCity, insertAddress, insertZipcode, insertPhone, insertEmail )
                        }
                        3 ->{
                            println("################ The Hecton's Enterprise Resource Planning Menu ################ ")
                            println()
                            println("___Menu -> Customers -> Modify the Customer Information _____")
                            println()
                            println("Which customer do you want modify the information? ")
                            println("Do you search the user or list all?")
                            println("1 search || 2 list all")
                            var whichCustomer = readLine()!!.toInt()
                            if (whichCustomer == 1){
                                println()
                                println("Search using: 1 name | 2 last name | 3 cpf | 4 social security | 5 phone | 6 email")
                                var searchBy:Int = readLine()!!.toInt()
                                if (searchBy == 1){
                                    println("What is the customer's first name? ")
                                    var searchByName = readLine()!!.toString()
                                    add.searchCustomerByFirstName(searchByName)
                                    println()
                                }else if(searchBy == 2){
                                    println("What is the customer's Last Name? ")
                                    var searchByLName = readLine()!!.toString()
                                    add.searchCustomerByLastName(searchByLName)
                                    println()

                                }else if (searchBy == 3){
                                    println("What is the customer's cpf ")
                                    var searchBycpf = readLine()!!.toInt()
                                    add.searchCustomerBycpf(searchBycpf)
                                    println()
                                }else if (searchBy == 4){
                                    println("What is the customer's Social Security? ")
                                    var searchBySocialSecurity = readLine()!!.toString()
                                    add.searchCustomerBySocialSecurity(searchBySocialSecurity)
                                    println()

                                }else if (searchBy == 5){
                                    println("What is the customer's phone? ")
                                    var searchByphone = readLine()!!.toString().trim().toInt()
                                    add.searchCustomerByPhone(searchByphone)
                                    println()

                                }else if (searchBy == 6){
                                    println("What is the customer's email? ")
                                    var searchByEmail = readLine()!!.toString().trim()
                                    add.searchCustomerByEmail(searchByEmail)
                                    println()
                                }else {
                                    println("Wrong option number! Start again!")
                                }
                            }else if (whichCustomer == 2){

                            }else{
                                println("Wrong option, choose 1 or 2")
                            }

                            println()
                            println("Type the customer's ID to modify the information:  ")
                            var customerID = readLine()!!.toInt()
                            println()
                            println("Which field do you want modify? Type the number ")
                            println()
                            println("1 Name | 2 Last Name | 3 CPF | 4 RG | 5 Social Security | 6 Country | 7 City " )
                            println("8 Address | 9 Zipcode | 10 Phone | 11 Email ")
                            var fieldToModify = readLine()!!.toInt()

                            var field: String = ""

                            if (fieldToModify == 1){
                                field = "name"
                            }else if(fieldToModify == 2){
                                field = "lastName"
                            }else if(fieldToModify == 3){
                                field = "cpf"
                            }else if(fieldToModify == 4){
                                field = "rg"
                            }
                            else if(fieldToModify == 5){
                                field = "socialSecurity"
                            }
                            else if(fieldToModify == 6){
                                field = "country"
                            }
                            else if(fieldToModify == 7){
                                field = "city"
                            }
                            else if(fieldToModify == 8){
                                field = "address"
                            }
                            else if(fieldToModify == 9){
                                field = "zipcode"
                            }
                            else if(fieldToModify == 10){
                                field = "phone"
                            }
                            else if(fieldToModify == 11){
                                field = "email"
                            }else {
                                println()
                                println("Wrong field number!")

                            }
                            println()
                            println("Your chose the ${field} field. Which value do you want to put in? ")
                            var fieldValue = readLine()

                            if (field == "cpf" || field == "zipcode" || field == "phone" ){

                                add.updateCustomerIntFields(field, fieldValue.toString().trim().toInt(), customerID)
                            }else
                            {
                                add.updateCustomerStringField(field, fieldValue.toString(), customerID)
                            }







                        }
                        4 ->{
                            add.listCustomers()
                        }
                        0 ->{
                            exitOp1 = true

                        }


                    } //End of the when opt1




                }while (!exitOp1)
                //End of the option 1



            }

            //Option 2 MAIN Menu
            2 ->{

            }

            //Option 3 MAIN Menu
            3 ->{

            }

            //Option 4 MAIN Menu
            4 -> {

            }



            //Exit Program
            0 ->{
              exitProgram = true
                println("Bye!")
            }
        }








    //End of THERP Program
    }while(!exitProgram)


}