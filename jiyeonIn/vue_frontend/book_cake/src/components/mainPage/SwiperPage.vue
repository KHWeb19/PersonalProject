<template>
    <div class="slide-3d" >
            <v-container>
                <v-row>
                    <v-col>
                        <br><h3>Birthday</h3>
                        <swiper class="swiper" :options="swiperOption">
                            <swiper-slide> <img src = "@/assets/uploadImg/birthday/1.birhday.png"></swiper-slide>
                            <swiper-slide> <img src = "@/assets/uploadImg/birthday/2.birhday(2).png"></swiper-slide>
                            <swiper-slide> <img src = "@/assets/uploadImg/birthday/3.birhday(3).png"></swiper-slide>
                            <swiper-slide> <img src = "@/assets/uploadImg/birthday/4.birhday(4).png"></swiper-slide>
                            <swiper-slide> <img src = "@/assets/uploadImg/birthday/5.birhday(5).png"></swiper-slide>
                            <div class="swiper-pagination" slot="pagination">
                            </div>
                        </swiper>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col>
                        <br><h3>Family</h3>
                        <swiper class="swiper" :options="swiperOption">
                            <swiper-slide> <img src = "@/assets/uploadImg/family/1.famaily cake.png"></swiper-slide>
                            <swiper-slide> <img src = "@/assets/uploadImg/family/2.famaily cake(2).png"></swiper-slide>
                            <swiper-slide> <img src = "@/assets/uploadImg/family/3.famaily cake(3).png"></swiper-slide>
                            <swiper-slide> <img src = "@/assets/uploadImg/family/4.famaily cake(4).png"></swiper-slide>
                            <swiper-slide> <img src = "@/assets/uploadImg/family/5.famaily cake(5).png"></swiper-slide>
                            <div class="swiper-pagination" slot="pagination">
                            </div>
                        </swiper>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col>
                        <br><h3>Friend</h3>
                        <swiper class="swiper" :options="swiperOption">
                            <swiper-slide> <img src = "@/assets/uploadImg/friend/1.friend cake.png"></swiper-slide>
                            <swiper-slide> <img src = "@/assets/uploadImg/friend/2.friend cake(2).png"></swiper-slide>
                            <swiper-slide> <img src = "@/assets/uploadImg/friend/3.friend cake(3).png"></swiper-slide>
                            <swiper-slide> <img src = "@/assets/uploadImg/friend/4.friend cake(4).png"></swiper-slide>
                            <swiper-slide> <img src = "@/assets/uploadImg/friend/5.friend cake(5).png"></swiper-slide>
                            <div class="swiper-pagination" slot="pagination">
                            </div>
                        </swiper>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col>
                        <br><h3>Lover</h3>
                        <swiper class="swiper" :options="swiperOption">
                            <swiper-slide> <img src = "@/assets/uploadImg/lover/1.lover.png"></swiper-slide>
                            <swiper-slide> <img src = "@/assets/uploadImg/lover/2.lover(2).png"></swiper-slide>
                            <swiper-slide> <img src = "@/assets/uploadImg/lover/3.lover(3).png"></swiper-slide>
                            <swiper-slide> <img src = "@/assets/uploadImg/lover/4.lover(4).png"></swiper-slide>
                            <swiper-slide> <img src = "@/assets/uploadImg/lover/5.lover(5).png"></swiper-slide>
                            <div class="swiper-pagination" slot="pagination">
                            </div>
                        </swiper>
                    </v-col>
                </v-row>
            </v-container>
            
    </div>
</template>

<script>

import { swiper, swiperSlide } from 'vue-awesome-swiper'
import 'swiper/dist/css/swiper.css'

export default {
    name: 'SwiperPage',
    components: {
        swiper,
        swiperSlide
    },
    data () {
        return {
            swiperOption: {
                loop: false, //무한반복원하면 true, 아니면 false
                effect: 'coverflow',
                grabCursor: true, // 사용자가 잡아서 끌수있게 만들어줌, 근데 false랑 true랑 비슷한것같음..
                centeredSlides: false, //센터에서 슬라이드 할수있게 도와줌
                slidesPerView: 'auto',
                coverflowEffect: {
                    rotation: 50, //뭔차이인지 모르겟음
                    stretch: 50, // 센터랑 사이드의 거리..? 클수록 센터랑 딱 달라붙어있다. 별로 보기엔 좋지 않음
                    depth: 100, // 센터랑 사이드의 굴절도?  솔직히 별로 필요는 없는것같다.
                    // 회전을 많이 먹이고 싶은 경우 높이도록 한다.
                    modifier: 0, //0으로 해야 상품들옆으로 넘기는 것 같은 효화를 준다.
                    slideShadows: false //사이드에 그림자가 있냐없냐 체크 가능. true : 그림자있음 / false:없음 // 솔직히 그림자 촌스러움
                },
                pagination: { // 이 단어 자체가 페이지 숨기기 였던 듯
                    el: '.swiper-pagination',
                    dynamicBullets: true //총 몇개가 있는지 밑에가 true면 center와 사이드 몇개만 보이고, false면 전체 개수가 보인다.
                }
            }
        }
    }
}

</script>

<style lang="scss" scoped>

.slide-3d {
    padding-top: 0px;
    padding-bottom: 0px;
    background: rgb(255, 186, 186);
    color: rgb(0, 0, 0);
}

.swiper {
    height: 100%;
    width: 100%;
    

    .swiper-slide {
        display: flex;
        align-items: center;
        width: 300px;
        height: 300px;
        text-align: center;
        background-position: center;
        background-size: cover;

        img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }
    }
}


</style>