(function pollFirst() {
    setTimeout(function() {
        $.ajax({
            url: "/shower/status?id=1",
            type: "GET",
            success: function(data) {
                console.log("polling first " + data);
                $("#status-first").html(data);
            },
            dataType: "html",
            complete: pollFirst,
            timeout: 1000
        })
    }, 3000);
})();

(function pollSecond() {
    setTimeout(function() {
        $.ajax({
            url: "/shower/status?id=2",
            type: "GET",
            success: function(data) {
                console.log("polling second " + data);
                $("#status-second").html(data);
            },
            dataType: "html",
            complete: pollSecond,
            timeout: 1000
        })
    }, 3000);
})();


console.log("Started");