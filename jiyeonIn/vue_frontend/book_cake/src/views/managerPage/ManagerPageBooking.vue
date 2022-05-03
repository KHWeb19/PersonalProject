<template>
    <div class="Main">
        <main-page-form></main-page-form>

        <div class="myPage">
            <manager-page-booking-form :bookingLists="bookingLists"></manager-page-booking-form>
        </div>

        <footer-form></footer-form>
    </div>
</template>

<script>
import MainPageForm from '@/components/layout/MainPageForm.vue'
import FooterForm from '@/components/layout/FooterForm.vue'
import ManagerPageBookingForm from '../../components/manager/ManagerPageBookingForm.vue'
import { mapState, mapActions } from 'vuex'

   export default {
        name : 'ManagerPageBooking',
        components: { 
            MainPageForm,
            FooterForm,
            ManagerPageBookingForm 
        },
        computed: {
            ...mapState(['bookingLists'])
        },
        mounted () {
            this.fetchBookingLists()
        },
        methods: {
            ...mapActions(['fetchBookingLists'])
        },

    }
</script>

<style scoped>

.Main {
    background: rgb(255, 186, 186);
}
.MainLogo {
    display: block; margin: 0px auto;
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