
<template>
  <v-container class="writeForm">
    <v-row>
      <reservation-form @submit="onSubmit" :reservations="reservations"/>
    </v-row>
  </v-container>    
</template>

<script>

import ReservationForm from '@/components/board/reservation/ReservationForm.vue'

import axios from 'axios'
import { mapState,mapActions } from "vuex"; 



export default {
    name:'ReservationPage',
       
    data () {
      return {                  
      }
    },
    computed:
    {
      ...mapState(['reservation','reservations']),    
    },

    components:{
      ReservationForm,    
    },

    mounted() {

      this.fetchReservationList()
    
  },
     methods: {

    ...mapActions(['fetchReservation','fetchReservationList']),

    onSubmit(payload) { 
      
      const{id, seatNumber} = payload

     

      axios.post(`http://localhost:7777/reservation/finish`,{id,seatNumber})
        .then(() => {

          this.seatNumber ='' 
          alert('Reservation complete')
          this.$router.push({name: 'ReservationMyListPage'})
         
        })
        .catch(() => {
          alert('예약 남은자리, 번호, 타임 넣는데 문제!')
        })
    },
     
  
    /*
    getSeatNumber() {

      const {seatNumber } = this
      
      axios.get(`http://localhost:7777/reservation/reservationList`,{ seatNumber })
        .then( res => {

          this.$store.state.reservations = res.data
          this.$store.state.reservations[0].reservationNo = res.data[0].reservationNo
       
      
          //this.$store.state.reservations.seatNumber =  res.data.seatNumber 이렇게는 넣어지지 않음 
          //this.$store.state.reservations.restSeats =  res.data.restSeats



          this.seatNumber[0] = res.data[0].seatNumber
          

         

         // this.$router.push({ name: 'Home' })
        })
        .catch(() => {
        })
                
    }*/

      
    }
}
    

</script>
<!--
<template>
  <v-container class="writeForm">
    <v-row>
      <reservation-seat-form @submit="onSubmit" v-if="reservation" :reservation="reservation"/>
    </v-row>
  </v-container>    
</template>

<script>

import ReservationSeatForm from '@/components/board/reservation/ReservationSeatForm.vue'

import axios from 'axios'
import { mapState,mapActions } from "vuex"; 



export default {
    name:'ReservationPage',
    
    
    data () {
        return {
                         
        }
    },
    created(){
     
      this.loading = setTimeout(this.getSeatNumber, 10000)
      //this.userId = this.$store.state.session.userId
      //this.seatTime = this.$store.state.bookInfo.seatTime
      //this.seatNumber = this.$store.state.reservation.seatNumber
      //this.restSeats = this.$store.state.reservation.restSeats
      
    
    },  
    computed:
    {
      ...mapState(['reservation']),    
    },

    components:{
        ReservationSeatForm,
      
    },
    mounted() {

       this.fetchReservationList()
      //this.loading = setTimeout(this.getSeatNumber, 20000)
    

    //this.$store.state.seatTime = this.seatTime  
    //this.$store.state.seatNumber =this.seatNumber  
    //this.$store.state.restSeats = this.restSeats 
   
  },
     methods: {

    ...mapActions(['fetchReservation']),

    onSubmit(payload) { 
      
      const{seatNumber,restSeats} = payload

      axios.post(`http://localhost:7777/reservation/finish`,{ seatNumber,restSeats})
        .then(() => {

          
          this.seatNumber =''
          this.restSeats =''
        
          alert('예약 완료')
          this.$router.push({name: "ReservationCheckPage", params: { seatNumber, restSeats}})     
        })
        .catch(() => {
          alert('예약 남은자리, 번호, 타임 넣는데 문제!')
        })
    },
  
    
    getSeatNumber() {

      const {seatNumber,restSeats } = this
      
      axios.get(`http://localhost:7777/reservation/reservationList`,{ seatNumber,restSeats })
        .then( res => {

          this.$store.state.reservation = res.data

          this.$store.state.reservation.seatNumber[0] =  res.data[0].seatNumber
          this.$store.state.reservation.restSeats[0] =  res.data[0].restSeats

          this.restSeats[0] = res.data[0].restSeats
          this.seatNumber = res.data[0].seatNumber
          

          alert('업데이트 완료됨')

         // this.$router.push({ name: 'Home' })
        })
        .catch(() => {
          alert('예약 남은자리, 번호, 타임 넣는데 문제!')
        })
                
    }
/*
    onSubmit(payload) {

      const {seatNum}=payload

    //for(var s=0; s<this.$route.params.seatdata.length;++s){
    //seatNum = this.$route.params.seatdata[s]
        
        axios.post(`http://localhost:7777/reservation/makeReservation`, { seatNum })
        .then(() => {
          alert('자리 정보 날아감')
          //console.log(res);
          //this.seatRow = ''
          //this.seatCol = ''
          //this.seatNum=''
        })
        .catch(() => {
         alert('자리 정보 문제 발생!')
        });
    }
        
    },
    */


      
    }
}
    

</script>-->
     