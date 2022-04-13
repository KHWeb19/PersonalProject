<template>
    <div>
        <Header/>
        
        <div class="slide">
            <v-app id="inspire">
                <v-container>
                    <swiper class="swiper" :options="swiperOption">
                        <swiper-slide :key="banner" v-for="banner in banners">
                            <img :src="banner">
                        </swiper-slide>
                        <div class="swiper-pagination" slot="pagination">
                        </div>
                    </swiper>
                </v-container>
            </v-app>
        </div>
        
    </div>
</template>

<script>
import Header from '@/components/layout/Header.vue'

import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
import 'swiper/css/swiper.css'

export default {
    components: {
        Header,
        Swiper,
        SwiperSlide
    },
    data() {
        return {
            banners: [ 'http://img.ouimerci.co.kr/20fw/25.jpg', 
            'http://img.ouimerci.co.kr/20fw/22.jpg', 'http://img.ouimerci.co.kr/20fw/17.jpg', 
            'http://img.ouimerci.co.kr/20fw/5.jpg'],
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
                    delay: 3000
                }
            }
        }
    }
}
</script>