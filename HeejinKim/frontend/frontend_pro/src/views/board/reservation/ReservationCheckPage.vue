<template>
<v-container class="writeForm">

        <v-row>
            <reservation-check  @submit="onUpdate" :reservation="reservation"/>
          <!--  <reservation-check  @submit="onUpdate"/> -->              
        </v-row>
        
    </v-container>
      
</template>

<script>


import ReservationCheck from '@/components/board/reservation/ReservationCheck.vue'
import axios from 'axios'
import { mapState,mapActions} from "vuex"; 


export default {
    name:'ReservationCheckPage',
    
    props: {
        reservationNo: {
            type: Object,
            required: true
        },
         
    },
    data () {
        return {
       
        }
    },
    computed:
    {
      ...mapState(['reservation']),    
    },

    components:{
          ReservationCheck
    },
    created () {
        this.fetchReservation(this.reservationNo)
          .catch(() => {
              alert('게시물 요청 실패!')
              console.log(this.reservationNo)
              this.$router.push()
          })
    },

    //created(){
      //   this.fetchReservation(this.reservationNo)
     //   //this.seatdata = this.$store.state.seatdata;
   // },
     methods: {

      ...mapActions(['fetchReservation']),


    onUpdate(payload) { 
      
      const{seatNumber,restSeats} = payload

      const reservationNo = this.reservationNo

      axios.post(`http://localhost:7777/reservation/checkBooking/${reservationNo}`,{ seatNumber,restSeats})
        .then(res => {

          this.$store.state.reservation = res.data
          //this.$store.state.seatTime =  res.data[0].seatTime
          this.$store.state.reservation.seatNumber =  res.data[0].seatNumber
          this.$store.state.reservation.restSeats =  res.data[0].restSeats
          
          this.restSeats = res.data.restSeats
          this.seatNumber = res.data.seatNumber
          //this.seatTime = res.data.seatTime

          alert('확인 용으로 업데이트 완료')
          this.$router.push({ name: 'Home' })
          
         
        })
        .catch(() => {
          alert('업데이트 문제!')
        })
    },
    //mounted() {
      //  this.fetchReservation(this.reservationNo)
    //},


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
     