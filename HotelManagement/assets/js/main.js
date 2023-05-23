$.ajax({
    type: "GET",
    url: "http://10.8.35.157:8080/HotelManager_war_exploded/HomePage",
    data: { get_param: "value" },
    dataType: "json",
    success: function (data) {
      $.each(data, function (index, element) {
        $("table tbody").append(
          $("<tr>")
            .append($("<td>", { text: element.id }))
            .append($("<td>", { text: element.name }))
            .append($("<td>", { text: element.className }))
        );
      });
    },
  });

  $("#student").submit(function(e) {

    e.preventDefault(); // avoid to execute the actual submit of the form.

    var form = $(this);
    var actionUrl = form.attr('http://10.8.35.157:8080/HotelManager_war_exploded/HomePage');
    
    $.ajax({
        type: "POST",
        url: actionUrl,
        data: form.serialize(), // serializes the form's elements.
        success: function(data)
        {
          alert(data); // show response from the php script.
        }
    });
    
});