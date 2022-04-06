<template>
    <div class="calenderPage">
        <h4>픽업일자 & 시간</h4>
        <v-spacer></v-spacer>
        <calender-test></calender-test>
    </div>

    
</template>

<script>
import CalenderTest from '@/components/eventBusBooking/CalenderTest.vue'

export default {
    name : 'BookingCakeForm',
    components: { 
        CalenderTest 
    }


}
    
</script>

<style scoped>

.calenderPage {
    padding: 5%;
}

</style>