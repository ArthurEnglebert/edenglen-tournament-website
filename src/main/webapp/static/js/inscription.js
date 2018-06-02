$(document).ready(function() {
    $("form").submit(function(event) {
        event.preventDefault();

        var data = {};

        var register = {};
        register["name"] = $("#inputName").val();
        register["firstName"] = $("#inputFirstName").val();
        register["email"] = $("#inputEmail").val();
        register["phone"] = $("#inputPhone").val();
        data["referent"] = register;

        var player1 = {};
        player1["name"] = $("#inputNamePlayer1").val();
        player1["firstName"] = $("#inputFirstNamePlayer1").val();
        player1["email"] = $("#inputEmailPlayer1").val();
        player1["age"] = $("#inputAgePlayer1").val();
        player1["sex"] = $("input[name=inputSexPlayer1]:checked").val();
        player1["skillLevel"] = $("#inputSkillLevelPlayer1 option:selected").text();
        player1["phone"] = $("#inputPhonePlayer1").val();
        player1["championshipLevel"] = $("#inputChampionshipLevelPlayer1 option:selected").text();
        player1["isDining"] = $("#inputIsComingPlayer1").is(":checked");
        data["players"] = [player1];

        var eater1 = {};
        eater1["name"] = $("#inputNameEater1").val();
        eater1["firstName"] = $("#inputFirstNameEater1").val();
        eater1["email"] = $("#inputEmailEater1").val();
        eater1["age"] = $("#inputAgeEater1").val();
        data["eaters"] = [eater1];

        data["donation"] = $("#donation").val();

        $.ajax({
            method: "POST",
            url: "inscription/submit",
            contentType: "application/json",
            data: JSON.stringify(data)
        })
            .done(function(data, textStatus, jqXHR) {
            })
            .fail(function(jqXHR, textStatus, errorThrown) {
            });
    });
});