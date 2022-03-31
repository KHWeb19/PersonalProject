<template>
    <div class="Main">
        <main-page-form></main-page-form>
        
        <br>
        <div class="wrap">
            <h3>예약하기</h3>
            <br>
            <booking-cake-form></booking-cake-form>

        </div>
        
    </div>
</template>

<script>
import BookingCakeForm from '@/components/mainPage/BookingCakeForm.vue'
import MainPageForm from '@/components/mainPage/MainPageForm.vue'

    export default {
        name: 'BookingPage',
        components: {
            BookingCakeForm,
            MainPageForm
        }

    }
</script>

<style scoped>

.Main {
    background: rgb(255, 186, 186);
}
.MainLogo {
    display: block; margin: 0px auto;
}

.wrap {
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