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
        data () {
            return {
                id: (window.localStorage.getItem('id')),
                BookingBoard:{
                    type:Object
                },
                checkBookingNo:'',
                checkId:''
            }
        },
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
        mounted() {
            const params = {checkBookingNo: this.bookingNo, checkId : this.id}
            
            axios.get('http://localhost:7777/booking/read', {params})
                    .then(res => {
                        if(res.data){
                        console.log(res.data)
                        this.BookingBoard = res.data
                    }else {
                        alert('접근 가능한 아이디가 아닙니다!')
                        this.$router.push({
                            name: 'BookingListPage'
                        })
                    }
                    })
                    .catch(() => {
                        alert('읽기 실패')
                    })
        },
        computed: {
            ...mapState(['cakeLists'])
        },
        methods: {
            ...mapActions(['fetchCakeLists']),
            onSubmit (payload) {
                const { id, date, time, process, contents, cakeLinkInfo ,linkInfo, design, size, price, regDate } = payload
                
                axios.put(`http://localhost:7777/booking/${this.bookingNo}`, {id, date, time, process, contents,cakeLinkInfo, linkInfo, design, size, price, regDate})
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