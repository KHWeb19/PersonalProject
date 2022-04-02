<template>
    <div>
        <h4>케이크 보기</h4><br>

        <swiper-page></swiper-page>
        
    </div>
</template>

<!-- 해야할 것
option value를 배열 형태로 만들어서 클릭하면 그거에 맞는 이미지가 선택되고 for문으로 값을 나열한다.
 -->

<script>
import SwiperPage from '@/components/mainPage/SwiperPage.vue'
    
    export default {
        name: 'PreviewCakeForm',
        components: { SwiperPage },
        data () {
            return {
            }
        },
        methods: {
        }

    }

</script>

<style scoped>

</style>