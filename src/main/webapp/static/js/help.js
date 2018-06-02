$(document).ready(function() {
    $("form").submit(function(event) {
        event.preventDefault();

        var data = {};

        data["firstName"] = $("#inputFirstName").val();
        data["name"] = $("#inputName").val();
        data["phone"] = $("#inputPhone").val();

        data["isBringingFood"] = $("#inputBringingFood").is(":checked");
        data["isComingToBuild"] = $("#inputBuilding").is(":checked");
        data["isComingToUnBuild"] = $("#inputUnbuild").is(":checked");
        data["isComingToDecorate"] = $("#inputDecorate").is(":checked");

        data["numberComing"] = $("#inputNumberComing").val();

        console.log(data);

        $.ajax({
            method: "POST",
            url: "help/submit",
            contentType: "application/json",
            data: JSON.stringify(data)
        })
            .done(function(data, textStatus, jqXHR) {
            })
            .fail(function(jqXHR, textStatus, errorThrown) {
            });
    });
});