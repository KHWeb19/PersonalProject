<template>
    <div class="home_wrap">
		<swiper class="swiper" :options="swiperOption">
		
			<swiper-slide><img src="@/assets/swiperimg/브랜드 모음4.png" ></swiper-slide>
            <swiper-slide><img src="@/assets/swiperimg/브랜드 모음5.png"></swiper-slide>
            <swiper-slide><img src="@/assets/swiperimg/브랜드 모음2.png"></swiper-slide>
            <swiper-slide><img src="@/assets/swiperimg/샤넬 액서세리.jpg"></swiper-slide>
            <swiper-slide><img src="@/assets/swiperimg/세리누 곰.jpg"></swiper-slide>
            <swiper-slide><img src="@/assets/swiperimg/팬디 머플러.jpg"></swiper-slide>
            <swiper-slide><img src="@/assets/swiperimg/비통.jpg"></swiper-slide>
            <swiper-slide><img src="@/assets/swiperimg/구찌.jpg"></swiper-slide>
           <!--     
			<div class="swiper-pagination" slot="pagination"></div>
			<div class="swiper-button-prev" slot="button-prev"></div>
			<div class="swiper-button-next" slot="button-next"></div>
            -->
		</swiper>
    </div>
</template>

<script>
import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
import 'swiper/css/swiper.css'
export default {
    name:'HomeBanner',
    components: {
        Swiper,
        SwiperSlide
    },
    data () {
        return {
            swiperOption: {
                loop: true,
                grabCursor: true,
                centeredSlides: true,
                slidesPerView: 'auto',
                dffect:"fade",
                pagination:{el:".swiper-pagination",clickable:true},
                autoplay: {
                    delay: 3000
                }
            }
        }
    }
}
</script>
<style lang="scss" scoped>
.swiper {
    max-height: 100%;
    max-width: 100%;
    

    .swiper-slide {
        display: flex;
        justify-content: center;
        align-items: center;
        width: auto;
        height:450px;
        object-fit: fill;
        border:0;
        text-align: center;
        background-position: center;
        background-size: cover;
    }
}

</style>