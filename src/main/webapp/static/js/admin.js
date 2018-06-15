$(document).ready(function () {
    var dataTable = $("#datatable").DataTable({
        "processing": true,
        "serverSide": true,
        "searching": false,
        "select": {
            "style": "single"
        },
        "ajax": {
            "url": "admin/inscriptions",
            "type": "POST",
            "contentType": "application/json",
            "data": function (d) {
                return JSON.stringify(d);
            }
        },
        "columns": [
            {
                "data" :  "id"
            },
            {
                "data": "firstName"
            },
            {
                "data": "name"
            },
            {
                "data": "email"
            },
            {
                "data": "phone"
            },
            {
                "data": "amount"
            },
            {
                "data": "paid"
            }
        ]
    });

    dataTable.on('select', function (e, dt, type, indexes) {
        $("#switchPaymentStatus").removeAttr("disabled");
    });

    var refresh = function () {
        $("#switchPaymentStatus").attr("disabled", true);
        dataTable.ajax.reload(null, false); //user paging is not reset
    };

    $("#switchPaymentStatus").click(function () {
        var data = dataTable.rows({selected: true}).data();

        if (confirm('Would u like to switch payment status of ' + data[0]['firstName'] + " " + data[0]['name'])) {
            $.ajax({
                url: "inscription/switchStatus?id=" + data[0]['id']
            }).done(function (data, textStatus, jqXHR) {
                refresh();
            }).fail(function (jqXHR, textStatus, errorThrown) {
            });
        }
    });

    $(document).on("click", ".exportButton", function() {
        $.fileDownload($(this).data('target'));
            // .done(function () { alert('File download a success!'); })
            // .fail(function () { alert('File download failed!'); });

        return false; //this is critical to stop the click event which will trigger a normal file download
    });
});