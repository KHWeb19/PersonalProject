<template>
    <div>
        <Header/>
        <!-- <main-slider/> -->

        <!-- 메인페이지 이미지슬라이드 너비가 꽉 차게 하고싶은데 안됨-->
        <div id="app">
            <v-app id="inspire">
                <v-continer fluid ma-0 pa-0 fill-height>
                    <v-row >
                        <v-col>
                            <v-carousel cycle hide-delimiters show-arrows-on-hover height="auto">
                                <v-carousel-item v-for="(banner,i) in banners" :key="i">
                                     <v-img :src="banner.src" contain position="center center" max-height="800" ></v-img>
                                </v-carousel-item>
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
// import MainSlider from '../../components/layout/MainSlider.vue'

export default {
    components: {
        Header,
        // MainSlider
    },
    data() {
        return {
            banners: [ 
                {src: 'http://img.ouimerci.co.kr/urbanic30_21ss/western_denim_shirt_cam_5.jpg'}, 
                {src:'http://img.ouimerci.co.kr/20fw/5.jpg'},
                {src:'https://nothing-written.com/web/product/extra/small/202103/a9270fa7b945cda8fb6a03be7b1442f7.jpg'}, 
                {src: require('@/assets/img/문달1.png')},
                ]
            }
        }
    }
</script>

<style scoped>
    
</style>