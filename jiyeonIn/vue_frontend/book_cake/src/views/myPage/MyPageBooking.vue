<template>
    <div class="Main">
        <main-page-form></main-page-form>

        <div class="myPage">
            <my-page-booking-form :bookingIdLists="bookingIdLists"></my-page-booking-form>
        </div>

        <footer-form></footer-form>
    </div>
</template>

<script>
import MainPageForm from '@/components/layout/MainPageForm.vue'
import FooterForm from '@/components/layout/FooterForm.vue'
import MyPageBookingForm from '../../components/myPage/MyPageBookingForm.vue'
import { mapState, mapActions } from 'vuex'

    export default {
        name: 'MyPageReview',
        components:{
            MainPageForm,
            FooterForm,
            MyPageBookingForm
        },
        props: {
            id: {
                type: String,
                required: true
            }
        },
        data () {
            return {
                checkId:''
            }
        }
        ,
        computed: {
            ...mapState(['bookingIdLists'])
        },
        mounted() {
            this.fetchBookingIdLists(this.id)
        },
        methods: {
            ...mapActions(['fetchBookingIdLists'])
        }
    }
</script>

<style scoped>
.Main {
    background: rgb(255, 186, 186);
}

.myPage {
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