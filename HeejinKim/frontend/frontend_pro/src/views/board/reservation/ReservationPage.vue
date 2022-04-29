<template>
  <v-container class="writeForm">
    <v-row>
      <reservation-seat-form @submit="onSubmit"/>
    </v-row>
  </v-container>    
</template>

<script>

import ReservationSeatForm from '@/components/board/reservation/ReservationSeatForm.vue'

import axios from 'axios'
import { mapState } from "vuex"; 



export default {
    name:'ReservationPage',
    
    data () {
        return {
                         
        }
    },
    created(){
      //this.userId = this.$store.state.session.userId
      this.seatTime = this.$store.state.bookInfo.seatTime
      this.seatNumber = this.$store.state.bookInfo.seatNumber
      this.restSeats = this.$store.state.bookInfo.restSeats
      this.loading = setTimeout(this.getSeatNumber, 10000)
      
    
    },  
    computed:
    {
      ...mapState(['seatTime','seatNumber','restSeats','bookInfo']),    
    },

    components:{
        ReservationSeatForm,
      
    },
    mounted() {
      //this.loading = setTimeout(this.getSeatNumber, 20000)
    

    //this.$store.state.seatTime = this.seatTime  
    //this.$store.state.seatNumber =this.seatNumber  
    //this.$store.state.restSeats = this.restSeats 
   
  },
     methods: {

        // ...mapActions(['fetchReservation']),

    onSubmit(payload) { 
      
      const{seatTime,seatNumber,restSeats} = payload

      axios.post(`http://localhost:7777/reservation/finish`,{seatTime, seatNumber,restSeats})
        .then(() => {

          this.seatTime =''
          this.seatNumber =''
          this.restSeats =''
        
          alert('예약 완료')
          this.$router.push({name: "ReservationCheckPage", params: {seatTime, seatNumber, restSeats}})     
        })
        .catch(() => {
          alert('예약 남은자리, 번호, 타임 넣는데 문제!')
        })
    },
  
    
    getSeatNumber() {

      const { seatTime,seatNumber,restSeats } = this
      
      axios.get(`http://localhost:7777/reservation/reservationList`,{ seatTime,seatNumber,restSeats })
        .then( res => {

          this.$store.state.bookInfo = res.data

          this.$store.state.seatNumber[0] =  res.data[0].seatNumber
          this.$store.state.bookInfo.restSeats[0] =  res.data[0].restSeats

          this.restSeats[0] = res.data[0].restSeats
          this.seatNumber = res.data[0].seatNumber
          this.seatTime = res.data.seatTime

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
    

</script>
     