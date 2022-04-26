function searchByLogin() {
    var login = document.getElementById("search_field").value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
    var user = JSON.parse(this.responseText);
    var html = '<tr>\n' +
    '        <th>User id</th>\n' +
    '        <th>User name</th>\n' +
    '        <th>User login</th>\n' +
    '        <th>User klass</th>\n' +
    '        <th>User stag</th>\n' +
    '        <th>User zp</th>\n' +
    '        <th>Delete</th>\n' +
    '    </tr>';
    html = html + '<tr><td>' + user.id + '</td>\n' +
    '        <td>' + user.name + '</td>\n' +
    '        <td>' + user.login + '</td>\n' +
    '        <td>' + user.klass + '</td>' +
    '        <td>' + user.stag + '</td>' +
    '        <td>' + user.zp + '</td>' +
    '        <td><button onclick="deleteUser(' + user.id + ')">Delete</button></td></tr>';
    document.getElementById("usersList").innerHTML = html;
    }
    };
    xhttp.open("GET", "http://localhost:8090/users/findByLogin?login=" + login, true);
    xhttp.send();
}

function searchByNum() {
    var num = document.getElementById("search_field").value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
    var bus = JSON.parse(this.responseText);
    var html = '<tr>\n' +
    '        <th>Bus id</th>\n' +
    '        <th>Bus number</th>\n' +
    '        <th>Bus type</th>\n' +
    '        <th>Bus mest</th>\n' +
    '        <th>Delete</th>\n' +
    '    </tr>';
    html = html + '<tr><td>' + bus.id + '</td>\n' +
    '        <td>' + bus.num + '</td>\n' +
    '        <td>' + bus.type + '</td>\n' +
    '        <td>' + bus.mest + '</td>' +
    '        <td><button onclick="deleteBus(' + bus.id + ')">Delete</button></td></tr>';
    document.getElementById("busList").innerHTML = html;
    }
    };
    xhttp.open("GET", "http://localhost:8090/bus/findByNum?num=" + num, true);
    xhttp.send();
}

function searchByNumber() {
    let number = document.getElementById("search_field").value;
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var trip = JSON.parse(this.responseText);
            var html = '<tr>\n' +
            '        <th>Trip id</th>\n' +
            '        <th>Trip number</th>\n' +
            '        <th>Trip start time</th>\n' +
            '        <th>Trip end time</th>\n' +
            '        <th>Trip interval</th>\n' +
            '        <th>Trip protyaj</th>\n' +
            '        <th>Delete</th>\n' +
            '    </tr>';
            html = html + '<tr><td>' + trip.id + '</td>\n' +
            '        <td>' + trip.number + '</td>\n' +
            '        <td>' + trip.starttime + '</td>\n' +
            '        <td>' + trip.endtime + '</td>' +
            '        <td>' + trip.interval + '</td>' +
            '        <td>' + trip.protyaj + '</td>' +
            '        <td><button onclick="deleteTrip(' + trip.id + ')">Delete</button></td></tr>';
            document.getElementById("busList").innerHTML = html;
        }
    };
    xhttp.open("GET", "http://localhost:8090/trip/findByNumber?number=" + number, true);
    xhttp.send();
}

function deleteUser(userId) {
    let xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "http://localhost:8090/users/delete/" + userId, true);
    xhttp.send();
}

function deleteBus(busId) {
    let xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "http://localhost:8090/bus/delete/" + busId, true);
    xhttp.send();

}

function deleteTrip(tripId) {
    let xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "http://localhost:8090/trip/delete/" + tripId, true);
    xhttp.send();
    console.log("slovo")
}

function createUser() {
    let userName = document.getElementById("user_name").value;
    let userLogin = document.getElementById("user_login").value;
    let userKlass = document.getElementById("user_klass").value;
    let userStag = document.getElementById("user_stag").value;
    let userZp = document.getElementById("user_zp").value;

    let xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
    xmlhttp.open("POST", "http://localhost:8090/users/save");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({name: userName, login: userLogin, klass: userKlass, stag: userStag, zp: userZp}));

    loadUsers();
}

