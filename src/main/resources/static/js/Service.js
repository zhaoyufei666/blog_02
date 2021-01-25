$(function () {
    $("#button_all").on("click", function () {
        $.getJSON("findAll", null, function (data) {
            console.log(data);
            console.log(data.list);
            $.each(data.list, function (i, item) {
                console.log(item);
            });
        });
    });
});