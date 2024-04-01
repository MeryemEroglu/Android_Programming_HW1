package com.example.shoppinglist

open class Item(name: String, price: Double){
    val name: String
    val price: Double

    init {
        this.name = name
        this.price = price
    }
}
class Food(name: String, price: Double, weight: String) : Item(name, price)
{
    val weight: String
    init {
        this.weight = weight
    }
}
class Cloth(name: String, price: Double, type: String) : Item(name, price){
    val type: String
    init {
        this.type = type
    }
}

class ShoppingList{
    val itemList = mutableListOf<Item>()

    fun addItem(){
        println("Enter the item type you want to add(1 for Food, 2 for Cloth) : ")
        println("1: Food")
        println("2: Cloth")
        val choice = readLine()?.toIntOrNull()

        if (choice == 1) {
            println("Enter the item name you want to add : ")
            val name:String = readLine() ?: ""
            var price: Double = 0.0
            while (true) {
                println("Enter the item price you want to add :")
                price = readLine()?.toDoubleOrNull() ?: 0.0
                if (price <= 0.0) {
                    println("Invalid price! Please enter a valid price.")
                } else {
                    break
                }
            }
            println("Enter the food weight : ")
            val weight:String = readLine() ?: ""
            itemList.add(Food(name, price, weight))
            println("${name} is added successfully!")
        } else if (choice == 2) {
            println("Enter the item name you want to add : ")
            val name = readLine() ?: ""
            var price: Double = 0.0
            while (true) {
                println("Enter the item price you want to add :")
                price = readLine()?.toDoubleOrNull() ?: 0.0
                if (price <= 0.0) {
                    println("Invalid price! Please enter a valid price.")
                } else {
                    break
                }
            }
            println("Enter the item type you want to add :")
            val type = readLine() ?: ""
            itemList.add(Cloth(name, price, type))
            println("${name} is added successfully!")
        } else {
            println("Invalid choice!")
        }
    }

    fun displayItems(){
        if (itemList.isNotEmpty()) {
            println("Your shopping list:")
            for (i in itemList.indices) {
                val item = itemList[i]
                if (item is Food) {
                    println("${i + 1}. ${item.name} ${item.price}\$ ${item.weight}kg ") }
                else if(item is Cloth){
                    println("${i + 1}. ${item.name} ${item.price}\$ ${item.type} ")
                }
            }
        } else {
            println("Your shopping list is empty.")
        }
    }
    fun deleteItem(){
        if (itemList.isEmpty()) {
            println("No items to delete.")
            return
        }
        displayItems()

        print("Enter the item number you want to delete : ")
        val index = readLine()?.toIntOrNull()

        if (index == null || index < 0 || index > itemList.size) {
            println("Invalid index!")
            return
        }
        val deletedItem = itemList.removeAt(index - 1)
        println("${deletedItem.name} is deleted successfully.")
    }
}


fun main(){

    val shoppingList = ShoppingList()
    while (true) {

        println("Make your choice : (1-2-3-4)")
        println("1. Add Item")
        println("2. Display Item")
        println("3. Delete Item")
        println("4. Exit")
        val choice = readLine()?.toIntOrNull()


            if (choice == 1) {
                shoppingList.addItem()
            } else if (choice == 2) {
                shoppingList.displayItems()
            } else if (choice == 3) {
                shoppingList.deleteItem()
            } else if (choice == 4) {
                println("Exiting...")
                return
            } else {
                println("Invalid choice! Please enter a number between 1 and 4.")
            }

    }
}