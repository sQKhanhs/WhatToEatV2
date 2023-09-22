$(document).ready(function () {

    $('#contribute_button').click(function (e) {
        $('body').attr('style', 'overflow : hidden !important')
        $('#foodname_contribute').val("");
        $('#calories_contribute').val("");
        $('#description_contribute').val("");
        $('#image_contribute').val("");
        $('#cuisine_contribute').val("");
    });

    $('#post_contribute').click(function (e) {
        e.preventDefault();

        let foodname = $('#foodname_contribute').val();
        let calories = $('#calories_contribute').val();
        let description = $('#description_contribute').val();
        let image = $('#image_contribute').val();
        let cuisine = $('#cuisine_contribute').val();
        let userID = Number($('#userID_contribute').val());
        let newUser = {
            id: userID
        };
        let newFood = {
            name: foodname,
            calories: calories,
            description: description,
            image: image,
            cuisine: cuisine,
            user: newUser
        };
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: "POST",
            data: JSON.stringify(newFood),
            url: "/api/add",

            success: function(){
                const modal = bootstrap.Modal.getInstance(document.getElementById('exampleModal'));
                modal.hide();
                location.reload();
            }
        });
    });

    $('#search_form').submit(function (e){
        e.preventDefault();
        let checkUser = $(".avatar-name").attr("href");
        let searchName = $('#search_name').val();
        if(searchName == ""){
            window.location.href = "http://localhost:8080/wiki";
        } else {
        $.ajax({
            type: "GET",
            url: "/api/search?search_name=" + searchName,
            success: function(data){
                if(data.length > 0) {
                    let content = '<div class="row g-4">';
                    for (let i = 0; i < data.length; i++) {
                        content += getSearchFood(data[i]);
                    }
                    content += '</div>';
                    document.getElementById("foodList tab-1").innerHTML = content;
                    $('.edit_food').on("click", function (e) {
                        e.preventDefault();
                        let foodId = $(this).attr("href");
                        $.ajax({
                            type: "GET",
                            url: "/api/edit/" + foodId,
                            success: function (data) {
                                $('#foodID_edit').val(foodId);
                                $('#foodname_edit').val(data.name);
                                $('#calories_edit').val(data.calories);
                                $('#description_edit').val(data.description)
                                $('#image_edit').val(data.image)
                                $('#cuisine_edit').val(data.cuisine)
                            }
                        })
                    })

                    $('.delete_food').on("click",function (e){
                        e.preventDefault();
                        let foodId = $(this).attr("href");
                        let confirmation = confirm("Are you sure you want to remove this post?");
                        if(confirmation) {
                            $.ajax({
                                type: "DELETE",
                                url: "/api/delete/" + foodId,
                                success: function () {
                                    window.location.replace("http://localhost:8080/wiki");
                                    alert("Deleted Successfully!");
                                }
                            })
                        }
                    });
                } else {
                    let content = '<div class="justify-content-center">' +
                        '<img src="/img/no_review.gif" style="width: 800px; height: 500px">' +
                        '</div>';
                    document.getElementById("foodList tab-1").innerHTML = content;
                }
            }
        });
        }

        function getSearchFood(data){
            let stringData = ``;
            stringData += `<div class="col-lg-6">
                                    <div class="d-flex align-items-center" >
                                        <img class="flex-shrink-0 img-fluid rounded" src="${data.image}" alt="" style="width: 80px;">
                                        <div class="w-100 d-flex flex-column text-start ps-4">
                                            <figure>
                                                <blockquote class="blockquote">
                                                    <h5 class="d-flex justify-content-between border-bottom pb-2">
                                                        <span style="text-transform: uppercase">${data.name}</span>`;
                if(data.user.username === checkUser ){
                    stringData += `<div>
                        <a class="edit_food" href="${data.id}" style="color: #25cff2; margin-right: 20px"
                           data-bs-toggle="modal" data-bs-target="#editModal">Edit<i
                            class="fa-solid fa-pen-to-square"></i></a>
                        <a class="delete_food" href="${data.id}" style="color: crimson; margin-left: 20px">Delete<i
                            class="fa-solid fa-trash"></i></a>
                    </div>`;
                }
                                                       stringData += `<span class="text-primary">${data.calories} kcal</span>
                                                    </h5>
                                                </blockquote>
                                                <figcaption class="blockquote-footer">
                                                    By User <cite style="font-weight: bold; padding-bottom: 0" title="Source Title">${data.user.username}</cite>
                                                </figcaption>
                                            </figure>
                                            <small class="fst-italic" style="padding-top: 0">${data.description}</small>
                                        </div>
                                    </div>
                                    <div>
                                        <a class="btn btn-light" role="button" href="/restaurant/${data.id}" ">Find Restaurant <i class="fa-solid fa-map-location"></i></a>
                                    </div>
                                </div>`;
                return stringData;
        }
    })

    $('.edit_food').click(function (e){
        e.preventDefault();
        let foodId = $(this).attr("href");
        $.ajax({
            type: "GET",
            url: "/api/edit/" + foodId,
            success: function (data){
                $('#foodID_edit').val(foodId);
                $('#foodname_edit').val(data.name);
                $('#calories_edit').val(data.calories);
                $('#description_edit').val(data.description);
                $('#image_edit').val(data.image);
                $('#cuisine_edit').val(data.cuisine);
            }
        })
    });

    $('#post_edit').click(function (e){
        e.preventDefault();
        let id = $('#foodID_edit').val();
        let userID = Number($('#userID_edit').val());
        let editUser = {
            id: userID
        };
        let data =
            {
                "name": $('#foodname_edit').val(),
                "calories": $('#calories_edit').val(),
                "description": $('#description_edit').val(),
                "image": $('#image_edit').val(),
                "cuisine": $('#cuisine_edit').val(),
                "user": editUser
            };
        $.ajax({
            type : "PUT",
            url : "http://localhost:8080/api/edit/"+id,
            contentType: "application/json",
            data: JSON.stringify(data),
            dataType : "JSON",
            success : function(result) {
                location.reload();
                alert("Updated Successfully!");
            }
        })
    })

    $('.delete_food').click(function (e){
        e.preventDefault();
        let foodId = $(this).attr("href");
        let confirmation = confirm("Are you sure you want to remove this post?");
        if(confirmation) {
            $.ajax({
                type: "DELETE",
                url: "/api/delete/" + foodId,
                success: function () {
                    window.location.replace("http://localhost:8080/wiki");
                    alert("Deleted Successfully!");
                }
            })
        }
    });
})





