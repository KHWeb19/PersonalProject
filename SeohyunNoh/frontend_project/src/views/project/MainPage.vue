<template>
    <div>
        <Header/>

        <!-- 메인페이지 이미지슬라이드가 전체화면에서 잘리고 작은화면에선 잘 나옴. 수정 필요-->
        <div id="app">
            <v-app id="inspire">
                <v-continer fluid ma-0 pa-0 fill-height>
                    <v-row >
                        <v-col>
                            <v-carousel :show-arrows="false">
                            <v-carousel-item
                                v-for="(banner,i) in banners"
                                :key="i"
                                :src="banner.src"
                            ></v-carousel-item>
                            </v-carousel>
                        </v-col>
                    </v-row>
                </v-continer>
            </v-app>
        </div>
        
    </div>
</template>

<script>
import Header from '@/components/layout/Header.vue'

// import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
// import 'swiper/css/swiper.css'

export default {
    components: {
        Header,
        // Swiper,
        // SwiperSlide
    },
    data() {
        return {
            banners: [ 
                {src: 'http://img.ouimerci.co.kr/20fw/25.jpg'}, 
                {src:'http://img.ouimerci.co.kr/20fw/22.jpg'},
                {src:'http://img.ouimerci.co.kr/20fw/17.jpg'}, 
                {src:'http://img.ouimerci.co.kr/20fw/5.jpg'}
                ]
            }
        }
    }
</script>

<style scoped>
    
</style>