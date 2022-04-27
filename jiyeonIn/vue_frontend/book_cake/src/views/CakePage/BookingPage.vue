<template>
    <div class="Main">
        <main-page-form></main-page-form>
        
        <br>
        <div class="wrap">
            <h3>예약하기</h3>
            <br>
            <booking-cake-form :cakeLists="cakeLists" :bookingListsDate="bookingListsDate" @submit="submitBooking"/>
        </div>
        
        <footer-form></footer-form>

    </div>
</template>

<script>
import BookingCakeForm from '@/components/mainPage/BookingCakeForm.vue'
import MainPageForm from '@/components/layout/MainPageForm.vue'
import FooterForm from '../../components/layout/FooterForm.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

    export default {
        name: 'BookingPage',
        components: {
            BookingCakeForm,
            MainPageForm,
            FooterForm
        },
        created () {
            if(window.localStorage.getItem('token') == null) {
                    alert('로그인을 해주세요!')
                    this.$router.push({
                        name: 'LoginPage'
                    })
                }
        },
        computed: {
            ...mapState(['cakeLists', 'bookingListsDate'])
        },
         mounted () {
            this.fetchCakeLists(), this.fetchBookingListsDate()
        },
        methods: {
            ...mapActions(['fetchCakeLists','fetchBookingListsDate']),
            submitBooking (payload) {
                const { id, date, time, contents, cakeArrNo, files1 } = payload

                let formData = new FormData()
                
                let fileInfo = { 
                id: id,
                date: date, 
                time: time, 
                contents: contents,
                cakeArrNo: cakeArrNo}
                
                formData.append(
                    "info", new Blob([JSON.stringify(fileInfo)], {type: "application/json"})
                )

                if(files1 != null) {
                    for(let idx = 0; idx < 1; idx++) {
                        formData.append('fileList', files1[idx])
                    }
                }
                
                console.log(fileInfo)
                axios.post('http://localhost:7777/booking/register', formData)
                    .then(res => {
                        alert('처리결과 :' + res.data)
                        this.$router.push({
                        name: 'BookingListPage'
                    })
                    })
                    .catch(res => {
                        alert('처리결과: ' + res.message)
                    })
            }
        }

    }
</script>

<style scoped>

.Main {
    background: #ffbaba;
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