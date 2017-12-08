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