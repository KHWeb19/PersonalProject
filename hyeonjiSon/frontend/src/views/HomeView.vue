<template>
    <div class="slide-3d">
        <v-app id="inspire">
            <v-container class="slide">
              <swiper class="swiper" :options="swiperOption">
                <swiper-slide v-for="image in images" :key="image">
                  <v-img :src="image"></v-img>
                </swiper-slide>
                <div class="swiper-pagination" slot="pagination"></div>
                <div class="swiper-button-prev" slot="button-prev"></div>
                <div class="swiper-button-next" slot="button-next"></div>
              </swiper>
            </v-container>
        </v-app>
    </div>
</template>

<script>
import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
import 'swiper/css/swiper.css'

  export default {
    //eslint-disable-next-line
    name: 'HomeView',

    components: {
      Swiper,
      SwiperSlide
    },
    methods: {
        slideChangeTransitionStart() {
            console.log(this.swiper.activeIndex); //현재 index값 얻기
        }
    },
    data () {
    return {
        images: [
                require("@/assets/homeSwiper/greeting.jpg"),
                require("@/assets/homeSwiper/recycle.jpg"),
                require("@/assets/homeSwiper/tipBoard.jpg"),
                require("@/assets/homeSwiper/store.jpg"),
                require("@/assets/homeSwiper/dog.jpg"),
                require("@/assets/homeSwiper/update.jpg")
],
        swiperOption: {
            loop: true,
            loopAdditionalSlides : 1, // 슬라이드 반복 시 마지막 슬라이드에서 다음 슬라이드가 보여지지 않는 현상 수정 ...안되는데?
            grabCursor: true,
            centeredSlides: true,
            slidesPerView: 'auto',
            coverflowEffect: {
                // 회전을 많이 먹이고 싶은 경우 높이도록 한다.
                slideShadows: true
            },
            pagination: {
                el: '.swiper-pagination',
                dynamicBullets: true,
                clickable : true,  // 버튼 클릭 여부
                type : 'bullets', // 버튼 모양 결정 "bullets", "fraction"
            },
            autoplay: {
                delay: 2500
            },
            navigation: {
            nextEl: ".swiper-button-next",
            prevEl: ".swiper-button-prev",
            },
        }
      }
    }
}

</script>

<style lang="scss" scoped>
.slide-3d {
    width: 100%;
    height: 400px;
    padding-top: 50px;
    padding-bottom: 50px;
}
.swiper {
    height: 100%;
    width: 100%;
    .swiper-slide {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 100%;
        height: 600px;
        text-align: center;
        font-weight: bold;
        font-size: 1.7rem;
    }
}
</style>