<template>
    <div class="Main">
        <main-page-form></main-page-form>

        
        <div class="wrap">
            <h3>주문서 리스트</h3>
            <br><br>
            <booking-list-page-form :bookingLists="bookingLists"></booking-list-page-form>
        </div>

        <footer-form ></footer-form>
    </div>
</template>

<script>
import MainPageForm from '@/components/layout/MainPageForm.vue'
import BookingListPageForm from '@/components/boardPage/BookingListPageForm.vue'
import FooterForm from '../../components/layout/FooterForm.vue'
import { mapState, mapActions } from 'vuex'

    export default {
        name: 'BookingListPage',
        components: {
            MainPageForm,
            BookingListPageForm,
            FooterForm
        },
        computed: {
            ...mapState(['bookingLists'])
        },
        mounted () {
            this.fetchBookingLists()
        },
        methods: {
            ...mapActions(['fetchBookingLists'])
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