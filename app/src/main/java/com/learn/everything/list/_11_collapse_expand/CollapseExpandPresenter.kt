package com.learn.everything.list._11_collapse_expand

class CollapseExpandPresenter(
    private val view: CollapseExpandView
) {
    private val initialList = listOf(
        PersonListItem.Person("0", "Cartman"),
        PersonListItem.Person("1", "Stan"),
        PersonListItem.Person("2", "Kyle"),
        PersonListItem.Person("3", "Kenny"),
        PersonListItem.Person("4", "Gerald"),
        PersonListItem.Person("5", "Randy"),
        PersonListItem.Person("6", "Butters"),
        PersonListItem.Person("7", "Ike"),
        PersonListItem.Person("8", "Wendy"),
        PersonListItem.Person("9", "Ms. Chokesondick"),
        PersonListItem.Person("10", "Mackey"),
        PersonListItem.Person("11", "PC principal"),
        PersonListItem.Person("12", "Jimmy"),
        PersonListItem.Person("13", "Timmy"),
        PersonListItem.Person("14", "Garrison"),
        PersonListItem.Person("15", "Mr. Slave"),
        PersonListItem.Person("16", "Chef"),
        PersonListItem.Person("17", "Scott Tenorman"),
        PersonListItem.Person("18", "Craig")
    )

    // TODO maybe better name?
    private val groupedList = mutableListOf<Pair<PersonListItem.Header, List<PersonListItem.Person>>>()

    private val personList = mutableListOf<Pair<PersonListItem.Header, List<PersonListItem.Person>>>()

    fun onViewCreated() {
        val list = initialList.sortedBy { it.name }
            .groupBy { person -> person.name[0].toString() }
            .map { entry -> PersonListItem.Header(entry.key, true) to entry.value }
        groupedList.addAll(list)
        personList.addAll(groupedList)

        setPersonList()
    }

    fun onHeaderClick(header: PersonListItem.Header) {
        val newHeader = header.copy(isExpanded = !header.isExpanded)
        val headerIndex = personList.indexOfFirst { it.first == header }
        val newList = if (newHeader.isExpanded) {
            personList[headerIndex].second.takeIf { it.isNotEmpty() }
                ?: groupedList.first { it.first == newHeader }.second
        } else emptyList()
        personList[headerIndex] = newHeader to newList

        setPersonList()
    }

    private fun setPersonList() {
        view.setPersonList(personList.flatMap { item ->
            listOf(item.first) + item.second
        })
    }
}