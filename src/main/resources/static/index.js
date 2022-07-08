const state = {}

// document.getElementById("myName").setAttribute('value', 'Hello world') 
window.onload = () => {
    // const queryString = window.location.search;
    // console.log(queryString);
    // urlParams = new URLSearchParams(queryString) 
    // console.log("name is", urlParams.get("name"))
    // get mimename from url
    // call server and get mime data with name
    // populate data
    // document.getElementById("firstName").value = "Hello"
    getInitialData()

    
}

var phoneBlurHandler = () => {
    const phoneTypes = [
        "workPhone",
        "homePhone",
        "mobilePhone",
        "otherPhone",
        "faxPhone",
    ]
    phoneTypes.forEach(type => {
        var checked = document.getElementById(type+'Type').checked
        text = document.getElementById(type)
        text.disabled = !checked
        if(checked) {
            text.focus()
        }
    })
}

var getInitialData = () => {
    fetch("http://localhost:8080/api/roles")
    .then(response => {
        if(!response.ok) {
            alert("Unable to fetch roles")
        }
        else {
            return response.json()
        }
    })
    .then(data => {
        console.log(data)
        createBoxes("roles", data)
    });
    fetch("http://localhost:8080/api/orgs")
    .then(response => {
        if(!response.ok) {
            alert("Unable to fetch orgs")
        }
        else {
            return response.json()
        }
    })
    .then(data => {
        console.log(data)
        createBoxes("orgs", data)
    });
    fetch("http://localhost:8080/api/events")
    .then(response => {
        if(!response.ok) {
            alert("Unable to fetch events")
        }
        else {
            return response.json()
        }
    })
    .then(data => {
        console.log(data)
        createBoxes("events", data)
    });
    fetch("http://localhost:8080/api/issues")
    .then(response => {
        if(!response.ok) {
            alert("Unable to fetch issues")
        }
        else {
            return response.json()
        }
    })
    .then(data => {
        console.log(data)
        createBoxes("issues", data)
    });
}


var createBoxes = (type, data) => {
    data.forEach(dat => {
        const checkboxId = type + '-' + dat.id
        const checkbox = document.createElement("input")
        checkbox.setAttribute('type', 'checkbox')
        checkbox.setAttribute('name', 'roles')
        checkbox.setAttribute('id', checkboxId)

        const label = document.createElement("label")
        label.setAttribute('for', checkboxId)
        label.innerHTML = dat.name

        const item = document.createElement("span")
        item.className = "item ditem"
        item.appendChild(checkbox)
        item.appendChild(label)

        document.getElementById(type + "-field").appendChild(item)
    })
}