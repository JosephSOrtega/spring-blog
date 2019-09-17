"use strict";


(function () {
///////////////////////Fade in/Out Navbar
    var opac;


    // Keeps breaking
    function fadeInEffect() {
        $('.navbar').animate({
            opacity: 1,
        }, 200, "linear", {
            step: function () {
            }
        })
    }

    function fadeOutEffect() {
        $('.navbar').animate({
            opacity: opac,
        }, 100, "linear", {
            step: function () {
            }
        })
    }

    $(window).scroll(function () {
        $(".jumbotron").css("opacity", 1 - $(window).scrollTop() / 800);
        $(".navbar").css("opacity", 1 - $(window).scrollTop() / 800);
        if (($('.navbar').css("opacity")) < .2) {
            $('.navbar').css("opacity", ".2")
        }
    });
    $(document).ready(function () {


        $('.navbar').hover(function () {
            opac = $('.navbar').css("opacity");
            //remove for func version to work
            // $('.navbar').css("opacity", "1");

            fadeInEffect()
        }, function () {

            //remove for func version to work
            // $('.navbar').css("opacity", opac);

            fadeOutEffect()

        });
    });

})();
