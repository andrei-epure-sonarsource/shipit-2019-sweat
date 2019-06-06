(function poll() {
    setTimeout(function() {
        $.ajax({
            url: "/shower/status",
            type: "GET",
            success: function(data) {
                console.log("polling " + data);
                $("#status-div").html(data);
            },
            dataType: "html",
            complete: poll,
            timeout: 2000
        })
    }, 5000);
})();

console.log("here");