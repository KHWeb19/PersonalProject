<template>
    <div class="Main">
        <main-page-form></main-page-form>

        <div class="wrap">
            <booking-list-read-form v-if="BookingBoard" :BookingBoard="BookingBoard" :bookingNo ="bookingNo" :cakeLists="cakeLists" @click="checksameID()"/>
            <p v-else>로딩중 ... </p>
            <div>
                <booking-board-comment :bookingNo="bookingNo" ></booking-board-comment>
            </div>
        </div>
        
        
        <footer-form ></footer-form>
    </div>
</template>

<script>
import MainPageForm from '@/components/layout/MainPageForm.vue'
import FooterForm from '@/components/layout/FooterForm.vue'
import BookingListReadForm from '@/components/boardPage/BookingListReadForm.vue'
import { mapState, mapActions } from 'vuex'
import BookingBoardComment from '@/views/boardPage/BookingBoardComment.vue'
import axios from 'axios'

    export default {
        name: 'BookingReadPage',
        props: {
            bookingNo: {
                type: String,
                required: true
            }
        },
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
        components: {
            BookingListReadForm,
            MainPageForm,
            FooterForm,
            BookingBoardComment
        },
        computed: {
            ...mapState(['cakeLists']),
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
        created () {
            this.fetchCakeLists()
        },
        methods: {
            ...mapActions(['fetchCakeLists']),

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