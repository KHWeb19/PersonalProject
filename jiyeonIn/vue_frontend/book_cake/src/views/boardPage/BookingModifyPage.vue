<template>
    <div class="Main">
        <main-page-form></main-page-form>

        <div class="wrap">
            <booking-modify-page-form v-if="BookingBoard" :BookingBoard="BookingBoard" :cakeLists="cakeLists" :bookingNo="bookingNo" @submit="onSubmit"></booking-modify-page-form>
        </div>
        
        <footer-form ></footer-form>
    </div>
</template>

<script>
import MainPageForm from '@/components/layout/MainPageForm.vue'
import FooterForm from '@/components/layout/FooterForm.vue'
import BookingModifyPageForm from '@/components/boardPage/BookingModifyPageForm.vue'
import axios from 'axios'
import { mapState, mapActions } from 'vuex'

    export default {
        name:'BookingModifyPage',
        props: {
            bookingNo: {
                type: String,
                required: true
            }
        },
        components:{
            MainPageForm,
            FooterForm,
            BookingModifyPageForm

        },
        computed: {
            ...mapState(['BookingBoard']),
            ...mapState(['cakeLists'])
        },
        methods: {
            ...mapActions(['fetchBookingBoard']),
            ...mapActions(['fetchCakeLists']),
            onSubmit (payload) {
                const { id, date, time, process, contents, linkInfo, cakeArrNo, design, size, price, regDate } = payload
                
                axios.put(`http://localhost:7777/booking/${this.bookingNo}`, {id, date, time, process, contents, linkInfo, cakeArrNo, design, size, price, regDate})
                    .then(res => {
                        alert('게시물 수정 완료!')
                        this.$router.push({
                            name: 'BookingReadPage',
                            params: { productNo: res.data.bookingNo.toString() }
                        })
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
            }

        }
    }

</script>

<style scoped>
.Main {
    background: rgb(255, 186, 186);
}

.wrap {
    margin:2% 10% 3% 10%;
    padding: 15px;
    border: 3px solid rgb(243, 180, 180);
}
</style>