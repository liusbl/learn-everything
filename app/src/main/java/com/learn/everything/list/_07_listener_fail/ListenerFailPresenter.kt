package com.learn.everything.list._07_listener_fail

import timber.log.Timber

class ListenerFailPresenter(
    private val view: ListenerFailView
) {
    private val itemToRemove = Person("2", "Kyle")
    private val itemToMove = Person("4", "Gerald")
    private val personList = mutableListOf(
        Person("0", "Cartman"),
        Person("1", "Stan"),
        itemToRemove,
        Person("3", "Kenny"),
        itemToMove,
        Person("5", "Randy"),
        Person("6", "Butters"),
        Person("7", "Ike"),
        Person("8", "Wendy"),
        Person("9", "Ms. Chokesondick"),
        Person("10", "Mackey"),
        Person("11", "PC principal"),
        Person("12", "Jimmy"),
        Person("13", "Timmy"),
        Person("14", "Garrison"),
        Person("15", "Mr. Slave"),
        Person("16", "Chef"),
        Person("17", "Scott Tenorman"),
        Person("18", "Craig")
    )
    private var modification = Modification.REMOVE

    fun onNextClick() {
        when (modification) {
            Modification.REMOVE -> {
                personList.remove(itemToRemove)
                modification =
                    Modification.INSERT
            }
            Modification.INSERT -> {
                personList.add(2, itemToRemove)
                modification =
                    Modification.MOVE
            }
            Modification.MOVE -> {
                if (personList[4] == itemToMove) {
                    personList.remove(itemToMove)
                    personList.add(7, itemToMove)
                } else {
                    personList.remove(itemToMove)
                    personList.add(4, itemToMove)
                }
                modification =
                    Modification.SWAP
            }
            Modification.SWAP -> {
                val item10 = personList[10]
                personList[10] = personList[11]
                personList[11] = item10
                modification =
                    Modification.REMOVE
            }
        }
        view.setPersonList(personList)
    }

    fun onBackClick() {
        modification = when (modification) {
            Modification.REMOVE -> Modification.SWAP
            Modification.INSERT -> Modification.REMOVE
            Modification.MOVE -> Modification.INSERT
            Modification.SWAP -> Modification.MOVE
        }

        when (modification) {
            Modification.REMOVE -> {
                personList.add(2, itemToRemove)
            }
            Modification.INSERT -> {
                personList.remove(itemToRemove)
            }
            Modification.MOVE -> {
                if (personList[4] == itemToMove) {
                    personList.remove(itemToMove)
                    personList.add(7, itemToMove)
                } else {
                    personList.remove(itemToMove)
                    personList.add(4, itemToMove)
                }
            }
            Modification.SWAP -> {
                val item10 = personList[10]
                personList[10] = personList[11]
                personList[11] = item10
            }
        }
        view.setPersonList(personList)
    }

    fun onPersonUpdated(person: Person) {
        Timber.d("Person updated: $person")
    }

    private enum class Modification {
        REMOVE, INSERT, MOVE, SWAP
    }
}