<template>
    <div class="Main">

        <div>
            <main-page-form></main-page-form>
        </div>

        <div class="cakeImg">
            <h3>케이크 보기</h3><br>
            
            <swiper-page :cakeLists="cakeLists"></swiper-page><br><br><br>

        </div>
        

        <div>
            <footer-form></footer-form>
        </div>

    </div>
    
</template>

<script>
import MainPageForm from '@/components/layout/MainPageForm.vue'
import FooterForm from '@/components/layout/FooterForm.vue'
import axios from 'axios'
import SwiperPage from '@/components/mainPage/SwiperPage.vue'
import { mapState, mapActions} from 'vuex'

    export default {
        name: 'PreviewCakeImg',
        data () {
            return {
                files1: '',
                response: '',
                design: '',
                size: '',
                price:'',  
                
                dbrAction: (window.localStorage.getItem('id')),
                checkuserInfo: window.localStorage.getItem('token')

                }
            },
        
        components: {
            MainPageForm,
            FooterForm,
            SwiperPage
        },
        computed: {
            ...mapState(['cakeLists'])
        },
        mounted () {
            this.fetchCakeLists()
        },
        methods: {
            ...mapActions(['fetchCakeLists']),
            
                    
        }
    }
</script>

<style lang="scss" scoped>

.Main {
    background: rgb(255, 186, 186);
    color: rgb(0, 0, 0);
}
.MainLogo {
    display: block; margin: 0px auto;
}

.cakeImg {
    margin:2% 10% 3% 10%;
    padding: 15px;
    border: 3px solid rgb(243, 180, 180);
}

a {
    text-decoration: none;
    font: 300;
}

p {
    color: rgb(0, 0, 0);
    font-weight: 600;
}
hr{ 
    background: #e69191;
    height: 3px;
}

</style>