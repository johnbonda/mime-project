const state = {}

// document.getElementById("myName").setAttribute('value', 'Hello world') 
window.onload = () => {
    getInitialData()

    document.getElementById("mime-form").addEventListener("submit", submitHandler)

}

const parseUrl = () => {
    const queryString = window.location.search;
    console.log(queryString);
    const urlParams = new URLSearchParams(queryString) 
    const lastName = urlParams.get("lastName")
    console.log("name is", lastName)
    return lastName
}

const phoneBlurHandler = () => {
    const phoneTypes = [
        "workPhone",
        "homePhone",
        "mobilePhone",
        "otherPhone",
        "faxPhone",
    ]
    phoneTypes.forEach(type => {
        const checked = document.getElementById(type+'Type').checked
        const text = document.getElementById(type)
        text.disabled = !checked
        if(checked) {
            text.focus()
        }
    })
}

const getInitialData = () => {
    let tasks = []
    tasks.push(fetch("api/roles")
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
    }))
    tasks.push(fetch("api/orgs")
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
    }))
    tasks.push(fetch("api/events")
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
    }))
    tasks.push(fetch("api/issues")
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
    }))


    const lastName = parseUrl() 
    if(lastName) {
        Promise.all(tasks)
        .then(() => {
            console.log(`Loading ${lastName} data`)
            loadMimeData(lastName)
        })
    }
}


const createBoxes = (type, data) => {
    data.forEach(dat => {
        const checkboxId = type + '-' + dat.id
        const checkbox = document.createElement("input")
        checkbox.setAttribute('type', 'checkbox')
        checkbox.setAttribute('name', type)
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


const submitHandler = (event) => {
    event.preventDefault()
    const body = {
        firstName: document.getElementById('firstName').value,
        lastName: document.getElementById('lastName').value,
        jobTitle: document.getElementById('jobTitle').value,
        company: document.getElementById('company').value,
        address: document.getElementById('address').value,
        city: document.getElementById('city').value,
        province: document.getElementById('province').value,
        postalCode: parseInt(document.getElementById('postalCode').value),
        country: document.getElementById('country').value,
        area: document.getElementById('area').value,
        phone: {},
        email: document.getElementById('email').value,
        url: document.getElementById('url').value,
        notes: document.getElementById('notes').value,
        member: document.getElementById('member').checked,
        join: document.getElementById('join').value,
        leave: document.getElementById('leave').value,
        infoWanted: getSelectedByName("infoWanted").map(e => e.id),
        communicate: getSelectedByName("communicate").map(e => e.id.replace('com-', '')).find(_e => true),
        traineeLevels: getSelectedByName("traineeLevels").map(e => e.id),
        associations: getSelectedByName("associations").map(e => e.id),
        roles: getSelectedByName("roles").map(e => parseInt(e.id.replace('roles-', ''))),
        orgs: getSelectedByName("orgs").map(e => parseInt(e.id.replace('orgs-', ''))),
        events: getSelectedByName("events").map(e => parseInt(e.id.replace('events-', ''))),
        issues: getSelectedByName("issues").map(e => parseInt(e.id.replace('issues-', ''))),
        tflOrganizer: document.getElementById('tflOrganizer').checked,
        contractDate: document.getElementById('contractDate').value,
        tflDates: document.getElementById('tflDates').value,
        tflFocus: document.getElementById('tflFocus').value,
        tflFee: document.getElementById('tflFee').value,
        facilitator: document.getElementById('facilitator').value,
        accomodation: document.getElementById('accomodation').value,
        counsellor: document.getElementById('counsellor').checked,
        status: getSelectedByName("status").map(e => e.id.replace('status-', '')).find(_e => true),
    }

    const res = getSelectedByName("phone-type")[0].id
    body.phone.type = res
    body.phone.value = document.getElementById(res.replace("Type", "")).value

    console.log(body)

    fetch("api/mime", {
        body: JSON.stringify(body),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST"
    })
    .then(resp => {
        if(resp.ok) {
            alert("Successful saved data")
        }
        else {
            alert("Error saving data")
        }
    })

}

const getSelectedByName = (name) => {
    const elements = Array.from(document.getElementsByName(name))
    return elements.filter(element => element.checked)
}


const loadMimeData = lastName => {
    fetch(`api/mime?lastName=${lastName}`)
    .then(response => {
        if(!response.ok) {
            alert("Unable to fetch mimedata")
        }
        else {
            return response.json()
        }
    })
    .then(data => {
        let mime = data
        let mimeDetails = data['mimeDetails']

        document.getElementById('firstName').value = mime['firstName']
        document.getElementById('lastName').value = mime['lastName']
        document.getElementById('jobTitle').value = mime['jobTitle']
        document.getElementById('company').value = mime['company']
        document.getElementById('address').value = mime['address']
        document.getElementById('city').value = mime['city']
        document.getElementById('province').value = mime['province']
        document.getElementById('postalCode').value = mime['postalCode']
        document.getElementById('country').value = mime['country']
        document.getElementById('area').value = mime['area']

        const phoneType = document.getElementById(mime['phoneType'])
        phoneType.checked = true
        document.getElementById(mime['phoneType'].replace("Type", '')).value = mime['phone']
        phoneType.click()

        document.getElementById('email').value = mime['email']
        document.getElementById('url').value = mime['url']
        document.getElementById('notes').value = mime['notes']
        document.getElementById('member').checked = mimeDetails['member']
        document.getElementById('join').value = mimeDetails['joinDate']
        document.getElementById('leave').value = mimeDetails['leaveDate']

        tickBoxes("", mimeDetails['infoWanted'])
        document.getElementById('com-' + mimeDetails['communicate']).checked = true
        tickBoxes("", mimeDetails['traineeLevels'])
        tickBoxes("", mimeDetails['associations'])
        tickBoxes("roles-", mimeDetails['roles'].map(role => role['id']))
        tickBoxes("orgs-", mimeDetails['orgs'].map(org => org['id']))
        tickBoxes("events-", mimeDetails['events'].map(event => event['id']))
        tickBoxes("issues-", mimeDetails['issues'].map(issue => issue['id']))
        document.getElementById('tflOrganizer').checked = mimeDetails['tflOrganizer']
        document.getElementById('contractDate').value = mimeDetails['contractDate']
        document.getElementById('tflDates').value = mimeDetails['tflDates']
        document.getElementById('tflFocus').value = mimeDetails['tflFocus']
        document.getElementById('tflFee').value = mimeDetails['tflFee']
        document.getElementById('facilitator').value = mimeDetails['facilitator']
        document.getElementById('accomodation').value = mimeDetails['accomodation']
        document.getElementById('counsellor').checked = mimeDetails['counsellor']
        document.getElementById('status-' + mimeDetails['status']).checked = true
        
        console.log('loadedData')
    })


}

const tickBoxes = (type, list = []) => {
    list.forEach(item => {
        document.getElementById(type+item).checked = true
    })
}