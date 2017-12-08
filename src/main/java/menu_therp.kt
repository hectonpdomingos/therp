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
                    println("4 - Disable the user from database ")
                    println("0 - Exit")
                    println()
                    println("##################################################################################")
                    var op1 = readLine()!!.toInt()

                    when(op1){


                        1 ->{

                        }

                        2 ->{

                            //  name, fullName, cpf, RG, Social Security, Country, City, Address, ZipCode, email, phone

                            addCustumers("Hecton", "Domingos",1111,"MG99999","mg89898989","Brazil","Manhu","RJRS",369000,841999999)

                        }
                        3 ->{

                        }
                        4 ->{

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