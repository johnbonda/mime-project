const stateData = {
    roles: null,
    queryKeys: [
        "lastName",
        "firstName",
        "jobTitle",
        "company",
        "address",
        "city",
        "province",
        "country",
        "area",
        "phone",
        "phoneType",
        "email",
        "url",
        "notes",
    ],
}

const roleSelectHandler = (index) => {
    const rolesSelect = document.getElementById("roles-select")
    const selectedRolesSpan = document.getElementById("selected-roles")
    const selectedItem = rolesSelect.options[index]

    console.log("Roles Select", selectedItem.outerText, selectedItem.value)

    if(selectedItem.value != "none" && !getSelectedRoles().includes(selectedItem.value)) {
        const selectedRole = document.createElement("label")
        selectedRole.className = "clickable"
        selectedRole.setAttribute("value", selectedItem.value)
        selectedRole.innerHTML =selectedItem.outerText
        selectedRole.setAttribute("onclick", "this.remove()")

        selectedRolesSpan.appendChild(selectedRole)
    }

    rolesSelect.selectedIndex = 0
}

const getSelectedRoles = () => {
    const selectedRolesSpan = document.getElementById("selected-roles")
    const selectItems = Array.from(selectedRolesSpan.childNodes)
    return selectItems.map(item => item.getAttribute('value'))
}

const loadRoleOptions = () => {
    fetch("/api/roles")
    .then(response => {
        if(!response.ok) {
            alert("Unable to fetch roles")
        }
        else {
            return response.json()
        }
    })
    .then(data => {
        const rolesSelect = document.getElementById("roles-select")
        stateData.roles = data
        stateData.roles.forEach(role => {
            const option = document.createElement("option")
            option.setAttribute('value', role.id)
            option.innerHTML = role.name
            rolesSelect.appendChild(option)
        })
    })
}

const addQuery = () => {
    console.log("Adding query")
    const queriesDiv = document.getElementById("queries-area")

    const queryDiv = document.createElement("div")
    queryDiv.className = "query"
    queryDiv.id = `queryDiv-${Date.now()}`
    queriesDiv.appendChild(queryDiv)

    const keySelect = document.createElement("select")
    queryDiv.appendChild(keySelect)
    stateData.queryKeys.forEach(key => {
        const option = document.createElement("option")
        option.setAttribute('value', key)
        option.innerHTML = key
        keySelect.appendChild(option)
    })

    const textBox = document.createElement("input")
    textBox.setAttribute("type", "text")
    queryDiv.appendChild(textBox)

    const deleteButton = document.createElement("button")
    deleteButton.setAttribute("type", "button")
    deleteButton.setAttribute("onclick", `document.getElementById("${queryDiv.id}").remove()`)
    deleteButton.innerHTML = "X"
    deleteButton.className = "delete-button"
    queryDiv.appendChild(deleteButton)

}

const submitHandler = (event) => {
    event.preventDefault()
    const request = {
        queries: {},
        roles: []
    }

    const queryDivs = Array.from(document.getElementsByClassName("query"))
    queryDivs.forEach(queryDiv => {
        request.queries[queryDiv.childNodes[0].value] = `%${queryDiv.childNodes[1].value}%`
    })
    request.roles = getSelectedRoles().map(e => parseInt(e))
    
    console.log("Searching", request)

    fetch("/api/getMimesMatching", {
        body: JSON.stringify(request),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST"
    })
    .then(resp => {
        if(!resp.ok) {
            alert("Error filtering")
        }
        else {
            return resp.json()
        }
    })
    .then(showMimeResults)
}

const clearTable = () => {
    const rows = Array.from(document.getElementsByClassName("filter-result"))
    rows.forEach(row => row.remove())
}

const showMimeResults = (results) => {
    clearTable()
    console.log("Results", results)
    const table = document.getElementById("filter-results")
    results.forEach(result => {
        const tr = document.createElement("tr")
        tr.className = "filter-result"
        table.appendChild(tr)
        const td_id = document.createElement("td")
        const td_lastName = document.createElement("td")
        const lastNameAnchor = document.createElement("a")
        lastNameAnchor.href = `/user.html?lastName=${result.lastName}`
        lastNameAnchor.innerHTML = result.lastName

        tr.appendChild(td_id)
        tr.appendChild(td_lastName)

        td_id.innerHTML = result.id
        td_lastName.appendChild(lastNameAnchor)
    })
}

window.onload = () => {
    console.log("Page loaded")    
    document.getElementById("filter-form").addEventListener("submit", submitHandler)

    loadRoleOptions()
}