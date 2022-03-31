<template>
    <div class="slide-3d">
        <v-app id="inspire">
            <v-container>
                <swiper class="swiper" :options="swiperOption">
                    <swiper-slide>Slide 1</swiper-slide>
                    <swiper-slide>Slide 2</swiper-slide>
                    <swiper-slide>Slide 3</swiper-slide>
                    <swiper-slide>Slide 4</swiper-slide>
                    <swiper-slide>Slide 5</swiper-slide>
                    <swiper-slide>Slide 6</swiper-slide>
                    <swiper-slide>Slide 7</swiper-slide>
                    <swiper-slide>Slide 8</swiper-slide>
                    <swiper-slide>Slide 9</swiper-slide>
                    <swiper-slide>Slide 10</swiper-slide>
                    <swiper-slide>Slide 11</swiper-slide>
                    <swiper-slide>Slide 12</swiper-slide>
                    <swiper-slide>Slide 13</swiper-slide>
                    <swiper-slide>Slide 14</swiper-slide>
                    <swiper-slide>Slide 15</swiper-slide>
                    <swiper-slide>Slide 16</swiper-slide>
                    <div class="swiper-pagination" slot="pagination">
                    </div>
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
        swiperOption: {
            loop: true,
            effect: 'coverflow',
            grabCursor: true,
            centeredSlides: true,
            slidesPerView: 'auto',
            coverflowEffect: {
                rotation: 50,
                stretch: 0,
                depth: 100,
                // 회전을 많이 먹이고 싶은 경우 높이도록 한다.
                modifier: 1,
                slideShadows: true
            },
            pagination: {
                el: '.swiper-pagination',
                dynamicBullets: true
            },
            autoplay: {
                delay: 1000
            }
        }
      }
    }
}
  /*
  export default {
name: 'Discount-a'
}

이런식으로 '-' 이용해서 여러단어로 구성해주거나

export default {
//eslint-disable-next-line
name: 'Discount'
}

이렇게 위해 주석 추가해주면 됩니다.
  */
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
        width: 300px;
        height: 300px;
        text-align: center;
        font-weight: bold;
        font-size: 1.7rem;
        background-color: darkorange;
        background-position: center;
        background-size: cover;
    }
}
</style>