$(document).ready(function () {
    $('.restaurant_review').click(function (e){
        e.preventDefault();
        let restaurantId = $(this).attr("href");
        $.ajax({
            type: "GET",
            url: "/api_restaurant/findReview/" + restaurantId,
            success: function (data){
                if(data.length > 0) {
                    let content = ``;
                    for (let i = 0; i < data.length; i++) {
                        content += getReview(data[i]);
                    }
                    document.getElementById("user_review").innerHTML = content;
                } else {
                    let content = '<img src="/img/no_review.gif" style="width: 500px; height: 300px; display: block; margin-left: auto; margin-right: auto">';
                    document.getElementById("user_review").innerHTML = content;
                }
            }
        })

        function getReview(data){
            let stringData = ``;
            stringData += `<div style="margin-top: 30px">
                        <span style="font-weight: bolder;margin-bottom: 5px">User: ${data.user.username}</span>
                        <hr style="height: 5px;width: 140px;color: black;margin: 0;padding: 0;"/>`;
            switch (data.score) {
                case 1:
                    stringData += `<p style="margin-bottom: 0">★☆☆☆☆</p>`;
                    break;
                case 2:
                    stringData += `<p style="margin-bottom: 0">★★☆☆☆</p>`;
                    break;
                case 3:
                    stringData += `<p style="margin-bottom: 0">★★★☆☆</p>`;
                    break;
                case 4:
                    stringData += `<p style="margin-bottom: 0">★★★★☆</p>`;
                    break;
                default:
                    stringData += `<p style="margin-bottom: 0">★★★★★</p>`;

            }
            stringData += `<small class="fst-italic" style="margin-top: 0;padding-top: 0; text-align: justify; color: deepskyblue">${data.user_comment}</small>
                    </div>`;
                        return stringData;
        }
    })

    $('#search_form').submit(function (e){
        e.preventDefault();
        let searchName = $('#search_name').val();
        if(searchName == ""){
            window.location.href = "http://localhost:8080/restaurant";
        } else {
            $.ajax({
                type: "GET",
                url: "/api_restaurant/search?search_name=" + searchName,
                success: function(data){
                    if(data.length > 0) {
                        let content = '';
                        for (let i = 0; i < data.length; i++) {
                            content += getSearchRestaurant(data[i]);
                        }
                        document.getElementById("restaurant_display").innerHTML = content;
                        $('.restaurant_review').click(function (e){
                            e.preventDefault();
                            let restaurantId = $(this).attr("href");
                            $.ajax({
                                type: "GET",
                                url: "/api_restaurant/findReview/" + restaurantId,
                                success: function (data){
                                    if(data.length > 0) {
                                        let content = ``;
                                        for (let i = 0; i < data.length; i++) {
                                            content += getReview(data[i]);
                                        }
                                        document.getElementById("user_review").innerHTML = content;
                                    } else {
                                        let content = '<img src="/img/no_review.gif" style="width: 500px; height: 300px; display: block; margin-left: auto; margin-right: auto">';
                                        document.getElementById("user_review").innerHTML = content;
                                    }
                                }
                            })

                            function getReview(data){
                                let stringData = ``;
                                stringData += `<div style="margin-top: 30px">
                        <span style="font-weight: bolder;margin-bottom: 5px">User: ${data.user.username}</span>
                        <hr style="height: 5px;width: 140px;color: black;margin: 0;padding: 0;"/>`;
                                switch (data.score) {
                                    case 1:
                                        stringData += `<p style="margin-bottom: 0">★☆☆☆☆</p>`;
                                        break;
                                    case 2:
                                        stringData += `<p style="margin-bottom: 0">★★☆☆☆</p>`;
                                        break;
                                    case 3:
                                        stringData += `<p style="margin-bottom: 0">★★★☆☆</p>`;
                                        break;
                                    case 4:
                                        stringData += `<p style="margin-bottom: 0">★★★★☆</p>`;
                                        break;
                                    default:
                                        stringData += `<p style="margin-bottom: 0">★★★★★</p>`;

                                }
                                stringData += `<small class="fst-italic" style="margin-top: 0;padding-top: 0; text-align: justify; color: deepskyblue">${data.user_comment}</small>
                    </div>`;
                                return stringData;
                            }
                        })
                    } else {
                        let content = '<div class="justify-content-center">' +
                            '<img src="/img/no_review.gif" style="width: 700px; height: 500px">' +
                            '</div>';
                        document.getElementById("restaurant_display").innerHTML = content;
                    }
                }
            });
        }

        function getSearchRestaurant(data){
            let stringData = ``;
            stringData += `<div style="margin-bottom: 20px; background-color: #F1F8FF" class="row">
                    <div style="margin-left: 0;padding-left: 0" class="col-lg-4 col-md-12 col-12">
                        <div class="img">
                            <img style="width: 500px;height: 300px" class="img-fluid" src="${data.image}">
                        </div>
                    </div>
                    <div class="col-lg-8 col-md-12 col-12 ps-lg-5 mt-md-5">
                        <div style="text-align: left">`
            let score = data.ratingScore / data.totalRating;
            switch (score){
                case 1:
                    stringData += `<div style="font-size: 25px">
                                <p>★☆☆☆☆</p>
                            </div>`;
                    break;
                case 2:
                    stringData += `<div style="font-size: 25px">
                                <p>★★☆☆☆</p>
                            </div>`;
                    break;
                case 3:
                    stringData += `<div style="font-size: 25px">
                                <p>★★★☆☆</p>
                            </div>`;
                    break;
                case 4:
                    stringData += `<div style="font-size: 25px">
                                <p>★★★★☆</p>
                            </div>`;
                    break;
                default:
                    stringData += `<div style="font-size: 25px">
                                <p>★★★★★</p>
                            </div>`;
            }
                            stringData += `<h2 style="text-transform: uppercase">${data.name}</h2>
                            <div style="display: flex">
                            <i class="fa-solid fa-location-dot"></i>
                            <p style="margin-left: 10px">${data.address}</p>
                            </div>
                            <div style="margin-bottom: 10px">
                                <a role="button" href="${data.id}" class="btn btn-info restaurant_review" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                    Review
                                </a>
                            </div>
                                <a style="font-size: small" class="btn btn-danger" href="${data.orderLink}" target="_blank">Order now<img src="https://shopeefood.vn/app/assets/img/shopeefoodvn.png?4aa1a38e8da801f4029b80734905f3f7" alt="ShopeeFood"></a>
                        </div>
                    </div>
                </div>`
            return stringData;
        }
    })
});