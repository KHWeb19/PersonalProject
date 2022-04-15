<template>
    <div class="Main">
        <main-page-form></main-page-form>

        <div class="wrap">
            <booking-list-read-form v-if="BookingBoard" :BookingBoard="BookingBoard" :bookingNo ="bookingNo" :cakeLists="cakeLists" @click="checksameID()"/>
            <p v-else>로딩중 ... </p>
            <div>
                <booking-board-comment :bookingNo="bookingNo"></booking-board-comment>
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
                }
            },
        components: {
            BookingListReadForm,
            MainPageForm,
            FooterForm,
            BookingBoardComment
        },
        computed: {
            ...mapState(['BookingBoard']),
            ...mapState(['cakeLists'])
        },
        created () {
            this.fetchBookingBoard(this.bookingNo)
                .catch(() => {
                    alert('게시물 요청 실패')
                    this.$router.push()
                }),
            this.fetchCakeLists()
        },
        methods: {
            ...mapActions(['fetchBookingBoard']),
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