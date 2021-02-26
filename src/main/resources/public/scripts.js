$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: "http://localhost:8080/addressBook/0"
    }).then(function (data) {
        if (data) {
            $('.addressbook').append(data.name);
        }
    });

    $.ajax({
        type: 'GET',
        url: "http://localhost:8080/buds"
    }).then(function (data) {
        for (i = 0; i < data._embedded.buds.length; i++) {
            $('.Buddies').append(" Name: " + data._embedded.buds[i].name + " | ").append(" Phone Number: " + data._embedded.buds[i].phoneNumber + " | ").append(" Address: " + data._embedded.buds[i].address).append("<br>");
        }
    });
});




