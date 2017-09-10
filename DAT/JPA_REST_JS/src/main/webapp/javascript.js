PersonsRefresh();

document.getElementById("PersonsRefresh").addEventListener("click", function ()
{
    PersonsRefresh();
});

document.getElementById("PersonAdd").addEventListener("click", function ()
{
    PersonAdd();
});

document.getElementById("PersonEdit").addEventListener("click", function ()
{
    PersonEdit();
    PersonsRefresh();
});

document.getElementById("PersonDelete").addEventListener("click", function ()
{
    PersonDelete();
});

function PersonsRefresh()
{
    fetch("api/person/all", {method: "get"})
            .then(function (response) {
                if (!response.ok)
                {
                    var error = new Error();
                    error.response = response;
                    throw error;
                }
                return response.json();
            })
            .then(function (json) {
                document.getElementById("TablePersonsBody").innerHTML = "";

                var rows = "";

                for (var i in json)
                {
                    rows += '<tr>';
                    rows += '<td>' + json[i].id + '</td>';
                    rows += '<td>' + json[i].firstName + '</td>';
                    rows += '<td>' + json[i].lastName + '</td>';
                    rows += '<td>' + json[i].phoneNumber + '</td>';
                    rows += '<td><input type="button" onclick="PersonDeleteID(' + json[i].id + ')" value="Delete" /></td>';
                    rows += '<td><a href="#" onclick="PersonDeleteID(' + json[i].id + ')">Delete</a></td>';
                    rows += '</tr>';
                }

                document.getElementById("TablePersonsBody").innerHTML = rows;
            })
            .catch(function (error) {
                error.response.json().then(function (json) {
                    alert(json.description);
                    
                    document.getElementById("TablePersonsBody").innerHTML = "";
                });
            });
}

function PersonEdit()
{
    var person = {
        id: document.getElementById("PersonID").value,
        firstName: document.getElementById("PersonFirstName").value,
        lastName: document.getElementById("PersonLastName").value,
        phoneNumber: Number(document.getElementById("PersonPhoneNumber").value)
    };

    fetch("api/person", {
        method: "put",
        body: JSON.stringify(person),
        headers: new Headers({'content-type': 'application/json'})
    })
            .then(function (response) {
                if (!response.ok)
                {
                    var error = new Error();
                    error.response = response;
                    throw error;
                }
                return response.json();
            })
            .then(function (json) {
                alert("Person edited!");
        
                PersonsRefresh();
            })
            .catch(function (error) {
                alert("Person not edited!");
            });
}

function PersonAdd()
{
    var person = {
        firstName: document.getElementById("PersonFirstName").value,
        lastName: document.getElementById("PersonLastName").value,
        phoneNumber: Number(document.getElementById("PersonPhoneNumber").value)
    };

    fetch("api/person", {
        method: "post",
        body: JSON.stringify(person),
        headers: new Headers({'content-type': 'application/json'})
    })
            .then(function (response) {
                if (!response.ok)
                {
                    var error = new Error();
                    error.response = response;
                    throw error;
                }
                return response.json();
            })
            .then(function (json) {
                alert("Person added!");
        
                document.getElementById("TablePersonsBody").innerHTML += "<tr><td>New</td><td>" + document.getElementById("PersonFirstName").value + "</td><td>" + document.getElementById("PersonLastName").value + "</td><td>" + document.getElementById("PersonPhoneNumber").value + "</td></tr>";
            })
            .catch(function (error) {
                alert("Person not added!");
            });
}

function PersonDelete()
{
    PersonDeleteID(document.getElementById("PersonID").value);
}

function PersonDeleteID(id)
{
    fetch("api/person/" + id, {
        method: "delete",
        headers: new Headers({'content-type': 'application/json'})
    })
            .then(function (response) {
                if (!response.ok)
                {
                    var error = new Error();
                    error.response = response;
                    throw error;
                }
                return response.json();
            })
            .then(function (json) {
                alert("Person deleted!");
        
                PersonsRefresh();
            })
            .catch(function (error) {
                alert("Person not deleted!");
            });
}