function createBus() {
    let busNum = document.getElementById("bus_num").value;
    let busType = document.getElementById("bus_type").value;
    let busMest = document.getElementById("bus_mest").value;

    let xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
    xmlhttp.open("POST", "http://localhost:8090/bus/save");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({num: busNum, type: busType, mest: busMest}));

   loadBus();
}

function createTrip() {
    var tripNum = document.getElementById("trip_number").value;
    var tripStarttime = document.getElementById("trip_starttime").value;
    var tripEndtime = document.getElementById("trip_endtime").value;
    var tripInterval = document.getElementById("trip_interval").value;
    var tripProtyaj = document.getElementById("trip_protyaj").value;
    var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
    xmlhttp.open("POST", "http://localhost:8090/trip/save");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({number: tripNum, starttime: tripStarttime, endtime: tripEndtime, interval: tripInterval, protyaj: tripProtyaj}));

    loadTrip();
}


function loadUsers() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var users = JSON.parse(this.responseText);
            var html = '<tr>\n' +
            '        <th>User id</th>\n' +
            '        <th>User name</th>\n' +
            '        <th>User login</th>\n' +
            '        <th>User klass</th>\n' +
            '        <th>User stag</th>\n' +
            '        <th>User zp</th>\n' +
            '        <th>Delete</th>\n' +
            '    </tr>';
            for (var i = 0; i < users.length; i++) {
                var user = users[i];
                console.log(user);
                html = html + '<tr><td>' + user.id + '</td>\n' +
                '        <td>' + user.name + '</td>\n' +
                '        <td>' + user.login + '</td>\n' +
                '        <td>' + user.klass + '</td>' +
                '        <td>' + user.stag + '</td>' +
                '        <td>' + user.zp + '</td>' +
                '        <td><button onclick="deleteUser(' + user.id + ')">Delete</button></td></tr>';
            }
            document.getElementById("usersList").innerHTML = html;
        }
    };
    xhttp.open("GET", "http://localhost:8090/users/findAll", true);
    xhttp.send();
}


function loadBus() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var buses = JSON.parse(this.responseText);
            var html = '<tr>\n' +
            '        <th>Bus id</th>\n' +
            '        <th>Bus number</th>\n' +
            '        <th>Bus type</th>\n' +
            '        <th>Bus mest</th>\n' +
            '        <th>Delete</th>\n' +
            '    </tr>';
            for (var i = 0; i < buses.length; i++) {
                var bus = buses[i];
                console.log(bus);
                html = html + '<tr><td>' + bus.id + '</td>\n' +
                '        <td>' + bus.num + '</td>\n' +
                '        <td>' + bus.type + '</td>\n' +
                '        <td>' + bus.mest + '</td>' +
                '        <td><button onclick="deleteBus(' + bus.id + ')">Delete</button></td></tr>';
            }
            document.getElementById("busList").innerHTML = html;
        }
    };
    xhttp.open("GET", "http://localhost:8090/bus/findAll", true);
    xhttp.send();
}


function loadTrip() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var trips = JSON.parse(this.responseText);
            var html = '<tr>\n' +
            '        <th>Trip id</th>\n' +
            '        <th>Trip number</th>\n' +
            '        <th>Trip starttime</th>\n' +
            '        <th>Trip endtime</th>\n' +
            '        <th>Trip interval</th>\n' +
            '        <th>Trip protyaj</th>\n' +
            '        <th>Delete</th>\n' +
            '    </tr>';
            for (let i = 0; i < trips.length; i++) {
                let trip = trips[i];
                console.log(trip);
                html = html + '<tr><td>' + trip.id + '</td>\n' +
                '        <td>' + trip.number + '</td>\n' +
                '        <td>' + trip.starttime + '</td>\n' +
                '        <td>' + trip.endtime + '</td>\n' +
                '        <td>' + trip.interval + '</td>\n' +
                '        <td>' + trip.protyaj + '</td>' +
                '        <td><button onclick="deleteTrip(' + trip.id + ')">Delete</button></td></tr>';
            }
            document.getElementById("tripList").innerHTML = html;
        }
    };
    xhttp.open("GET", "http://localhost:8090/trip/findAll", true);
    xhttp.send();
}


loadUsers();
loadBus();
loadTrip();