
import $ from 'jquery';
export default {

    animater1() {

        var $content1 = $('.content1')
        var $offset = 350
        var $content1OST = $content1.offset().top - $offset

        $(window).scroll(function () {
            if ($(this).scrollTop() > $content1OST) {
                $content1.find('img').addClass('animate')

            }
        })
    },
    animater2() {

        var $ghost1 = $('.ghost1')
        var $ghost2 = $('.ghost2')
        var $ghost3 = $('.ghost3')
        var $content3 = $('.content3')

        var $offset = 250
        var $content2OST = $ghost1.offset().top - $offset

        $(window).scroll(function () {
            if ($(this).scrollTop() > $content2OST) {
                $ghost1.addClass('animate2')
                $ghost2.addClass('animate3')
                $ghost3.addClass('animate4')
                $content3.find('img').addClass('animate5')

            }
        })
    }

}