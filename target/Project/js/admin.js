$(document).ready(function () {
    $('#dtHorizontalVerticalExample').DataTable({
        "scrollX": true,
        "scrollY": 200,
    });
    $('.dataTables_length').addClass('bs-select');
    //------------------ select all ------------------------
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
    $('.nav-item').click(function (){
        const queryString = window.location.search;
        console.log(queryString);
        if(queryString.endsWith("userManager")){
            $('.title').text("userManager")
        }
        else if (queryString.endsWith("ProductManager")){
            $('.title').text("asddadsnager")
        }
        else if(queryString.endsWith("orderManager")){
            $('.title').text("ewr5435")
        }
    })
});


// $(document).ready(function () {
//     $('#dtHorizontalVerticalExample').DataTable();
// });


