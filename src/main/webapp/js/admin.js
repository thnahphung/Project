$(document).ready(function () {
    $('#dtHorizontalVerticalExample').DataTable({
        "scrollX": true,
        "scrollY": 200,
    });
    $('.dataTables_length').addClass('bs-select');
});


$(document).ready(function () {
    $('#dtHorizontalVerticalExample').DataTable();
});
//------------------ select all ------------------------
$(document).ready(function () {
    $('#select-all').click(function (event) {
        if (this.checked) {
            // Iterate each checkbox
            $(':checkbox').each(function () {
                this.checked = true;
            });
        } else {
            $(':checkbox').each(function () {
                this.checked = false;
            });
        }
    });
});