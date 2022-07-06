// document.getElementById("myName").setAttribute('value', 'Hello world') 
window.onload = () => {
    // const queryString = window.location.search;
    // console.log(queryString);
    // urlParams = new URLSearchParams(queryString) 
    // console.log("name is", urlParams.get("name"))
    // get mimename from url
    // call server and get mime data with name
    // populate data
    document.getElementById("firstName").value = "Hello"

    
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
        document.getElementById(type).disabled = !document.getElementById(type+'Type').checked
    })
}