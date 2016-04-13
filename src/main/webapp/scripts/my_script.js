function onch(){
    var val = document.getElementById('one').value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            document.getElementById("two").innerHTML = xhttp.responseText;
        }
    };
    xhttp.open("Post", "/ajaxcontroller?valajax="+val, true);
    xhttp.send();

}

